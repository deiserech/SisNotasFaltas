package edu.asselvi.model;

public class DisciplinaSerie {
	private int disciplinaId;
	private int serieId;

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
		return  	"\n\tCód. Série..............: " + getSerieId()
				+ 	"\n\tCód. Disciplina.........: " + getDisciplinaId();
	}
}
