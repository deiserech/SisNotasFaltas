package edu.asselvi.programa.model;

import java.util.ArrayList;
import java.util.List;

import edu.asselvi.programa.enumerador.ESexo;

public class Aluno extends Pessoa {
	private int alunoId;
	private String nomeMae;
	private List<Integer> turmas = new ArrayList<Integer>();
	

	public Aluno() {
		this(0, "Não informado", "Não informado", "Não informado", "000.000.000-00", "(00)0000-0000", "00/00/0000", 0, "Não informado", ESexo.MASCULINO);
	}
	public Aluno(int alunoId, String nomeMae, String nome, String endereco, String cpf, String telefone, String dataNasc, int idade, String email, ESexo sexo) {
		super(nome, endereco, cpf, telefone, dataNasc, idade, email, sexo);
		setAlunoId(alunoId);
		setNomeMae(nomeMae);
	}	

	public int getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	public void adicionaTurma(int turma) {
		this.turmas.add(new Integer(turma));
	}

	@Override
	public String toString() {
		return super.toString()
				+ "\n\tCód Aluno...............: " + getAlunoId()
				+ "\n\tNome da mãe.............: " + getNomeMae();		
	}
}
