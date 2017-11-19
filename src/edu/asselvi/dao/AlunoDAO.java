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
import edu.asselvi.conexao.Conexao;
import edu.asselvi.enumerador.EErrosBD;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Aluno;

public class AlunoDAO implements GenericDAO<Aluno> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE pessoa (" + "	"
					+ " pessoaId		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " usuarioId		INTEGER NOT NULL ,"
					+ " perfil 		    INTEGER NOT NULL ," 
					+ "	nome			VARCHAR(50)  NOT NULL,"  
					+ "	cpf	     		VARCHAR(14)  NOT NULL," 
					+ "	dataNascimento	DATE         NOT NULL," 
					+ "	sexo			CHAR(1) NOT  NULL," 
					+ "CONSTRAINT `FK__usuario` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`usuarioId`)"
					+");");
			criaAdmin();
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public void criaAdmin() throws BDException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno(0,1,1,"Administrador","999-999-999-99",new java.util.Date(),ESexo.M));		
		insereTrn(alunos);
	}
	
	@Override
	public boolean destroiTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE pessoa;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public boolean insereTrn(List<Aluno> alunos) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO pessoa ( usuarioId, perfil, nome, cpf, dataNascimento, sexo) VALUES (?, ?, ?, ?, ?, ?);");
				for (Aluno aluno : alunos) {
				//	System.out.println(aluno.toString());
					pst.setInt(1, aluno.getCdUsuario());
					pst.setInt(2, aluno.getPerfil());
					pst.setString(3, aluno.getNome());
					pst.setString(4, aluno.getCpf());
					pst.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
					pst.setString(6, String.valueOf(aluno.getSexo().getSigla()));
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
	public Aluno consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM pessoa WHERE pessoaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Aluno(rs.getInt("pessoaId"),
										   rs.getInt("usuarioId"),
										   rs.getInt("perfil"),
										   rs.getString("nome"),
										   rs.getString("cpf"),
										   rs.getDate("dataNascimento"),
										   ESexo.valueOf(rs.getString("sexo").equals("F") ? "F":"M"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	public Aluno consultaUsuario(int usuarioId) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM pessoa WHERE usuarioId = ?;");
			pst.setInt(1, usuarioId);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Aluno(rs.getInt("pessoaId"),
										   rs.getInt("usuarioId"),
										   rs.getInt("perfil"),
										   rs.getString("nome"),
										   rs.getString("cpf"),
										   rs.getDate("dataNascimento"),
										   ESexo.valueOf(rs.getString("sexo").equals("F") ? "F":"M"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	
	@Override
	public List<Aluno> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM pessoa;");
			while(rs.next()) {
				alunos.add(new Aluno(rs.getInt("pessoaId"),
						   rs.getInt("usuarioId"),
						   rs.getInt("perfil"),
						   rs.getString("nome"),
						   rs.getString("cpf"),
						   rs.getDate("dataNascimento"),
						   ESexo.valueOf(rs.getString("sexo").equals("F") ? "F":"M")));
			}
			return alunos;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Aluno aluno) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE pessoa SET usuarioId = ?, perfil, nome = ?, cpf = ?, dataNascimento = ?, sexo = ? WHERE pessoaId = ?;");
			pst.setInt(1, aluno.getCdUsuario());
			pst.setInt(2, aluno.getPerfil());
			pst.setString(3, aluno.getNome());
			pst.setString(4, aluno.getCpf());
			pst.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
			pst.setString(6, String.valueOf(aluno.getSexo().getSigla()));
			pst.setInt(7, aluno.getId());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM pessoa WHERE pessoaId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(pessoaId) FROM pessoa;");
			while(rs.next()) {
				proximoId = rs.getInt("MAX(pessoaId)") + 1;
			}
			return proximoId;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public Map<Integer, Aluno> consultaAlunosTurma(int idTurma) throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM pessoa where IdTurma = ?;");
			pst.setInt(1, idTurma);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				alunos.put(rs.getInt("id"),
						new Aluno(rs.getInt("pessoaId"),
								   rs.getInt("cdUsuario"),
								   rs.getInt("perfil"),
								   rs.getString("nome"),
								   rs.getString("cpf"),
								   rs.getDate("dataNascimento"),
								   ESexo.valueOf(rs.getString("sexo").equals("F") ? "FEMININO":"MASCULINO")));
			}
			
			return alunos;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName() );
		} finally {
			Conexao.closeConexao();
		}
	}
	
	public Map<Integer, Aluno> consultaAlunosTurma(List<Integer> alunosL) throws BDException {
		Connection conexao = Conexao.getConexao();
		Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();
		try {
			for(Integer aluno : alunosL) {
				PreparedStatement pst = conexao.prepareStatement("SELECT * FROM pessoa where pessoaId = ?;");
				pst.setInt(1, aluno);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
						alunos.put(rs.getInt("pessoaId"),
								new Aluno(rs.getInt("pessoaId"),
										rs.getInt("usuarioId"),
										rs.getInt("perfil"),
										rs.getString("nome"),
										rs.getString("cpf"),
										rs.getDate("dataNascimento"),
										ESexo.valueOf(rs.getString("sexo").equals("F") ? "F":"M")));
				}
			}
			return alunos;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}	


}
