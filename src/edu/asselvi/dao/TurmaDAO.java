package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Turma;

public class TurmaDAO implements GenericDAO<Turma>{

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
	public boolean insereTrn(List<Turma> t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Turma consulta(int id) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Turma> consulta() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altera(Turma t) throws BDException {
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

	public Map<Integer, Integer> consultaSerieTurma() throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Integer> serieTurma = new HashMap<Integer, Integer>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT IdSerie, idTurma FROM turma;");
			while(rs.next()) {
				serieTurma.put(rs.getInt("idTurma"),rs.getInt("idSerie") );			}
			return serieTurma;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
}
