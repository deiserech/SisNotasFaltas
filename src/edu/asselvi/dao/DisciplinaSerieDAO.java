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
import edu.asselvi.model.DisciplinaSerie;

public class DisciplinaSerieDAO implements GenericDAO<DisciplinaSerie> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE disciplinaSerie (" + "	" 
					+ " DisciplinaId		INTEGER NOT NULL,"
					+ " SerieId				INTEGER NOT NULL,"
					+ " PRIMARY KEY 		(DisciplinaId, SerieId)"
					+ " );");
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
			st.execute("DROP TABLE disciplinaSerie;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean insereTrn(List<DisciplinaSerie> disciplinaSeries) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao
					.prepareStatement("INSERT INTO disciplinaSerie ( DisciplinaId, SerieId) VALUES (?, ?);");
			for (DisciplinaSerie disciplinaSerie : disciplinaSeries) {
				pst.setInt(1, disciplinaSerie.getDisciplinaId());
				pst.setInt(2, disciplinaSerie.getSerieId());
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
	public DisciplinaSerie consulta(int id) throws BDException {
		return null;
	}

	public DisciplinaSerie consulta(int disciplinaId, int serieId) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("SELECT * FROM disciplinaSerie WHERE DisciplinaId = ? AND SerieId = ?;");
			pst.setInt(1, disciplinaId);
			pst.setInt(2, serieId);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new DisciplinaSerie(rs.getInt("DisciplinaId"), rs.getInt("SerieId")) : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<DisciplinaSerie> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<DisciplinaSerie> disciplinaSeries = new ArrayList<DisciplinaSerie>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM disciplinaSerie;");
			while (rs.next()) {
				disciplinaSeries.add(new DisciplinaSerie(rs.getInt("DisciplinaId"), rs.getInt("SerieId")));
			}
			return disciplinaSeries;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(DisciplinaSerie disciplinaSerie) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("UPDATE disciplinaSerie SET SerieId = ? WHERE DisciplinaId = ?;");
			pst.setInt(1, disciplinaSerie.getSerieId());
			pst.setInt(2, disciplinaSerie.getDisciplinaId());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.ALTERA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean exclui(int id) throws BDException {
		return false;
	}

	public boolean exclui(int disciplinaId, int serieId) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("DELETE FROM disciplinaSerie WHERE DisciplinaId = ? AND SerieId = ?;");
			pst.setInt(1, disciplinaId);
			pst.setInt(2, serieId);
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.EXCLUI_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public int retornaProximoId() throws BDException {
		return 0;
	}


}
