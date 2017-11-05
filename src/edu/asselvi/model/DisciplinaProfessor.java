package edu.asselvi.model;

public class DisciplinaProfessor {
	private int disciplinaId;//FK - c�digo da disciplina
	private int professorId;//FK - c�digo do professor
	
	public DisciplinaProfessor() {
		this(0,0);
	}
	public DisciplinaProfessor(int disciplinaId, int professorId) {
		setProfessorId(professorId);
		setDisciplinaId(disciplinaId);
	}
	
	public int getDisciplinaId() {
		return disciplinaId;
	}
	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String toString() {
		return    "\n\tC�d. Professor..........: " + getProfessorId()
				+ "\n\tC�d. Dsciplina..........: " + getDisciplinaId();
	}
	
}
