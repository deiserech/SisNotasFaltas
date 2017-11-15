package edu.asselvi.model;

public class Curso {
	private int CursoId;
	private int EscolaId; 
	private int numSeries; 
	private String descricao;
	
	public Curso() {
		this( 0, 0,0, "N�o Informado");
	}
	
	public Curso(int CursoId, int EscolaId, int numSeries, String descricao) {
		setCursoId(CursoId);
		setEscolaId(EscolaId);
		setDescricao(descricao);
		setNumSeries(numSeries);
	}	
	
	public int getCursoId() {
		return CursoId;
	}
	public void setCursoId(int id) {
		this.CursoId = id;
	}
	public int getEscolaId() {
		return EscolaId;
	}
	public void setEscolaId(int EscolaId) {
		this.EscolaId = EscolaId;
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
