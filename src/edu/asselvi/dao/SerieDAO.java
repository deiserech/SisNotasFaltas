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
import edu.asselvi.model.Serie;

public class SerieDAO implements GenericDAO<Serie>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE serie (" + "	"
					+ " SerieId		 		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " CursoId				INTEGER NOT NULL ," //adicionar foreing key
					+ " descricao 		    VARCHAR(50) NOT NULL ," 
					+ "	idadeMinima			INTEGER  NOT NULL,"  
					+ "	duracao	     		INTEGER  NOT NULL" + ");"); //o que faz com a lista de disciplinas?
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
			st.execute("DROP TABLE serie;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean insereTrn(List<Serie> series) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO serie ( CursoId, descricao, idadeMinima, duracao) VALUES (?, ?, ?, ?);");
				for (Serie serie : series) {
					pst.setInt(1, serie.getCursoId());
					pst.setString(2, serie.getDescricao());
					pst.setInt(3, serie.getIdadeMinima());
					pst.setInt(4, serie.getDuracao());
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
	public Serie consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM serie WHERE SerieId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Serie(rs.getInt("SerieId"),
										   rs.getInt("CursoId"),
										   rs.getString("descricao"),
										   rs.getInt("idadeMinima"),
										   rs.getInt("duracao"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public List<Serie> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Serie> series = new ArrayList<Serie>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM serie;");
			while(rs.next()) {
				series.add(new Serie(rs.getInt("SerieId"),
						   rs.getInt("CursoId"),
						   rs.getString("descricao"),
						   rs.getInt("idadeMinima"),
						   rs.getInt("duracao")));
			}
			return series;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Serie serie) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE serie SET CursoId = ?, descricao = ?, idadeMinima = ?, duracao = ? WHERE SerieId = ?;");
			pst.setInt(1, serie.getCursoId());
			pst.setString(2, serie.getDescricao());
			pst.setInt(3, serie.getIdadeMinima());
			pst.setInt(4, serie.getDuracao());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM serie WHERE SerieId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM serie;");
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
	
	
	public Map<Integer, Integer> consultaIds() throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Integer> series = new HashMap<Integer, Integer>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT id FROM serie;");
			while(rs.next()) {
				series.put(rs.getInt("id"), rs.getInt("id"));
			}
			return series;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
}
