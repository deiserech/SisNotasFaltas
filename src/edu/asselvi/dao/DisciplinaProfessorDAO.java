package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.model.DisciplinaProfessor;


public class DisciplinaProfessorDAO implements GenericDAO<DisciplinaProfessor>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE disciplinaProfessor (" + "	"
					+ " DisciplinaId	INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " ProfessorId		INTEGER NOT NULL ," //adicionar foreing key
					+ ");");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_TABELA, e.getMessage());
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
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	

	@Override
	public boolean insereTrn(List<DisciplinaProfessor> disciplinaProfessores) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO disciplinaProfessor (ProfessorId ) VALUES (?);");
				for (DisciplinaProfessor disciplinaProfessor : disciplinaProfessores) {
					pst.setInt(1, disciplinaProfessor.getProfessorId());
					pst.executeUpdate();
				}
			conexao.commit();
			return true;
		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (Exception e2) {
				throw new BDException(EErrosBD.ROLLBACK, e2.getMessage());
			}
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}


	@Override
	public DisciplinaProfessor consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM disciplinaProfessor WHERE DisciplinaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new DisciplinaProfessor(rs.getInt("DisciplinaId"),
										   				rs.getInt("ProfessorId"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
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
			while(rs.next()) {
				disciplinaProfessores.add(new DisciplinaProfessor(rs.getInt("DisciplinaId"),
																  rs.getInt("ProfessorId")));
			}
			return disciplinaProfessores;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(DisciplinaProfessor disciplinaProfessor) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE disciplinaProfessor SET ProfessorId = ? WHERE DisciplinaId = ?;");
			pst.setInt(1, disciplinaProfessor.getProfessorId());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.ALTERA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean exclui(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM disciplinaProfessor WHERE DisciplinaId = ?;");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.EXCLUI_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public int retornaProximoId() throws BDException {
		Connection conexao = Conexao.getConexao();
		int proximoId = 0;
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM disciplinaProfessor;");
			while(rs.next()) {
				proximoId = rs.getInt("id") + 1;
			}
			return proximoId;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

}
