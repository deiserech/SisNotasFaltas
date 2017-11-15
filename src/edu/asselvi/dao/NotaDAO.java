package edu.asselvi.dao;

import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.model.Nota;

public class NotaDAO implements GenericDAO<Nota>{

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
	public boolean insereTrn(List<Nota> t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Nota consulta(int id) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nota> consulta() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altera(Nota t) throws BDException {
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
