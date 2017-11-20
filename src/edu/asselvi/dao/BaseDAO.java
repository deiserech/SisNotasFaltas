package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.Statement;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.conexao.Conexao;

public class BaseDAO {
	public boolean criaBase(String ip, String base, String useSSL, String login, String senha ) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE DATABASE " + base + ";");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_BASE, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
}
