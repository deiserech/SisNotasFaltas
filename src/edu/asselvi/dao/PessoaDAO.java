package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.Statement;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.model.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa>{

//	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE pessoa (" +
					   "	id		INTEGER NOT NULL PRIMARY KEY," +
					   "	nome			VARCHAR(45)  NOT NULL," +
					   "	endereco    	VARCHAR(100) NOT NULL," +
					   "	cpf         	VARCHAR(14)  NOT NULL," +
					   "	telefone    	VARCHAR(13)  NOT NULL," +
					   "	dataNascimento	DATE         NOT NULL," +
					   "	email	    	VARCHAR(50)  NOT NULL," +
					   "	sexo			CHAR(1) NOT  NULL" +
					   ");");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
//
//	@Override
//	public boolean destroiTabela() throws BDException {
//		Connection conexao = Conexao.getConexao();
//		try {
//			Statement st = conexao.createStatement();
//			st.execute("DROP TABLE pessoa;");
//			return true;
//		} catch (Exception e) {
//			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
//		} finally {
//			Conexao.closeConexao();
//		}
//	}

}
