package edu.asselvi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asselvi.enumerador.ESexo;

public class Professor extends Pessoa {
	private int nrCartTrabalho;
	private List<Integer> disciplinas = new ArrayList<Integer>();

	public Professor() {
		this(0,0, "Não informado", "000.000.000-00", "(00)0000-0000",  new Date(), "Não informado", ESexo.MASCULINO, null);
	}

	public Professor(int id, int nrCartTrabalho, String nome, String cpf, String telefone, Date dataNascimento, String email, ESexo sexo, List<Integer> disciplinas) {
		super(id, nome, cpf, telefone, dataNascimento, email, sexo);
		setNrCartTrabalho(nrCartTrabalho);
		this.disciplinas = new ArrayList<Integer>();
	}

	public int getNrCartTrabalho() {
		return nrCartTrabalho;
	}

	public void setNrCartTrabalho(int nrCartTrabalho) {
		this.nrCartTrabalho = nrCartTrabalho;
	}

	public void adicionaDisciplina(int disciplina) {
		this.disciplinas.add(new Integer(disciplina));
	}
	
	public String toString() {
		return super.toString() 
				+ "\n\tCarteira de Trabalho....: " + getNrCartTrabalho();
	}

	

}
