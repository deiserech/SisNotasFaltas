package edu.asselvi.model;

public class Usuario {
	private int usuarioId;
	private String login;
	private String senha;
	
	public Usuario() {
		this(0,"admin", "989796");
	}

	public Usuario(int usuarioId, String login, String senha) {
		setUsuarioId(usuarioId);
		setLogin(login);
		setSenha(senha);
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
		
    @Override
    public String toString() {
		return "\n\tCód Usuário.............: " + getUsuarioId()
		+ "\n\tLogin...................: " + getLogin()
		+ "\n\tSenha...................: " + getSenha();
    }
    
    public String toStringBD(String separador) {
        return this.getUsuarioId() + separador + getLogin() + separador + getSenha();
    }
	
}
