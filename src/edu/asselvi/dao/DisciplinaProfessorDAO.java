package edu.asselvi.dao;

import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.model.DisciplinaProfessor;

public class DisciplinaProfessorDAO implements GenericDAO<DisciplinaProfessor>{

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
	public boolean insereTrn(List<DisciplinaProfessor> t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DisciplinaProfessor consulta(int id) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DisciplinaProfessor> consulta() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altera(DisciplinaProfessor t) throws BDException {
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
