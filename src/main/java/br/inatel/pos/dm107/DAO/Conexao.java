package br.inatel.pos.dm107.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.pmw.tinylog.Logger;

public class Conexao {

	private Conexao() {
	}

	private static final String URL = "jdbc:mysql://localhost/dm107?useSSL=false";
	private static final String USUARIO = "root";
	private static final String SENHA = "";

	public static Connection abrirConexao() {

		try {
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException ex) {
			Logger.error(ex, "Falha na conexao com o banco de dados.");
		}

		return null;
	}
}
