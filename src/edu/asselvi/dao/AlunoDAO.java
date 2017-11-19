package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Aluno;

public class AlunoDAO implements GenericDAO<Aluno>{

	@Override
	public boolean criaTabela() throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean destroiTabela() throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insereTrn(List<Aluno> t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Aluno consulta(int id) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> consulta() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altera(Aluno t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exclui(int id) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int retornaProximoId() throws BDException {
		// TODO Auto-generated method stub
		return 0;
	}

}
