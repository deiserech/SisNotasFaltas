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

import edu.asselvi.model.Nota;


public class NotaDAO implements GenericDAO<Nota>{

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
					+ "	nota	     		FLOAT  NOT NULL," 
					+ "CONSTRAINT `FK__aluno` FOREIGN KEY (`alunoId`) REFERENCES `aluno` (`alunoId`)"
					+ "CONSTRAINT `FK__disciplina` FOREIGN KEY (`disciplinaId`) REFERENCES `disciplina` (`disciplinaId`)"
					+ "CONSTRAINT `FK__bimestre` FOREIGN KEY (`bimestreId`) REFERENCES `bimestre` (`bimestreId`)"
					+ ");");
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
			st.execute("DROP TABLE nota;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
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
						"INSERT INTO nota ( AlunoId, DisciplinaId, BimestreId, nota) VALUES (?, ?, ?, ?);");
				for (Nota nota : notas) {
					pst.setInt(1, nota.getAlunoId());
					pst.setInt(2, nota.getDisciplinaId());
					pst.setInt(3, nota.getBimestreId());
					pst.setFloat(4, nota.getNota());
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
	public Nota consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM nota WHERE NotaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Nota(rs.getInt("NotaId"),
										   rs.getInt("AlunoId"),
										   rs.getInt("DisciplinaId"),
										   rs.getInt("BimestreId"),
										   rs.getFloat("nota"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
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
			ResultSet rs = st.executeQuery("SELECT * FROM pessoa;");
			while(rs.next()) {
				notas.add(new Nota(rs.getInt("NotaId"),
						   rs.getInt("AlunoId"),
						   rs.getInt("DisciplinaId"),
						   rs.getInt("BimestreId"),
						   rs.getFloat("nota")));
			}
			return notas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}


	@Override
	public boolean altera(Nota nota) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE nota SET AlunoId = ?, DisciplinaId = ?, BimestreId = ?, nota = ? WHERE NotaId = ?;");
			pst.setInt(1, nota.getAlunoId());
			pst.setInt(2, nota.getDisciplinaId());
			pst.setInt(3, nota.getBimestreId());
			pst.setFloat(4, nota.getNota());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM nota WHERE NotaId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM nota;");
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

}
