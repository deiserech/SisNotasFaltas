package edu.asselvi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;

public class Conexao {

	private static Connection conn = null;

	public static Connection getConexao() throws BDException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lorena?useSSL=true", "lorena", "lorena1509");
			return conn;
		} catch (Exception e) {
			throw new BDException(EErrosBD.ABRE_CONEXAO, e.getMessage());
		}
	}
	
	public static void closeConexao() throws BDException {
		try {
			if (conn != null) conn.close();
			conn = null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.FECHA_CONEXAO, e.getMessage());
		}
	}
}
