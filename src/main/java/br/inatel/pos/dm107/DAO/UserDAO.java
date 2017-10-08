package br.inatel.pos.dm107.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.pmw.tinylog.Logger;

public class UserDAO {

	public static String recuperaSenhaDeUmUsuario(String usuario) {
		String senha = null;
		String sql = "SELECT * FROM usuario WHERE usuario=?;";

		try (Connection conexao = Conexao.abrirConexao(); PreparedStatement statement = conexao.prepareStatement(sql)) {
			statement.setString(1, usuario);
			ResultSet rs = statement.executeQuery();
			rs.next();
			senha = rs.getString("senha");
		} catch (Exception ex) {
			Logger.error(ex, "Falha na busca da senha do usuario!");
		}
		return senha;
	}
}
