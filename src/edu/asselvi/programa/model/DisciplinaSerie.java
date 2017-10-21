package edu.asselvi.programa.model;

public class DisciplinaSerie {
	private int disciplinaId;// FK - c�digo da disciplina
	private int serieId;// FK - c�digo da s�rie

	public DisciplinaSerie() {
		this(0, 0);
	}

	public DisciplinaSerie(int disciplinaId, int serieId) {
		setDisciplinaId(disciplinaId);
		setSerieId(serieId);
	}

	public int getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public int getSerieId() {
		return serieId;
	}

	public void setSerieId(int serieId) {
		this.serieId = serieId;
	}

	@Override
	public String toString() {
		return  	"\n\tC�d. S�rie..............: " + getSerieId()
				+ 	"\n\tC�d. Disciplina.........: " + getDisciplinaId();
	}
}