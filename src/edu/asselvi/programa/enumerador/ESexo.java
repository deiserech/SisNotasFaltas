package edu.asselvi.programa.enumerador;

import javax.swing.ImageIcon;

public enum ESexo {
	MASCULINO ("Masculino", "Masc", 'M'),
	FEMININO ("Feminino", "Fem", 'F');
	
	private final String descricao;
	private final String abreviatura;
	private final char sigla;
	private final ImageIcon icone;
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getAbreviatura() {
		return abreviatura;
	}
	
	public char getSigla() {
		return sigla;
	}

	public ImageIcon getIcone() {
		return icone;
	}
	
	private ESexo(String descricao, String abreviatura, char sigla) {
		this.descricao = descricao;
		this.abreviatura = abreviatura;
		this.sigla = sigla;
		this.icone = new ImageIcon(System.getProperty("user.dir") + "/imagem/" + getSigla() + ".jpg");
	}
}
