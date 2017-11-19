package edu.asselvi.bancodados;

import edu.asselvi.enumerador.EErrosBD;

public class BDException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BDException(EErrosBD erro, String erroMsg, String classe) {
		System.out.println(erro.getMensagem() + "#" + erroMsg + "#" + classe);
	}

}
