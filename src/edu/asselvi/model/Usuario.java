package edu.asselvi.model;

public class Usuario {
	private int usuarioId;
	private String login;
	private String senha;
	private int tipoUsuario; 
	
	public Usuario() {
		this(0,"admin", "989796", 1);
	}

	public Usuario(int usuarioId, String login, String senha, int tipoUsuario) {
		setUsuarioId(usuarioId);
		setLogin(login);
		setSenha(senha);
		setTipoUsuario(tipoUsuario);
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
    @Override
    public String toString() {
		return "\n\tCód Usuário.............: " + getUsuarioId()
		+ "\n\tLogin...................: " + getLogin()
		+ "\n\tSenha...................: " + getSenha()
		+ "\n\tTipo Usuario............: " + getTipoUsuario();
    }
	
}
