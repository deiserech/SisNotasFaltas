package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.Statement;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.controller.Sistema;

public class BaseDAO {
	public boolean criaBase() throws BDException {
		Connection conexao = Conexao.getFirstConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE DATABASE " + Sistema.base.getBase() + ";");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_BASE, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
}
