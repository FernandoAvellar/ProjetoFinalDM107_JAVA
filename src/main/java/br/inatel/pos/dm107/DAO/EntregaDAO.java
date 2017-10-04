package br.inatel.pos.dm107.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import br.inatel.pos.dm107.modelos.Entrega;

public class EntregaDAO {

	private EntregaDAO() {
	}
	
	public static void criarNovaEntrega(Entrega entrega) throws SQLException {

		String sql = "INSERT INTO entrega(numeroPedido, idCliente) VALUES(?, ?)";
		try (Connection conexao = Conexao.abrirConexao(); PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setLong(1, entrega.getNumeroPedido());
			statement.setLong(2, entrega.getIdCliente());
			statement.executeUpdate();
		}
	}

	public static List<Entrega> recuperarTodasEntregas() {
		ArrayList<Entrega> entregas = new ArrayList<>();
		String sql = "SELECT numeroPedido, idCliente, nomeRecebedor, cpfRecebedor, dataRecebimento FROM entrega;";

		try (Connection conexao = Conexao.abrirConexao(); PreparedStatement statement = conexao.prepareStatement(sql)) {

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Long numeroPedido = rs.getLong("numeroPedido");
					Long idCliente = rs.getLong("idCliente");
					String nomeRecebedor = rs.getString("nomeRecebedor");
					String cpfRecebedor = rs.getString("cpfRecebedor");
					Timestamp dataTimestamp = ((Timestamp) rs.getObject("dataRecebimento"));

					LocalDateTime dataRecebimento = null;
					if (dataTimestamp != null) {
						dataRecebimento = dataTimestamp.toLocalDateTime();
					}

					Entrega entrega = new Entrega(numeroPedido, idCliente, nomeRecebedor, cpfRecebedor, dataRecebimento);
					entregas.add(entrega);
				}
			}
		} catch (Exception ex) {
			Logger.error(ex, "Falha na busca de todas às entregas!");
		}

		return entregas;
	}

	public static Entrega recuperarEntregaPeloNumeroDoPedido(Long numeroPedidoParaBusca) {
		Entrega entrega = null;
		String sql = "SELECT * FROM entrega WHERE numeroPedido=?;";

		try (Connection conexao = Conexao.abrirConexao(); PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setLong(1, numeroPedidoParaBusca);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Long numeroPedido = rs.getLong("numeroPedido");
					Long idCliente = rs.getLong("idCliente");
					String nomeRecebedor = rs.getString("nomeRecebedor");
					String cpfRecebedor = rs.getString("cpfRecebedor");
					Timestamp dataTimestamp = ((Timestamp) rs.getObject("dataRecebimento"));

					LocalDateTime dataRecebimento = null;
					if (dataTimestamp != null) {
						dataRecebimento = dataTimestamp.toLocalDateTime();
					}
					
					entrega = new Entrega(numeroPedido, idCliente, nomeRecebedor, cpfRecebedor, dataRecebimento);
				}
			}
		} catch (Exception ex) {
			Logger.error(ex, "Falha na busca das entregas!");
		}

		return entrega;
	}
}
