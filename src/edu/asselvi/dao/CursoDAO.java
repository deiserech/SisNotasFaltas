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
import edu.asselvi.model.Curso;


public class CursoDAO implements GenericDAO<Curso>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE curso (" + "	"
					+ " CursoId		 		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " EscolaId			INTEGER NOT NULL ," 
					+ " numSeries 		    INTEGER NOT NULL ," 
					+ "	descricao			VARCHAR(50)  NOT NULL,"
					+ "CONSTRAINT `FK__escolaId` FOREIGN KEY (`escolaId`) REFERENCES `escola` (`escolaId`)"
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
		Connection conexao = Conexao.getConexao(true);
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE curso;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public boolean insereTrn(List<Curso> cursos) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO curso ( EscolaId, numSeries, descricao) VALUES (?, ?, ?);");
				for (Curso curso : cursos) {
					pst.setInt(1, curso.getEscolaId());
					pst.setInt(2, curso.getNumSeries());
					pst.setString(3, curso.getDescricao());
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
	public Curso consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM curso WHERE CursoId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Curso(rs.getInt("CursoId"),
										   rs.getInt("EscolaId"),
										   rs.getInt("numSeries"),
										   rs.getString("descricao"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}


	@Override
	public List<Curso> consulta() throws BDException {
		Connection conexao = Conexao.getConexao(true);
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM curso;");
			while(rs.next()) {
				cursos.add(new Curso(rs.getInt("CursoId"),
						   rs.getInt("EscolaId"),
						   rs.getInt("numSeries"),
						   rs.getString("descricao")));
			}
			return cursos;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Curso curso) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE curso SET EscolaId = ?, numSeries = ?, descricao = ? WHERE CursoId = ?;");
			pst.setInt(1, curso.getEscolaId());
			pst.setInt(2, curso.getNumSeries());
			pst.setString(3, curso.getDescricao());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			throw new BDException(EErrosBD.ALTERA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public boolean exclui(int id) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM curso WHERE CursoId = ?;");
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
		Connection conexao = Conexao.getConexao(true);
		int proximoId = 0;
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM curso;");
			while(rs.next()) {
				proximoId = rs.getInt("id") + 1;
			}
			return proximoId;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public Map<Integer, Curso> consultaIds() throws BDException {
		Connection conexao = Conexao.getConexao(true);
		Map<Integer, Curso> series = new HashMap<Integer, Curso>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM curso;");
			while(rs.next()) {
				series.put(rs.getInt("cursoId"), 
						new Curso(rs.getInt("cursoId"),
								   rs.getInt("EscolaId"),
								   rs.getInt("numSeries"),
								   rs.getString("descricao")));
			}
			return series;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public void exportaDados(String nomeArq, String separador) throws BDException {
        List<String> exporta = new ArrayList<String>();
        Iterator<Curso> var5 = this.consulta().iterator();

        while(var5.hasNext()) {
            Curso curso = (Curso)var5.next();
            exporta.add(curso.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }

	public boolean insereVariosTrn(List<Curso> cursos) throws BDException {
        Connection conexao = Conexao.getConexao(true);

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO curso ( EscolaId, numSeries, descricao) VALUES (?, ?, ?);");
            Iterator<Curso> var5 = cursos.iterator();

            while(var5.hasNext()) {
            	Curso curso = (Curso)var5.next();
            	pst.setInt(1, curso.getEscolaId());
				pst.setInt(2, curso.getNumSeries());
				pst.setString(3, curso.getDescricao());
				pst.executeUpdate();
            }

            conexao.commit();
            return true;
        } catch (Exception var11) {
            try {
                conexao.rollback();
            } catch (SQLException var10) {
                throw new BDException(EErrosBD.ROLLBACK, var10.getMessage(), this.getClass().getSimpleName());
            }

            throw new BDException(EErrosBD.INSERE_DADO, var11.getMessage(), this.getClass().getSimpleName());
        } finally {
            Conexao.closeConexao();
        }
    }
}
