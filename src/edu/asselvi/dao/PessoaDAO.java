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
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Pessoa;

public class PessoaDAO implements GenericDAO<Pessoa> {

	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE pessoa (" + "	"
					+ " pessoaId		 		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " cdUsuario		INTEGER NOT NULL ," //adicionar foreing key
					+ " perfil 		    INTEGER NOT NULL ," 
					+ "	nome			VARCHAR(50)  NOT NULL,"  
					+ "	cpf	     		VARCHAR(14)  NOT NULL," 
					+ "	dataNascimento	DATE         NOT NULL," 
					+ "	sexo			CHAR(1) NOT  NULL" + ");");
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
			st.execute("DROP TABLE pessoa;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public boolean insereTrn(List<Pessoa> pessoas) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO pessoa ( cdUsuario, perfil, nome, cpf, dataNascimento, sexo) VALUES (?, ?, ?, ?, ?, ?);");
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
				throw new BDException(EErrosBD.ROLLBACK, e2.getMessage());
			}
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public Pessoa consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM pessoa WHERE pessoaId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Pessoa(rs.getInt("id"),
										   rs.getInt("cdUsuario"),
										   rs.getInt("perfil"),
										   rs.getString("nome"),
										   rs.getString("cpf"),
										   rs.getDate("dataNascimento"),
										   ESexo.valueOf(rs.getString("sexo").equals("F") ? "FEMININO":"MASCULINO"))
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public List<Pessoa> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM pessoa;");
			while(rs.next()) {
				pessoas.add(new Pessoa(rs.getInt("id"),
						   rs.getInt("cdUsuario"),
						   rs.getInt("perfil"),
						   rs.getString("nome"),
						   rs.getString("cpf"),
						   rs.getDate("dataNascimento"),
						   ESexo.valueOf(rs.getString("sexo").equals("F") ? "FEMININO":"MASCULINO")));
			}
			return pessoas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Pessoa pessoa) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE pessoa SET cdUsuario = ?, perfil, nome = ?, cpf = ?, dataNascimento = ?, sexo = ? WHERE pessoaId = ?;");
			pst.setInt(1, pessoa.getCdUsuario());
			pst.setInt(2, pessoa.getPerfil());
			pst.setString(3, pessoa.getNome());
			pst.setString(4, pessoa.getCpf());
			pst.setDate(5, new java.sql.Date(pessoa.getDataNascimento().getTime()));
			pst.setString(6, String.valueOf(pessoa.getSexo().getSigla()));
			pst.setInt(7, pessoa.getId());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM pessoa WHERE pessoaId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(pessoaId) FROM pessoa;");
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
