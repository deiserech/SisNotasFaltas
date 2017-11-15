package edu.asselvi.model;

public class AlunoTurma {
	private int alunoId; 
	private int turmaId; 
	
	public AlunoTurma() {
		this(0,0);
	}
	public AlunoTurma(int alunoId, int turmaId) {
		setAlunoId(alunoId);
		setTurmaId(turmaId);
	}
	
	public int getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	public int getTurmaId() {
		return turmaId;
	}
	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}
	
	public String toString() {
		return    "\n\tCód. Turma..............: " + getTurmaId()
				+ "\n\tCód. Aluno..............: " + getAlunoId();
	}

}
