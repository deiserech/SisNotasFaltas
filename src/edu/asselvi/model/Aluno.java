package edu.asselvi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asselvi.enumerador.ESexo;

public class Aluno extends Pessoa {
	private List<Integer> turmas = new ArrayList<Integer>();
	
//testeLorena
	public Aluno() {
		this(0, 0, 0, "Não informado", "000.000.000-00", new Date(), ESexo.MASCULINO, null);
	}
	public Aluno(int alunoId, int cdUsuario, int perfil,  String nome, String cpf, Date dataNascimento,ESexo sexo, List<Integer> turmas) {
		super(alunoId, cdUsuario, perfil, nome, cpf, dataNascimento, sexo);
		this.turmas = new ArrayList<Integer>();
	}	

	public void adicionaTurma(int turma) {
		this.turmas.add(new Integer(turma));
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
