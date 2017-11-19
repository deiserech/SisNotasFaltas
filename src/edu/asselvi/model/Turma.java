package edu.asselvi.model;

public class Turma {
	private int TurmaId;
	private int SerieId;
	private String descricao;
	private int vagas;
	private int ano;
 

	public Turma() {
		this(0, 0,"Não informado", 0, 0);
	}
	
	public Turma(int TurmaId, int SerieId, String descricao, int vagas, int ano) {
		setTurmaId(TurmaId);
		setSerieId(SerieId);
		setDescricao(descricao);
		setVagas(vagas);
		setAno(ano);
	}	

	public int getTurmaId() {
		return TurmaId;
	}
	public void setTurmaId(int TurmaId) {
		this.TurmaId = TurmaId;
	}
	
	public int getSerieId() {
		return SerieId;
	}
	public void setSerieId(int SerieId) {
		this.SerieId = SerieId;
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
	
	public String toString() {
		return super.toString()
				+ "\n\tCód. Turma..............: " + getTurmaId()
				+ "\n\tCód Série...............: " + getSerieId()
				+ "\n\tDescrição...............: " + getDescricao()
				+ "\n\tVagas...................: " + getVagas()
				+ "\n\tAno.....................: " + getAno();
	}
	
	 public String toStringBD(String separador) {
	        return this.getTurmaId() + separador + getSerieId() + separador + getDescricao() + separador + getVagas() + separador + getAno();
	    }

}
