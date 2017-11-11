package edu.asselvi.enumerador;

import javax.swing.ImageIcon;

public enum ESexo {
	MASCULINO ("Masculino", "Masc", 'M'),
	FEMININO ("Feminino", "Fem", 'F');
	
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
