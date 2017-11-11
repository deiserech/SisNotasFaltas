package edu.asselvi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asselvi.enumerador.ESexo;

public class Aluno extends Pessoa {
	private int alunoId;
	private String nomeMae;
	private List<Integer> turmas = new ArrayList<Integer>();
	
//testeLorena
	public Aluno() {
		this(0, "Não informado", "Não informado", "000.000.000-00", "(00)0000-0000", new Date(), "Não informado", ESexo.MASCULINO, null);
	}
	public Aluno(int alunoId, String nomeMae, String nome, String cpf, String telefone, Date dataNascimento, String email, ESexo sexo, List<Integer> turmas) {
		super(alunoId, nome, cpf, telefone, dataNascimento, email, sexo);
		setAlunoId(alunoId);
		setNomeMae(nomeMae);
		this.turmas = new ArrayList<Integer>();
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
