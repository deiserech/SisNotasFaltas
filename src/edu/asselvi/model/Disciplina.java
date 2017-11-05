package edu.asselvi.model;

public class Disciplina {
	private int disciplinaId;
	private String descricao;
	
	public Disciplina() {
		this(0, "Não Informado");
	};
	public Disciplina(int disciplinaId, String descricao) {
		setDisciplinaId(disciplinaId);
		setDescricao(descricao);
	};
	
	public int getDisciplinaId() {
		return disciplinaId;
	}
	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString() {
		return super.toString()
				+ "\n\tCód Disciplina..........: " + getDisciplinaId()
				+ "\n\tDescrição...............: " + getDescricao();
	}

}
