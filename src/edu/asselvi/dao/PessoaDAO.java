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
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.Pessoa;

public class PessoaDAO implements GenericDAO<Pessoa> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao(true);
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
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa(0,1,1,"Administrador","999-999-999-99",new java.util.Date(),ESexo.M));		
		insereTrn(pessoas);
	}
	
	@Override
	public boolean destroiTabela() throws BDException {
		Connection conexao = Conexao.getConexao(true);
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
	public boolean insereTrn(List<Pessoa> pessoas) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO pessoa ( usuarioId, perfil, nome, cpf, dataNascimento, sexo) VALUES (?, ?, ?, ?, ?, ?);");
				for (Pessoa pessoa : pessoas) {
					pst.setInt(1, pessoa.getCdUsuario());
					pst.setInt(2, pessoa.getPerfil());
					pst.setString(3, pessoa.getNome());
					pst.setString(4, pessoa.getCpf());
					pst.setDate(5, new java.sql.Date(pessoa.getDataNascimento().getTime()));
					pst.setString(6, String.valueOf(pessoa.getSexo().getSigla()));
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
	public Pessoa consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM pessoa WHERE pessoaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Pessoa(rs.getInt("pessoaId"),
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

	public Pessoa consultaUsuario(int usuarioId) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM pessoa WHERE usuarioId = ?;");
			pst.setInt(1, usuarioId);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Pessoa(rs.getInt("pessoaId"),
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
	public List<Pessoa> consulta() throws BDException {
		Connection conexao = Conexao.getConexao(true);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM pessoa;");
			while(rs.next()) {
				pessoas.add(new Pessoa(rs.getInt("pessoaId"),
						   rs.getInt("usuarioId"),
						   rs.getInt("perfil"),
						   rs.getString("nome"),
						   rs.getString("cpf"),
						   rs.getDate("dataNascimento"),
						   ESexo.valueOf(rs.getString("sexo").equals("F") ? "F":"M")));
			}
			return pessoas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Pessoa pessoa) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE pessoa SET usuarioId = ?, perfil, nome = ?, cpf = ?, dataNascimento = ?, sexo = ? WHERE pessoaId = ?;");
			pst.setInt(1, pessoa.getCdUsuario());
			pst.setInt(2, pessoa.getPerfil());
			pst.setString(3, pessoa.getNome());
			pst.setString(4, pessoa.getCpf());
			pst.setDate(5, new java.sql.Date(pessoa.getDataNascimento().getTime()));
			pst.setString(6, String.valueOf(pessoa.getSexo().getSigla()));
			pst.setInt(7, pessoa.getId());
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
		Connection conexao = Conexao.getConexao(true);
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
		Connection conexao = Conexao.getConexao(true);
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
	
	public Map<Integer, Pessoa> consultaAlunosTurma(List<Integer> alunos) throws BDException {
		Connection conexao = Conexao.getConexao(true);
		Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();
		try {
			for(Integer aluno : alunos) {
				PreparedStatement pst = conexao.prepareStatement("SELECT * FROM pessoa where pessoaId = ?;");
				pst.setInt(1, aluno);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
						pessoas.put(rs.getInt("pessoaId"),
								new Pessoa(rs.getInt("pessoaId"),
										rs.getInt("usuarioId"),
										rs.getInt("perfil"),
										rs.getString("nome"),
										rs.getString("cpf"),
										rs.getDate("dataNascimento"),
										ESexo.valueOf(rs.getString("sexo").equals("F") ? "F":"M")));
				}
			}
			return pessoas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage(), this.getClass().getSimpleName());
		} finally {
			Conexao.closeConexao();
		}
	}	
	
	 public boolean insereVariosTrn(List<Pessoa> pessoas) throws BDException {
	        Connection conexao = Conexao.getConexao(true);

	        try {
	            conexao.setAutoCommit(false);
	            PreparedStatement pst = conexao.prepareStatement("INSERT INTO pessoa ( usuarioId, perfil, nome, cpf, dataNascimento, sexo) VALUES (?, ?, ?, ?, ?, ?);");
	            Iterator<Pessoa> var5 = pessoas.iterator();

	            while(var5.hasNext()) {
	                Pessoa pessoa = (Pessoa)var5.next();
	                pst.setInt(1, pessoa.getCdUsuario());
					pst.setInt(2, pessoa.getPerfil());
					pst.setString(3, pessoa.getNome());
					pst.setString(4, pessoa.getCpf());
					pst.setDate(5, new java.sql.Date(pessoa.getDataNascimento().getTime()));
					pst.setString(6, String.valueOf(pessoa.getSexo().getSigla()));
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

	public void exportaDados(String nomeArq, String separador) throws BDException {
        List<String> exporta = new ArrayList<String>();
        Iterator<Pessoa> var5 = this.consulta().iterator();

        while(var5.hasNext()) {
            Pessoa pessoa = (Pessoa)var5.next();
            exporta.add(pessoa.toStringBD(separador));
        }

        Arquivo.gravaArquivo(nomeArq, exporta, false);
    }

}
