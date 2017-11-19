package edu.asselvi.controller;

import edu.asselvi.enumerador.EErrosIO;

public class InputException extends Exception{
	private static final long serialVersionUID = 1L;

	public InputException(EErrosIO erro, String erroMsg) {
		System.out.println(erro.getMensagem()  + "#" + erroMsg);
	}

}
