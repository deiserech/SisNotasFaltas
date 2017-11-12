package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.model.Usuario;

public class UsuarioDAO implements GenericDAO<Usuario>{

	@Override
	public boolean criaTabela() throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean destroiTabela() throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insereTrn(List<Usuario> t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario consulta(int id) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario consultaLogin(String login) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM usuario WHERE login = ?;");
			pst.setString(1, login);
			ResultSet rs = pst.executeQuery();
			return rs.first() ?
					new Usuario(rs.getInt("id"),
							   rs.getString("login"),
							   rs.getString("senha"),
							   rs.getInt("perfil"))
				  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}
	}
	
	@Override
	public List<Usuario> consulta() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altera(Usuario t) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exclui(int id) throws BDException {
		// TODO Auto-generated method stub
		return false;
	}

	public int verificaLogin(Usuario usuario) throws BDException {
		Usuario usuarioBanco =  consultaLogin(usuario.getLogin());
		if(usuarioBanco instanceof Usuario) {
			if(usuarioBanco.getSenha().equals(usuario.getSenha())) {
				return usuarioBanco.getTipoUsuario();
			}		
		}		
		return 0;
	}
	
}
