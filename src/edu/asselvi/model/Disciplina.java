package edu.asselvi.model;

public class Disciplina {
	private int DisciplinaId;
	private String descricao; 
	
	public Disciplina() {
		this(0, "Não Informado");
	};
	public Disciplina(int DisciplinaId, String descricao) {
		setDisciplinaId(DisciplinaId);
		setDescricao(descricao);
	};
	
	public int getDisciplinaId() {
		return DisciplinaId;
	}
	public void setDisciplinaId(int DisciplinaId) {
		this.DisciplinaId = DisciplinaId;
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
