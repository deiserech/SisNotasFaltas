package edu.asselvi.model;

import java.util.Date;
import edu.asselvi.enumerador.ESexo;

public class Funcionario extends Pessoa {

	public Funcionario() {
		this(0, 0, 0, "Não informado", "000.000.000-00", new Date(), ESexo.M);
	}

	public Funcionario(int funcionarioId, int cdUsuario, int tipoFuncionario, String nome, String cpf,
			Date dataNascimento, ESexo sexo) {
		super(funcionarioId, cdUsuario, tipoFuncionario, nome, cpf, dataNascimento, sexo);
	}

	public String toString() {
		return super.toString();
	}

}
