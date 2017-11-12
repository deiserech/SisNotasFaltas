package edu.asselvi.model;

public class Curso {
	private int cursoId;
	private int escolaId; 
	private int numSeries; 
	private String descricao;
	
	public Curso() {
		this( 0, 0, "Não Informado");
	}
	
	public Curso(int CURSOId, int escolaId, String descricao) {
		setCursoId(cursoId);
		setEscolaId(escolaId);
		setDescricao(descricao);
	}	
	
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int id) {
		this.cursoId = id;
	}
	public int getEscolaId() {
		return escolaId;
	}
	public void setEscolaId(int escolaId) {
		this.escolaId = escolaId;
	}
	public int getNumSeries() {
		return numSeries;
	}
	
	public void setNumSeries(int numSeries) {
		this.numSeries = numSeries;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return   "\n\tCód. Curso..............: " + getCursoId()
				+ "\n\tCód. Escola.............: " + getEscolaId()
				+ "\n\tNúmero Séries...........: " + getNumSeries()
				+ "\n\tDescriçao...............: " + getDescricao();
	}
	
}
