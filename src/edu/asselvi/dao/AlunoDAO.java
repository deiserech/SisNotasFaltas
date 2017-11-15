package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;
import edu.asselvi.conexao.Conexao;
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
	
	public Map<Integer, Aluno> consultaAlunosTurma(int idTurma) throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM aluno where IdTurma = ?;");
			pst.setInt(1, idTurma);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				alunos.put(rs.getInt("id"),
						new Aluno(rs.getInt("pessoaId"),
								   rs.getInt("cdUsuario"),
								   rs.getInt("perfil"),
								   rs.getString("nome"),
								   rs.getString("cpf"),
								   rs.getDate("dataNascimento"),
								   ESexo.valueOf(rs.getString("sexo").equals("F") ? "FEMININO":"MASCULINO")));
			}
			
			return alunos;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
}
