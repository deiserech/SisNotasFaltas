package edu.asselvi.enumerador;

public enum EErrosBD {
	ABRE_CONEXAO ("Erro ao abrir conexão com o Banco de Dados"),
	FECHA_CONEXAO ("Erro ao fechar a conexão com o Banco de Dados"),
	CRIA_TABELA ("Erro ao criar a tabela especificada"),
	DESTROI_TABELA ("Erro ao excluir a tabela especificada"),
	INSERE_DADO ("Erro ao inserir dados na tabela especificada"),
	ROLLBACK ("Erro ao efetuar o rollback na tabela especificada"),
	CONSULTA_DADO ("Erro ao consultar dados na tabela especificada"),
	ALTERA_DADO ("Erro ao alterar dados na tabela especificada"),
	EXCLUI_DADO ("Erro ao excluir dados da tabela especificada"),
	CRIA_BASE ("Erro ao criar a base de dados");
	
	private final String mensagem;

	public String getMensagem() {
		return mensagem;
	}
	
	private EErrosBD(String mensagem) {
		this.mensagem = mensagem;
	}
}
