package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.Turma;

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
	
	public Map<Integer, Integer> consultaAlunosTurma(int idTurma) throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Integer> alunos = new HashMap<Integer, Integer>();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM aluno where IdTurma = ?;");
			pst.setInt(1, idTurma);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				alunos.put(rs.getInt("IdTurma"),
						   rs.getInt("IdAluno"));
			}
			return alunos;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}


}
