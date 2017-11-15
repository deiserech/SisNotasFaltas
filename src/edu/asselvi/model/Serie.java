package edu.asselvi.model;

public class Serie {
	private int serieId;
	private int cursoId;
	private String descricao;
	private int idadeMinima;
	private int duracao; 

	
	public Serie() {
		this(0, 0, "N�o Informado", 0, 0);
	}
	
		public Serie(int serieId, int cursoId, String descricao, int idadeMinima, int duracao) {
		setSerieId(serieId);
		setDescricao(descricao);
		setCursoId(cursoId);
		setIdadeMinima(idadeMinima);
		setDuracao(duracao);
	}	
	
	public int getSerieId() {
		return serieId;
	}
	public void setSerieId(int serieId) {
		this.serieId = serieId;
	}
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
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
				+ "\n\tC�d. S�rie..............: " + getSerieId()
				+ "\n\tDescri��o...............: " + getDescricao()
				+ "\n\tC�d. Curso..............: " + getCursoId()
				+ "\n\tIdade M�nima............: " + getIdadeMinima()
				+ "\n\tDura��o.................: " + getDuracao();
	}

}
