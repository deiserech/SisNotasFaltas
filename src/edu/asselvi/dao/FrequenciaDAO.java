package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.model.Frequencia;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Usuario;


public class FrequenciaDAO implements GenericDAO<Frequencia>{

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE frequencia (" + "	"
					+ " HorarioId		 	INTEGER NOT NULL ,"
					+ " AlunoId				INTEGER NOT NULL ," 
					+ " BimestreId 		    INTEGER NOT NULL ,"
					+ "	dataAula			DATE  NOT NULL,"  
					+ " PRIMARY KEY (HorarioId, AlunoId,BimestreId, dataAula),"
					+ "	presente	     	CHAR(01)  NOT NULL"
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
			st.execute("DROP TABLE frequencia;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public boolean insereTrn(List<Frequencia> frequencias) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO frequencia ( HorarioId, AlunoId, BimestreId, dataAula, presente) VALUES (?, ?, ?, ?, ?);");
				for (Frequencia frequencia : frequencias) {
					Frequencia freqBanco = consulta(frequencia);
					if(freqBanco == null) {
						System.out.println("inclui");
						pst.setInt(1, frequencia.getHorarioId());
						pst.setInt(2, frequencia.getAlunoId());
						pst.setInt(3, frequencia.getBimestreId());
						pst.setDate(4, new java.sql.Date(frequencia.getDataAula().getTime()));
						pst.setString(5, frequencia.isPresente()? "S": "N");
						pst.executeUpdate();
					}else {
						altera(frequencia);
					}
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
	public Frequencia consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM frequencia WHERE HorarioId = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Frequencia(rs.getInt("HorarioId"),
										   rs.getInt("AlunoId"),
										   rs.getInt("BimestreId"),
										   rs.getDate("dataAula"),
										   rs.getString("presente").charAt(0) == 'S')
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<Frequencia> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Frequencia> frequencias = new ArrayList<Frequencia>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM frequencia;");
			while(rs.next()) {
				frequencias.add(new Frequencia(rs.getInt("HorarioId"),
						   rs.getInt("AlunoId"),
						   rs.getInt("BimestreId"),
						   rs.getDate("dataAula"),
						   rs.getString("presente").charAt(0) == 'S'));
			}
			return frequencias;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Frequencia frequencia) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE frequencia SET presente = ? WHERE HorarioId = ? AND AlunoId  = ? AND BimestreId = ? and dataAula = ?;");
			pst.setString(1, frequencia.isPresente()? "S": "N");
			pst.setInt(2, frequencia.getHorarioId());
			pst.setInt(3, frequencia.getAlunoId());
			pst.setInt(4, frequencia.getBimestreId());
			pst.setDate(5, new java.sql.Date(frequencia.getDataAula().getTime()));
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM frequencia WHERE HorarioId = ? AND AlunoId  = ? AND BimestreId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM frequencia;");
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

	public List<Frequencia> consultaFreqAluno(int alunoId) throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Frequencia> frequencias = new ArrayList<Frequencia>();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM frequencia WHERE AlunoId = ? order by BimestreId, DataAula ");
			pst.setInt(1, alunoId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				frequencias.add(new Frequencia(rs.getInt("HorarioId"),
						   rs.getInt("AlunoId"),
						   rs.getInt("BimestreId"),
						   rs.getDate("dataAula"),
						   rs.getString("presente").charAt(0) == 'S'));
			}
			return frequencias;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public List<Frequencia> consultaFreqTurma(Map<Integer, Pessoa> alunos) throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Frequencia> frequencias = new ArrayList<Frequencia>();
		try {
			for(Pessoa aluno: alunos.values()) {
				PreparedStatement pst = conexao.prepareStatement("SELECT * FROM frequencia WHERE AlunoId = ? ;");
				pst.setInt(1, aluno.getId());
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					frequencias.add(new Frequencia(rs.getInt("HorarioId"),
							   rs.getInt("AlunoId"),
							   rs.getInt("BimestreId"),
							   rs.getDate("dataAula"),
							   rs.getString("presente").charAt(0) == 'S'));
				}
			}
			return frequencias;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public Frequencia consulta(Frequencia frequencia) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM frequencia WHERE HorarioId = ? AND AlunoId = ? AND BimestreId = ? and dataAula = ?");
			pst.setInt(1, frequencia.getHorarioId());
			pst.setInt(2, frequencia.getAlunoId());
			pst.setInt(3, frequencia.getBimestreId());
			pst.setDate(4, new java.sql.Date(frequencia.getDataAula().getTime()));
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Frequencia(rs.getInt("HorarioId"),
										   rs.getInt("AlunoId"),
										   rs.getInt("BimestreId"),
										   rs.getDate("dataAula"),
										   rs.getString("presente").charAt(0) == 'S')
							  : null;
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
            Frequencia frequencia = (Frequencia)var5.next();
            exporta.add(frequencia.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }

	public boolean insereVariosTrn(List<Frequencia> frequencias) throws BDException {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO frequencia ( HorarioId, AlunoId, BimestreId, dataAula, presente) VALUES (?, ?, ?, ?, ?);");
            Iterator var5 = frequencias.iterator();

            while(var5.hasNext()) {
            	Frequencia frequencia = (Frequencia)var5.next();
            	pst.setInt(1, frequencia.getHorarioId());
				pst.setInt(2, frequencia.getAlunoId());
				pst.setInt(3, frequencia.getBimestreId());
				pst.setDate(4, new java.sql.Date(frequencia.getDataAula().getTime()));
				pst.setString(5, frequencia.isPresente()? "S": "N");
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
