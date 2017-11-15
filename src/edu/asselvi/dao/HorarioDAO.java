package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Horario;
import edu.asselvi.model.Pessoa;

public class HorarioDAO implements GenericDAO<Horario>{

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
	public boolean insereTrn(List<Horario> t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Horario consulta(int id) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Horario> consulta() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altera(Horario t) throws BDException {
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
