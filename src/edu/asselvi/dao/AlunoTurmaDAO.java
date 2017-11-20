package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.model.AlunoTurma;


public class AlunoTurmaDAO implements GenericDAO<AlunoTurma> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE alunoTurma (" + "	" + " AlunoId		 		INTEGER NOT NULL,"
					+ " TurmaId				INTEGER NOT NULL," + " PRIMARY KEY 		(AlunoId, TurmaId)" + " );");
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
			st.execute("DROP TABLE alunoTurma;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean insereTrn(List<AlunoTurma> alunoTurmas) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao
					.prepareStatement("INSERT INTO alunoTurma (AlunoId, TurmaId ) VALUES (?, ?);");
			for (AlunoTurma alunoTurma : alunoTurmas) {
				pst.setInt(1, alunoTurma.getAlunoId());
				pst.setInt(2, alunoTurma.getTurmaId());
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
	public AlunoTurma consulta(int id) throws BDException {
		return null;
	}

	public AlunoTurma consulta(int AlunoId, int TurmaId) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("SELECT * FROM alunoTurma WHERE AlunoId = ? AND TurmaId = ?;");
			pst.setInt(1, AlunoId);
			pst.setInt(2, TurmaId);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new AlunoTurma(rs.getInt("AlunoId"), rs.getInt("TurmaId")) : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<AlunoTurma> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<AlunoTurma> alunoTurmas = new ArrayList<AlunoTurma>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM AlunoTurma;");
			while (rs.next()) {
				alunoTurmas.add(new AlunoTurma(rs.getInt("AlunoId"), rs.getInt("TurmaId")));
			}
			return alunoTurmas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(AlunoTurma alunoTurma) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE alunoTurma SET TurmaId = ? WHERE id = AlunoId;");
			pst.setInt(1, alunoTurma.getAlunoId());
			pst.setInt(2, alunoTurma.getTurmaId());
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

	public boolean exclui(int AlunoId, int TurmaId) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("DELETE FROM alunoTurma WHERE AlunoId = ? AND TurmaId = ?;");
			pst.setInt(1, AlunoId);
			pst.setInt(2, TurmaId);
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

	public List<Integer> consultaAlunosTurma(int idTurma) throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Integer> alunoTurmas = new ArrayList<Integer>();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM alunoTurma where turmaId = ?;");
			pst.setInt(1, idTurma);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				alunoTurmas.add(rs.getInt("AlunoId"));
			}
			return alunoTurmas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public void exportaDados(String nomeArq, String separador) throws BDException {
        List<String> exporta = new ArrayList<String>();
        Iterator<AlunoTurma> var5 = this.consulta().iterator();

        while(var5.hasNext()) {
            AlunoTurma alunoTurma = (AlunoTurma)var5.next();
            exporta.add(alunoTurma.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }
	
	public boolean insereVariosTrn(List<AlunoTurma> alunoTurmas) throws BDException {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO alunoTurma (AlunoId, TurmaId ) VALUES (?, ?);");
            Iterator<AlunoTurma> var5 = alunoTurmas.iterator();

            while(var5.hasNext()) {
            	AlunoTurma alunoTurma = (AlunoTurma)var5.next();
            	pst.setInt(1, alunoTurma.getAlunoId());
				pst.setInt(2, alunoTurma.getTurmaId());
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
