package edu.asselvi.enumerador;

public enum EPerfil {
	COORDENADOR (1,"Coordenador(a)", "Coord", 'C'),
	SECRETARIO (2,"Secretário(a)", "Secret", 'S'),
	PROFESSOR (3,"Professor(a)", "Prof", 'P'),
	ALUNO (4,"Aluno(a)", "Alun", 'A');
	
	private final int perfil;
	private final String descricao;
	private final String abreviatura;
	private final char sigla;

	public int getPerfil() {
		return perfil;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getAbreviatura() {
		return abreviatura;
	}
	
	public char getSigla() {
		return sigla;
	}
	
	private EPerfil(int perfil, String descricao, String abreviatura, char sigla) {
		this.perfil = perfil;
		this.descricao = descricao;
		this.abreviatura = abreviatura;
		this.sigla = sigla;
	}

}
