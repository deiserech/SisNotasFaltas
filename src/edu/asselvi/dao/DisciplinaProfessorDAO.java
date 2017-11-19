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
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.model.DisciplinaProfessor;

public class DisciplinaProfessorDAO implements GenericDAO<DisciplinaProfessor> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE disciplinaProfessor (" + "	"
					+ " DisciplinaId	INTEGER NOT NULL,"
					+ " ProfessorId		INTEGER NOT NULL," 
					+ " PRIMARY KEY 	(DisciplinaId, ProfessorId)"
					+ " );");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean destroiTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE disciplinaProfessor;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean insereTrn(List<DisciplinaProfessor> disciplinaProfessores) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao
					.prepareStatement("INSERT INTO disciplinaProfessor (ProfessorId, DisciplinaId ) VALUES (?,?);");
			for (DisciplinaProfessor disciplinaProfessor : disciplinaProfessores) {
				pst.setInt(1, disciplinaProfessor.getDisciplinaId());
				pst.setInt(2, disciplinaProfessor.getProfessorId());
				pst.executeUpdate();
			}
			conexao.commit();
			return true;
		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (Exception e2) {
				throw new BDException(EErrosBD.ROLLBACK, e2.getMessage(), this.getClass().getSimpleName());
			}
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public DisciplinaProfessor consulta(int id) throws BDException {
		return null;
	}

	public DisciplinaProfessor consulta(int disciplinaId, int professorId) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("SELECT * FROM disciplinaProfessor WHERE DisciplinaId = ? AND ProfessorId = ?;");
			pst.setInt(1, disciplinaId);
			pst.setInt(1, professorId);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new DisciplinaProfessor(rs.getInt("DisciplinaId"), rs.getInt("ProfessorId")) : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<DisciplinaProfessor> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<DisciplinaProfessor> disciplinaProfessores = new ArrayList<DisciplinaProfessor>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM disciplinaProfessor;");
			while (rs.next()) {
				disciplinaProfessores.add(new DisciplinaProfessor(rs.getInt("DisciplinaId"), rs.getInt("ProfessorId")));
			}
			return disciplinaProfessores;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(DisciplinaProfessor disciplinaProfessor) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("UPDATE disciplinaProfessor SET ProfessorId = ? WHERE DisciplinaId = ?;");
			pst.setInt(1, disciplinaProfessor.getProfessorId());
			pst.setInt(2, disciplinaProfessor.getDisciplinaId());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.ALTERA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean exclui(int id) throws BDException {
		return false;
	}

	public boolean exclui(int disciplinaId, int professorId) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("DELETE FROM disciplinaProfessor WHERE DisciplinaId = ? and ProfessorId = ? ;");
			pst.setInt(1, disciplinaId);
			pst.setInt(1, professorId);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.EXCLUI_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public int retornaProximoId() throws BDException {
		return 0;
	}

	
	public List<Integer> consultaDisciplinas(int professorId) throws BDException {
		List<Integer> disciplinas = new ArrayList<Integer>();
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("SELECT * FROM disciplinaProfessor WHERE ProfessorId = ?;");
			pst.setInt(1, professorId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				disciplinas.add(rs.getInt("DisciplinaId"));
			}
			return disciplinas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

}
