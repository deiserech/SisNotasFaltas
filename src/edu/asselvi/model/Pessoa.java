package edu.asselvi.model;

import java.util.Date;

import edu.asselvi.enumerador.ESexo;

public class Pessoa {
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private Date dataNascimento;
	private String email;
	private ESexo sexo;

	public Pessoa() {
		this(0, "Não informado", "000-000-000-00", "(00)000-000000", new Date(), "Não Informado", ESexo.MASCULINO);

	}

	public Pessoa(int id, String nome, String cpf, String telefone, Date dataNasc, String email, ESexo sexo) {

		setId(id);
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setDataNascimento(dataNasc);
		setEmail(email);
		setSexo(sexo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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

	@Override
	public String toString() {
		return getClass().getSimpleName()
				+ "\n\tCódigo................: " + getId()
				+ "\n\tNome..................: " + getNome() + "\n\tTelefone..............: " + getTelefone()
				+ "\n\tNascimento............: " + getDataNascimento() + "\n\tEmail.................: " + getEmail()
				+ "\n\tSexo..................: " + getSexo().getDescricao();
	}
}
