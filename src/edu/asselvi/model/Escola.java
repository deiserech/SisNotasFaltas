package edu.asselvi.model;

public class Escola {
	private int escolaId;
	private String descricao;
	
	public Escola() {
		this(0, "Não Informado");
	}
	public Escola(int cdEscola, String nmEscola) {
		setEscolaId(cdEscola);
		setDescricao(nmEscola);
	}
	public int getEscolaId() {
		return escolaId;
	}
	public void setEscolaId(int escolaId) {
		this.escolaId = escolaId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString() {
		return    "\n\tCód Escola..............: " + getEscolaId()
				+ "\n\tDescrição................: " + getDescricao();
	}
	
	
}
