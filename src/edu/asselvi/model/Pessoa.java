package edu.asselvi.model;

import java.util.Date;

import edu.asselvi.enumerador.ESexo;

public class Pessoa {
	private int id;
	private int cdUsuario;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private ESexo sexo;

	public Pessoa() {
		this(0,0, "Não informado", "000-000-000-00", new Date(), ESexo.MASCULINO);

	}

	public Pessoa(int id, int cdUsuario, String nome, String cpf, Date dataNasc, ESexo sexo) {
		setId(id);
		setCdUsuario(cdUsuario);
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNasc);
		setSexo(sexo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}
	
	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
				+ "\n\tCódigo Usuário........: " + getCdUsuario()
				+ "\n\tCPF...................: " + getCpf()
				+ "\n\tNome..................: " + getNome() 
				+ "\n\tNascimento............: " + getDataNascimento() 
				+ "\n\tSexo..................: " + getSexo().getDescricao();
	}

}
