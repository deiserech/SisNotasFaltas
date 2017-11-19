package edu.asselvi.model;

import java.util.Date;
import edu.asselvi.enumerador.ESexo;

public class Aluno extends Pessoa {

	public Aluno() {
		this(0, 0, 0, "Não informado", "000.000.000-00", new Date(), ESexo.M);
	}

	public Aluno(int alunoId, int cdUsuario, int perfil, String nome, String cpf, Date dataNascimento, ESexo sexo) {
		super(alunoId, cdUsuario, perfil, nome, cpf, dataNascimento, sexo);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
