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
import edu.asselvi.model.Disciplina;

public class DisciplinaDAO implements GenericDAO<Disciplina>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE disciplina (" + "	"
					+ " DisciplinaId	INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " descricao		VARCHAR(50) NOT NULL "
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
			st.execute("DROP TABLE disciplina;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public boolean insereTrn(List<Disciplina> disciplinas) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO disciplina ( descricao) VALUES (?);");
				for (Disciplina disciplina : disciplinas) {
					pst.setString(1, disciplina.getDescricao());
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
	public Disciplina consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM disciplina WHERE DisciplinaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Disciplina(rs.getInt("DisciplinaId"),
										   rs.getString("descricao"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}


	@Override
	public List<Disciplina> consulta() throws BDException {
		Connection conexao = Conexao.getConexao(true);
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM disciplina;");
			while(rs.next()) {
				disciplinas.add(new Disciplina(rs.getInt("DisciplinaId"),
										   rs.getString("descricao")));
			}
			return disciplinas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}


	@Override
	public boolean altera(Disciplina disciplina) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE disciplina SET descricao = ? WHERE DisciplinaId = ?;");
			pst.setString(1, disciplina.getDescricao());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM disciplina WHERE DisciplinaId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM disciplina;");
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
	

	public Map<Integer, Disciplina> consultaIds() throws BDException {
		Connection conexao = Conexao.getConexao(true);
		Map<Integer, Disciplina> disciplinas = new HashMap<Integer, Disciplina>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM disciplina;");
			while(rs.next()) {
				disciplinas.put(rs.getInt("disciplinaId"),
						new Disciplina(rs.getInt("disciplinaId"),
										rs.getString("descricao")));
			}
			return disciplinas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public Map<Integer, Disciplina> consultaDescricao(List<Integer> disc) throws BDException {
		Map<Integer, Disciplina> disciplinas = new HashMap<Integer, Disciplina>();
		Connection conexao = Conexao.getConexao(true);
		try {
			for(Integer dc : disc) {
				PreparedStatement pst = conexao.prepareStatement("SELECT * FROM disciplina WHERE DisciplinaId = ?;");
				pst.setInt(1, dc);
				ResultSet rs = pst.executeQuery();
				if(rs.first()) {
								disciplinas.put(rs.getInt("DisciplinaId"),
											new Disciplina(	rs.getInt("DisciplinaId"),
															rs.getString("descricao")));
				};
			}
			return disciplinas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public void exportaDados(String nomeArq, String separador) throws BDException {
        List<String> exporta = new ArrayList<String>();
        Iterator<Disciplina> var5 = this.consulta().iterator();

        while(var5.hasNext()) {
            Disciplina disciplina = (Disciplina)var5.next();
            exporta.add(disciplina.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }

	public boolean insereVariosTrn(List<Disciplina> disciplinas) throws BDException {
        Connection conexao = Conexao.getConexao(true);

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO disciplina ( descricao) VALUES (?);");
            Iterator<Disciplina> var5 = disciplinas.iterator();

            while(var5.hasNext()) {
            	Disciplina disciplina = (Disciplina)var5.next();
            	pst.setString(1, disciplina.getDescricao());
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
