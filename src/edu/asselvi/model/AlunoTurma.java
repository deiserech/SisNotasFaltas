package edu.asselvi.model;

public class AlunoTurma {
	private int AlunoId; 
	private int TurmaId; 
	
	public AlunoTurma() {
		this(0,0);
	}
	public AlunoTurma(int AlunoId, int TurmaId) {
		setAlunoId(AlunoId);
		setTurmaId(TurmaId);
	}
	
	public int getAlunoId() {
		return AlunoId;
	}
	public void setAlunoId(int AlunoId) {
		this.AlunoId = AlunoId;
	}
	public int getTurmaId() {
		return TurmaId;
	}
	public void setTurmaId(int TurmaId) {
		this.TurmaId = TurmaId;
	}
	
	public String toString() {
		return    "\n\tCod. Turma..............: " + getTurmaId()
				+ "\n\tCod. Aluno..............: " + getAlunoId();
	}

}
