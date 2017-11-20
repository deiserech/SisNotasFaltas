package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Serie;
import edu.asselvi.model.Usuario;

public class SerieDAO implements GenericDAO<Serie>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE serie (" + "	"
					+ " SerieId		 		INTEGER NOT NULL PRIMARY KEY,"
					+ " CursoId				INTEGER NOT NULL ,"
					+ " descricao 		    VARCHAR(50) NOT NULL ," 
					+ "	idadeMinima			INTEGER  NOT NULL,"  
					+ "	duracao	     		INTEGER  NOT NULL," 
					+ "CONSTRAINT `FK__curso` FOREIGN KEY (`cursoId`) REFERENCES `curso` (`cursoId`)"
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
			st.execute("DROP TABLE serie;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
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
						"INSERT INTO serie ( SerieId, CursoId, descricao, idadeMinima, duracao) VALUES (?, ?, ?, ?,?);");
				for (Serie serie : series) {
					pst.setInt(1, serie.getSerieId());
					pst.setInt(2, serie.getCursoId());
					pst.setString(3, serie.getDescricao());
					pst.setInt(4, serie.getIdadeMinima());
					pst.setInt(5, serie.getDuracao());
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
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
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
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Serie serie) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE serie SET SerieId = ?, CursoId = ?, descricao = ?, idadeMinima = ?, duracao = ? WHERE SerieId = ?;");
			pst.setInt(1, serie.getSerieId());
			pst.setInt(2, serie.getCursoId());
			pst.setString(3, serie.getDescricao());
			pst.setInt(4, serie.getIdadeMinima());
			pst.setInt(5, serie.getDuracao());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM serie WHERE SerieId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM serie;");
			while(rs.next()) {
				proximoId = rs.getInt("serieId") + 1;
			}
			return proximoId;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	
	public Map<Integer, Serie> consultaIds() throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Serie> series = new HashMap<Integer, Serie>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM serie;");
			while(rs.next()) {
				series.put(rs.getInt("serieId"),
						new Serie(rs.getInt("serieId"),
								   rs.getInt("CursoId"),
								   rs.getString("descricao"),
								   rs.getInt("idadeMinima"),
								   rs.getInt("duracao")));
			}
			return series;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public void exportaDados(String nomeArq, String separador) throws BDException {
        List<String> exporta = new ArrayList();
        Iterator var5 = this.consulta().iterator();

        while(var5.hasNext()) {
            Serie serie = (Serie)var5.next();
            exporta.add(serie.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }

	public boolean insereVariosTrn(List<Serie> series) throws BDException {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO serie ( SerieId, CursoId, descricao, idadeMinima, duracao) VALUES (?, ?, ?, ?,?);");
            Iterator var5 = series.iterator();

            while(var5.hasNext()) {
                Serie serie = (Serie)var5.next();
                pst.setInt(1, serie.getSerieId());
				pst.setInt(2, serie.getCursoId());
				pst.setString(3, serie.getDescricao());
				pst.setInt(4, serie.getIdadeMinima());
				pst.setInt(5, serie.getDuracao());
				pst.executeUpdate();
            }

            conexao.commit();
            return true;
        } catch (Exception var11) {
            try {
                conexao.rollback();
            } catch (SQLException var10) {
                throw new BDException(EErosBanco.ROLLBACK, var10.getMessage());
            }

            throw new BDException(EErosBanco.INSERE_DADO, var11.getMessage());
        } finally {
            Conexao.closeConexao();
        }
    }
}
