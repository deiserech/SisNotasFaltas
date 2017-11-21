package edu.asselvi.model;

public class Base {
	private String ip;
	private String base;
	private String useSSL;
	private String login;
	private String senha;
	
	public Base() {
		this("//localhost:3306","deise","true","root", "Deise123");
	}
	public Base(String ip, String base, String useSSL, String login, String senha) {
		setIp(ip);
		setBase(base);
		setUseSSL(useSSL);
		setLogin(login);
		setSenha(senha);
	}
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getUseSSL() {
		return useSSL;
	}
	public void setUseSSL(String useSSL) {
		this.useSSL = useSSL;
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
		return    "\n\tIP......................: " + getIp()
				+ "\n\tBase....................: " + getBase()
				+ "\n\tuseSSL..................: " + getUseSSL()
				+ "\n\tLogin...................: " + getLogin()
				+ "\n\tSenha..................: " + getSenha();
	}
}
