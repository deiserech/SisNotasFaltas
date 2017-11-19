package edu.asselvi.enumerador;

public enum EErrosIO {
	INSERE_CODIGO ("Insira um código válido"),
	INSERE_NUMERO ("Insira um número válido"),
	INSERE_EXISTENTE ("Código já existe. Informe um novo código."),
	INSERE_INVALIDO ("Código não existe. Informe um código válido.") ,
	DATA_INVALIDO ("Data inválida.") ,
	SEXO_INVALIDO ("Sexo inválido.") ,
	INFORMACAO_INVALIDA ("Informação inválida.") ;
	
	private final String mensagem;

	public String getMensagem() {
		return mensagem;
	}
	
	private EErrosIO(String mensagem) {
		this.mensagem = mensagem;
	}

}
