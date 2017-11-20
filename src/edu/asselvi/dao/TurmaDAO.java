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
import edu.asselvi.model.Turma;
import edu.asselvi.model.Usuario;

public class TurmaDAO implements GenericDAO<Turma>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE turma (" + "	"
					+ " TurmaId	 		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " SerieId 		INTEGER NOT NULL ," 
					+ "	descricao		VARCHAR(50)  NOT NULL," 
					+ "	vagas	    	INTEGER(3)  NOT NULL,"
					+ "	ano	     		INTEGER(4)  NOT NULL," 
					+ "CONSTRAINT `FK__serie` FOREIGN KEY (`serieId`) REFERENCES `serie` (`serieId`)"
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
			st.execute("DROP TABLE turma;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean insereTrn(List<Turma> turmas) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO turma ( SerieId, descricao, vagas, ano) VALUES (?, ?, ?, ?);");
				for (Turma turma : turmas) {
					pst.setInt(1, turma.getSerieId());
					pst.setString(2, turma.getDescricao());
					pst.setInt(3, turma.getVagas());
					pst.setInt(4, turma.getAno());
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
	public Turma consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM turma WHERE TurmaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Turma(rs.getInt("turmaId"),
										   rs.getInt("SerieId"),
										   rs.getString("descricao"),
										   rs.getInt("vagas"),
										   rs.getInt("ano"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public List<Turma> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Turma> turmas = new ArrayList<Turma>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM turma;");
			while(rs.next()) {
				turmas.add(new Turma(rs.getInt("turmaId"),
						   rs.getInt("SerieId"),
						   rs.getString("descricao"),
						   rs.getInt("vagas"),
						   rs.getInt("ano")));
			}
			return turmas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Turma turma) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE turma SET SerieId = ?, descricao = ?, vagas = ?, ano = ? WHERE TurmaId = ?;");
			pst.setInt(1, turma.getSerieId());
			pst.setString(2, turma.getDescricao());
			pst.setInt(3, turma.getVagas());
			pst.setInt(4, turma.getAno());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM turma WHERE TurmaId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT TurmaId FROM turma;");
			while(rs.next()) {
				proximoId = rs.getInt("TurmaId") + 1;
			}
			return proximoId;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public Map<Integer, Integer> consultaSerieTurmas() throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Integer> serieTurma = new HashMap<Integer, Integer>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT SerieId, TurmaId FROM turma;");
			while(rs.next()) {
				serieTurma.put(rs.getInt("TurmaId"),rs.getInt("SerieId") );			}
			return serieTurma;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public Map<Integer, Turma> consultaIds() throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Turma> series = new HashMap<Integer, Turma>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM turma;");
			while(rs.next()) {
				series.put(rs.getInt("turmaId"), 
						new Turma(rs.getInt("turmaId"),
								   rs.getInt("SerieId"),
								   rs.getString("descricao"),
								   rs.getInt("vagas"),
								   rs.getInt("ano")));
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
            Turma turma = (Turma)var5.next();
            exporta.add(turma.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }

	public boolean insereVariosTrn(List<Turma> turmas) throws BDException {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO turma ( SerieId, descricao, vagas, ano) VALUES (?, ?, ?, ?);");
            Iterator var5 = turmas.iterator();

            while(var5.hasNext()) {
            	Turma turma = (Turma)var5.next();
            	pst.setInt(1, turma.getSerieId());
				pst.setString(2, turma.getDescricao());
				pst.setInt(3, turma.getVagas());
				pst.setInt(4, turma.getAno());
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


