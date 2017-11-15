package edu.asselvi.model;

import java.util.Date;
import edu.asselvi.enumerador.ESexo;

public class Funcionario extends Pessoa {
	// private List<Integer> disciplinas = new ArrayList<Integer>();

	public Funcionario() {
		// this(0,0,0, "Não informado", "000.000.000-00", new Date(),ESexo.MASCULINO,
		// null);
		this(0, 0, 0, "Não informado", "000.000.000-00", new Date(), ESexo.MASCULINO);
	}

	// public Funcionario(int funcionarioId, int cdUsuario, int tipoFuncionario,
	// String nome, String cpf, Date dataNascimento, ESexo sexo, List<Integer>
	// disciplinas) {
	public Funcionario(int funcionarioId, int cdUsuario, int tipoFuncionario, String nome, String cpf,
			Date dataNascimento, ESexo sexo) {
		super(funcionarioId, tipoFuncionario, cdUsuario, nome, cpf, dataNascimento, sexo);
		// this.disciplinas = new ArrayList<Integer>();
	}

	public void adicionaDisciplina(int disciplina) {
		// this.disciplinas.add(new Integer(disciplina));
	}

	public String toString() {
		return super.toString();
	}

}
