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
import edu.asselvi.model.Usuario;

public class UsuarioDAO implements GenericDAO<Usuario>{


	@Override
	public boolean criaTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("CREATE TABLE usuario (" + "	"
					+ " usuarioId		 		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ " login    		VARCHAR(10) NOT NULL ," 
					+ " senha 		    VARCHAR(14) NOT NULL " 
					+ ");");
			criaAdmin();
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CRIA_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	public void criaAdmin() throws BDException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario(1,"admin","admin"));		
		insereTrn(usuarios);
	}

	@Override
	public boolean destroiTabela() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			Statement st = conexao.createStatement();
			st.execute("DROP TABLE usuario;");
			return true;
		} catch (Exception e) {
			throw new BDException(EErrosBD.DESTROI_TABELA, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean insereTrn(List<Usuario> usuarios) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO usuario ( login, senha) VALUES (?, ?);");
				for (Usuario usuario : usuarios) {
					pst.setString(1, usuario.getLogin());
					pst.setString(2, usuario.getSenha());
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
	public Usuario consulta(int id) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM usuario WHERE usuarioId = ?;");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
								new Usuario(rs.getInt("usuarioId"),
										   rs.getString("login"),
										   rs.getString("senha"))										   
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}


	public Usuario consultaLogin(String login) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM usuario WHERE login = ?;");
			pst.setString(1, login);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
					new Usuario(rs.getInt("usuarioId"),
							   rs.getString("login"),
							   rs.getString("senha"))
				  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public List<Usuario> consulta() throws BDException {
		Connection conexao = Conexao.getConexao();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuario;");
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getInt("usuarioId"),
						   rs.getString("login"),
						   rs.getString("senha")));
			}
			return usuarios;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}

	@Override
	public boolean altera(Usuario usuario) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("UPDATE usuario SET login = ?, senha = ? WHERE usuarioId = ?;");
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
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
			PreparedStatement pst = conexao.prepareStatement("DELETE FROM usuario WHERE usuarioId = ?;");
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
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM usuario;");
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

	public int verificaLogin(Usuario usuario) throws BDException {
		Usuario usuarioBanco =  consultaLogin(usuario.getLogin());
		if(usuarioBanco instanceof Usuario) {
			if(usuarioBanco.getSenha().equals(usuario.getSenha())) {
				return usuarioBanco.getUsuarioId();
			}		
		}		
		return 0;
	}
}
