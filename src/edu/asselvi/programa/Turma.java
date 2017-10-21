package edu.asselvi.programa;

public class Turma {
	private int turmaId;
	private String descricao;
	private int vagas;
	private int ano;
	private int serieId; //FK - código da série

	public Turma() {
		this(0, "Não informado", 0, 0, 0);
	}
	
	public Turma(int turmaId, String descricao, int vagas, int ano, int serieId) {
		setTurmaId(turmaId);
		setDescricao(descricao);
		setVagas(vagas);
		setAno(ano);
		setSerieId(serieId);
	}	

	public int getTurmaId() {
		return turmaId;
	}
	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getSerieId() {
		return serieId;
	}
	public void setSerieId(int serieId) {
		this.serieId = serieId;
	}
	
	public String toString() {
		return super.toString()
				+ "\n\tCód. Turma..............: " + getTurmaId()
				+ "\n\tDescrição...............: " + getDescricao()
				+ "\n\tVagas...................: " + getVagas()
				+ "\n\tAno.....................: " + getAno()
				+ "\n\tCód Série...............: " + getSerieId();
	}

}
