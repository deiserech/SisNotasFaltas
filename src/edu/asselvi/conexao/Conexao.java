package edu.asselvi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.controller.Sistema;
import edu.asselvi.enumerador.EErrosBD;

public class Conexao {

	private static Connection conn = null;

	public static Connection getConexao(boolean naBase) throws BDException {
		try {
			String url = "jdbc:mysql:"
							+ Sistema.base.getUrl() + "/"
							+ (naBase? Sistema.base.getBase(): "") 
							+ "?useSSL="	+ Sistema.base.getUseSSL() ;
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection( url, Sistema.base.getLogin(), Sistema.base.getSenha());
			return conn;
		} catch (Exception e) {
			throw new BDException(EErrosBD.ABRE_CONEXAO, e.getMessage(), "Conexao");
		}
	}
	
	public static void closeConexao() throws BDException {
		try {
			if (conn != null) conn.close();
			conn = null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.FECHA_CONEXAO, e.getMessage(), "Conexao");
		}
	}
}
