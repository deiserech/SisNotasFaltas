package edu.asselvi.programa.model;

import edu.asselvi.programa.enumerador.ESexo;

public abstract class Pessoa {
	private String nome;
	private String endereço;
	private String cpf;
	private String telefone;
	private String dataNascimento;
	private int idade;
	private String email;
	private ESexo sexo;
	
	public Pessoa() {
		this("Não informado", "Não Informado", "000-000-000-00", "(00)000-000000", "00/00/0000", 0, "Não Informado", ESexo.MASCULINO );
	}
	public Pessoa(String nome, String endereco, String cpf, String telefone, String dataNasc, int idade, String email, ESexo sexo) {
		setNome(nome);
		setEndereço(endereco);
		setCpf(cpf);
		setTelefone(telefone);
		setDataNascimento(dataNasc);
		setIdade(idade);
		setEmail(email);
		setSexo(sexo);
	}	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ESexo getSexo() {
		return sexo;
	}
	public void setSexo(ESexo sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()
				+ "\n\tNome..................: " + getNome()
				+ "\n\tEndereço..............: " + getEndereço()
				+ "\n\tTelefone..............: " + getTelefone()
				+ "\n\tNascimento............: " + getDataNascimento()
				+ "\n\tEmail.................: " + getEmail()
				+ "\n\tSexo..................: " + getSexo().getDescricao();
	}
}
