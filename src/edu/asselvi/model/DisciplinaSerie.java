package edu.asselvi.model;

public class DisciplinaSerie {
	private int DisciplinaId;
	private int SerieId;

	public DisciplinaSerie() {
		this(0, 0);
	}

	public DisciplinaSerie(int DisciplinaId, int SerieId) {
		setDisciplinaId(DisciplinaId);
		setSerieId(SerieId);
	}

	public int getDisciplinaId() {
		return DisciplinaId;
	}

	public void setDisciplinaId(int DisciplinaId) {
		this.DisciplinaId = DisciplinaId;
	}

	public int getSerieId() {
		return SerieId;
	}

	public void setSerieId(int SerieId) {
		this.SerieId = SerieId;
	}

	@Override
	public String toString() {
		return  	"\n\tCód. Série..............: " + getSerieId()
				+ 	"\n\tCód. Disciplina.........: " + getDisciplinaId();
	}
	
	 public String toStringBD(String separador) {
	        return this.getSerieId() + separador + getDisciplinaId();
	    }
}
