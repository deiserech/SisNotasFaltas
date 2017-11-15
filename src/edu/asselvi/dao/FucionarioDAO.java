package edu.asselvi.dao;

import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.model.Funcionario;

public class FucionarioDAO implements GenericDAO<Funcionario>{

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
	public boolean insereTrn(List<Funcionario> t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Funcionario consulta(int id) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> consulta() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altera(Funcionario t) throws BDException {
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
