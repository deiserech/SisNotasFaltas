package edu.asselvi.enumerador;

public enum ESexo {
	M ("Masculino", "Masc", 'M'),
	F ("Feminino", "Fem", 'F');
	
	private final String descricao;
	private final String abreviatura;
	private final char sigla;
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getAbreviatura() {
		return abreviatura;
	}
	
	public char getSigla() {
		return sigla;
	}

	
	private ESexo(String descricao, String abreviatura, char sigla) {
		this.descricao = descricao;
		this.abreviatura = abreviatura;
		this.sigla = sigla;
	}
}
