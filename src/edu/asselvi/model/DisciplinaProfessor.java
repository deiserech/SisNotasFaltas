package edu.asselvi.model;

public class DisciplinaProfessor {
	private int DisciplinaId;
	private int ProfessorId;
	
	public DisciplinaProfessor() {
		this(0,0);
	}
	public DisciplinaProfessor(int DisciplinaId, int ProfessorId) {
		setProfessorId(ProfessorId);
		setDisciplinaId(DisciplinaId);
	}
	
	public int getDisciplinaId() {
		return DisciplinaId;
	}
	public void setDisciplinaId(int DisciplinaId) {
		this.DisciplinaId = DisciplinaId;
	}
	public int getProfessorId() {
		return ProfessorId;
	}
	public void setProfessorId(int ProfessorId) {
		this.ProfessorId = ProfessorId;
	}

	public String toString() {
		return    "\n\tCód. Professor..........: " + getProfessorId()
				+ "\n\tCód. Dsciplina..........: " + getDisciplinaId();
	}
	
}
