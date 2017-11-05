package edu.asselvi.bancodados;

public class BDException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BDException(EErrosBD erro, String erroMsg) {
		System.out.println(erro.getMensagem() + "#" + erroMsg);
	}

}
