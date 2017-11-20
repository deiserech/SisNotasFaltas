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
import edu.asselvi.model.Nota;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Usuario;

public class NotaDAO implements GenericDAO<Nota> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE nota (" + "	"
					+ " NotaId		 		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " AlunoId				INTEGER NOT NULL ," 
					+ " DisciplinaId 		INTEGER NOT NULL ,"
					+ "	BimestreId			INTEGER NOT NULL," 
					+ " nrNota		 		INTEGER NOT NULL,"
					+ "	nota	     		FLOAT  NOT NULL,"
					+ "CONSTRAINT `FK_nota_bimestre` FOREIGN KEY (`BimestreId`) REFERENCES `bimestre` (`BimestreId`),"
					+ "CONSTRAINT `FK_nota_disciplina` FOREIGN KEY (`DisciplinaId`) REFERENCES `disciplina` (`DisciplinaId`),"
					+ "CONSTRAINT `FK_nota_pessoa` FOREIGN KEY (`AlunoId`) REFERENCES `pessoa` (`pessoaId`)" + ");");
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
			st.execute("DROP TABLE nota;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean insereTrn(List<Nota> notas) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
			PreparedStatement pst = conexao.prepareStatement(
					"INSERT INTO nota ( AlunoId, DisciplinaId, BimestreId, nota, nrNota) VALUES (?, ?, ?, ?, ?);");
			for (Nota nota : notas) {
				Nota notaBanco = consulta(nota.getAlunoId(),nota.getDisciplinaId(),nota.getBimestreId(), nota.getNrNota() );
				if (notaBanco == null) {
					System.out.println("insere");
					pst.setInt(1, nota.getAlunoId());
					pst.setInt(2, nota.getDisciplinaId());
					pst.setInt(3, nota.getBimestreId());
					pst.setFloat(4, nota.getNota());
					pst.setInt(5, nota.getNrNota());
					pst.executeUpdate();
				}else {
					System.out.println("altera");
					nota.setNotaId(notaBanco.getNotaId());
					altera(nota);
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
	public Nota consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM nota WHERE NotaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first()
					? new Nota(rs.getInt("NotaId"),
							rs.getInt("AlunoId"), 
							rs.getInt("DisciplinaId"),
							rs.getInt("BimestreId"), 
							rs.getFloat("nota"),
							rs.getInt("nrNota"))
					: null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public List<Nota> consultaNotasAluno(int alunoId) throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Nota> notas = new ArrayList<Nota>();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("SELECT * FROM nota WHERE AlunoId = ? order by BimestreId, DisciplinaId ;");
			pst.setInt(1, alunoId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				notas.add(new Nota(rs.getInt("NotaId"), 
						rs.getInt("AlunoId"), 
						rs.getInt("DisciplinaId"),
						rs.getInt("BimestreId"), 
						rs.getFloat("nota"),
						rs.getInt("nrNota")
						));
			}
			return notas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Nota nota) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement(
					"UPDATE nota SET AlunoId = ?, DisciplinaId = ?, BimestreId = ?, nota = ? WHERE NotaId = ? and nrNota = ?;");
			pst.setInt(1, nota.getAlunoId());
			pst.setInt(2, nota.getDisciplinaId());
			pst.setInt(3, nota.getBimestreId());
			pst.setFloat(4, nota.getNota());
			pst.setFloat(5, nota.getNotaId());
			pst.setInt(6, nota.getNrNota());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM nota WHERE NotaId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM nota;");
			while (rs.next()) {
				proximoId = rs.getInt("MAX(ID)") + 1;
			}
			return proximoId;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<Nota> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Nota> notas = new ArrayList<Nota>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM nota;");
			while (rs.next()) {
				notas.add(new Nota(rs.getInt("NotaId"), 
						rs.getInt("AlunoId"), 
						rs.getInt("DisciplinaId"),
						rs.getInt("BimestreId"), 
						rs.getFloat("nota"),
						rs.getInt("nrNota")));
			}
			return notas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public List<Nota> consultaNotasTurma(Map<Integer, Pessoa> alunos) throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Nota> notas = new ArrayList<Nota>();
		try {
			for (Pessoa aluno : alunos.values()) {
				PreparedStatement pst = conexao.prepareStatement("SELECT * FROM nota WHERE AlunoId = ? ;");
				pst.setInt(1, aluno.getId());
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					notas.add(new Nota(rs.getInt("NotaId"), 
							rs.getInt("AlunoId"), 
							rs.getInt("DisciplinaId"),
							rs.getInt("BimestreId"), 
							rs.getFloat("nota"),
							rs.getInt("nrNota")));
				}
			}
			return notas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public Nota consulta(int alunoId, int disciplinaId, int bimestreId, int nrNota) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao
					.prepareStatement("SELECT * FROM nota WHERE alunoId = ? AND disciplinaId = ? AND bimestreId = ? and nrNota = ? ;");
			pst.setInt(1, alunoId);
			pst.setInt(2, disciplinaId);
			pst.setInt(3, bimestreId);
			pst.setInt(4, nrNota);
			ResultSet rs = pst.executeQuery();
			return rs.first()
					? new Nota(rs.getInt("NotaId"), 
							rs.getInt("AlunoId"), 
							rs.getInt("DisciplinaId"),
							rs.getInt("BimestreId"), 
							rs.getFloat("nota"),
							rs.getInt("nrNota"))
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
            Nota nota = (Nota)var5.next();
            exporta.add(nota.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }

	public boolean insereVariosTrn(List<Nota> notas) throws BDException {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);
            PreparedStatement pst = conexao.prepareStatement("INSERT INTO nota ( AlunoId, DisciplinaId, BimestreId, nota, nrNota) VALUES (?, ?, ?, ?, ?);");
            Iterator var5 = notas.iterator();

            while(var5.hasNext()) {
            	Nota nota = (Nota)var5.next();
            	pst.setInt(1, nota.getAlunoId());
				pst.setInt(2, nota.getDisciplinaId());
				pst.setInt(3, nota.getBimestreId());
				pst.setFloat(4, nota.getNota());
				pst.setInt(5, nota.getNrNota());
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
