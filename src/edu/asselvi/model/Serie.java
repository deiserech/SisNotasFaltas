package edu.asselvi.model;

public class Serie {
	private int SerieId;
	private int CursoId;
	private String descricao;
	private int idadeMinima;
	private int duracao; // meses

	
	public Serie() {
		this(0, 0, "Não Informado", 0, 0);
	}
	
	public Serie(int SerieId, int CursoId, String descricao, int idadeMinima, int duracao) {
		setSerieId(SerieId);
		setDescricao(descricao);
		setCursoId(CursoId);
		setIdadeMinima(idadeMinima);
		setDuracao(duracao);
	}	
	
	public int getSerieId() {
		return SerieId;
	}
	public void setSerieId(int SerieId) {
		this.SerieId = SerieId;
	}
	public int getCursoId() {
		return CursoId;
	}
	public void setCursoId(int CursoId) {
		this.CursoId = CursoId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdadeMinima() {
		return idadeMinima;
	}
	public void setIdadeMinima(int idadeMinima) {
		this.idadeMinima = idadeMinima;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String toString() {
		return super.toString()
				+ "\n\tCód. Série..............: " + getSerieId()
				+ "\n\tCód. Curso..............: " + getCursoId()
				+ "\n\tDescrição...............: " + getDescricao()
				+ "\n\tIdade Mínima............: " + getIdadeMinima()
				+ "\n\tDuração.................: " + getDuracao();
	}

	
	 public String toStringBD(String separador) {
	        return this.getSerieId() + separador + getCursoId() + separador + getDescricao() + separador + getIdadeMinima() + separador + getDuracao();
	    }
}
