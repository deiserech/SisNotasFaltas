package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.model.Horario;

public class HorarioDAO implements GenericDAO<Horario>{


	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE horario (" + "	"
					+ " HorarioId		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " TurmaId			INTEGER NOT NULL ," 
					+ " DisciplinaId 	INTEGER NOT NULL ," 
					+ "	diaSemana	    INTEGER NOT NULL," 
					+ "	horaInicio		VARCHAR(50) NOT NULL,"  
					+ "CONSTRAINT `FK__turma` FOREIGN KEY (`turmaId`) REFERENCES `turma` (`turmaId`),"
					+ "CONSTRAINT `FK__disciplina` FOREIGN KEY (`disciplinaId`) REFERENCES `disciplina` (`disciplinaId`)"
					+ ");");
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
			st.execute("DROP TABLE horario;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	

	@Override
	public boolean insereTrn(List<Horario> horarios) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO horario ( TurmaId, DisciplinaId, diaSemana, horaInicio) VALUES (?, ?, ?, ?);");
				for (Horario horario : horarios) {
					pst.setInt(1, horario.getTurmaId());
					pst.setInt(2, horario.getDisciplinaId());
					pst.setInt(3, horario.getDiaSemana());
					pst.setString(4, horario.getHoraInicio());
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
	public Horario consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM horario WHERE HorarioId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Horario(rs.getInt("HorarioId"),
										rs.getInt("diaSemana"),
										rs.getInt("DisciplinaId"),
										rs.getInt("TurmaId"),
										rs.getString("horaInicio"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<Horario> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Horario> horarios = new ArrayList<Horario>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM horario;");
			while(rs.next()) {
				horarios.add(new Horario(rs.getInt("HorarioId"),
						   rs.getInt("TurmaId"),
						   rs.getInt("DisciplinaId"),
						   rs.getInt("diaSemana"),
						   rs.getString("horaInicio")));
			}
			return horarios;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public Horario consulta(int idTurma, int idDisciplina,int idSerie, int diaSemana) throws BDException {
		Connection conexao = Conexao.getConexao();
		Horario horario = new Horario();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM horario where TurmaId = ? and DisciplinaId = ? and diaSemana = ?;");
			pst.setInt(1, idTurma);
//			pst.setInt(2, idSerie);
			pst.setInt(2, idDisciplina);
			pst.setInt(3, diaSemana);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				horario =  new Horario(rs.getInt("HorarioId"),
							rs.getInt("diaSemana"),
							rs.getInt("DisciplinaId"),
							rs.getInt("TurmaId"),
							rs.getString("horaInicio"));
			}
			return horario; 
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	
	@Override
	public boolean altera(Horario horario) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE horario SET TurmaId = ?, DisciplinaId = ?, SerieId = ?, diaSemana = ?, horaInicio = ? WHERE HorarioId = ?;");
			pst.setInt(1, horario.getTurmaId());
			pst.setInt(2, horario.getDisciplinaId());
			pst.setInt(4, horario.getDiaSemana());
			pst.setString(5, horario.getHoraInicio());
			
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.ALTERA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean exclui(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM horario WHERE HorarioId = ?;");
			pst.setInt(1, id);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.EXCLUI_DADO, e.getMessage(), this.getClass().getSimpleName());
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
			ResultSet rs = st.executeQuery("SELECT MAX(HorarioId) FROM horario;");
			while(rs.next()) {
				proximoId = rs.getInt("MAX(HorarioId)") + 1;
			}
			return proximoId;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

}
