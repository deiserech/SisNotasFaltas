package edu.asselvi.enumerador;

public enum EErrosIO {
	INSERE_CODIGO ("Insira um c�digo v�lido"),
	INSERE_NUMERO ("Insira um n�mero v�lido"),
	INSERE_EXISTENTE ("C�digo j� existe. Informe um novo c�digo."),
	INSERE_INVALIDO ("C�digo n�o existe. Informe um c�digo v�lido.") ,
	DATA_INVALIDO ("Data inv�lida.") ,
	SEXO_INVALIDO ("Sexo inv�lido.") ,
	INFORMACAO_INVALIDA ("Informa��o inv�lida.") ;
	
	private final String mensagem;

	public String getMensagem() {
		return mensagem;
	}
	
	private EErrosIO(String mensagem) {
		this.mensagem = mensagem;
	}

}
