package edu.asselvi.model;

import java.util.ArrayList;
import java.util.List;

import edu.asselvi.enumerador.ESexo;

public class Professor extends Pessoa {
	private int nrCartTrabalho;
	private int professorId;
//	private Map<Integer, Disciplina> disciplinas;
	private List<Integer> disciplinas = new ArrayList<Integer>();

	public Professor() {
		this(0, 0, "Não informado", "Não informado", "000.000.000-00", "(00)0000-0000", "00/00/0000", 0, "Não informado", ESexo.MASCULINO);
	}

	public Professor(int professorId, int nrCartTrabalho, String nome, String endereco, String cpf, String telefone, String dataNasc, int idade, String email, ESexo sexo) {
		super(nome, endereco, cpf, telefone, dataNasc, idade, email, sexo);
		setNrCartTrabalho(nrCartTrabalho);
		setProfessorId(professorId);
	}

	public int getProfessorId() {
		return professorId;
	}
	
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getNrCartTrabalho() {
		return nrCartTrabalho;
	}

	public void setNrCartTrabalho(int nrCartTrabalho) {
		this.nrCartTrabalho = nrCartTrabalho;
	}

//	public void adicionaDisciplina(Disciplina disciplina) {
//		this.disciplinas.put(new Integer(disciplina.getDisciplinaId()), disciplina);
//	}

	public void adicionaDisciplina(int disciplina) {
		this.disciplinas.add(new Integer(disciplina));
	}
	
	public String toString() {
		return super.toString() 
				+ "\n\tCód. Professor..........: " + getProfessorId()
				+ "\n\tCarteira de Trabalho....: " + getNrCartTrabalho();
	}

	

}
