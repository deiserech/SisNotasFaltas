package edu.asselvi.programa;

public class Nota {
	private int nrNota;
	private int alunoId;
	private int disciplinaId;
	private int nrBimestre;
	private float nota;

	public Nota() {
		this(0,0,0,0,0);
	}

	public Nota(int nrNota, int alunoId,int disciplinaId, int nrBimestre, float nota) {
		setNrNota(nrNota);
		setAlunoId(alunoId);
		setDisciplinaId(disciplinaId);
		setNrBimestre(nrBimestre);
		setNota(nota);
	}
	
	public  int getDisciplinaId() {
		return disciplinaId;
	}
	
	public  void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public  int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}
	public int getNrBimestre() {
		return nrBimestre;
	}
	
	public void setNrBimestre(int nrBimestre) {
		this.nrBimestre = nrBimestre;
	}

	public int getNrNota() {
		return nrNota;
	}
	
	public void setNrNota(int nrNota) {
		this.nrNota = nrNota;
	}
	
	public String toString() {
		return  	"\n\tNúmero da nota..........: " + getNrNota()
		        + 	"\n\tCód. Aluno..............: " + getAlunoId()
				+ 	"\n\tCód. Disciplina.........: " + getDisciplinaId()
				+ 	"\n\tNum. Bimestre...........: " + getNrBimestre()
				+ 	"\n\tNota..,,,,,.............: " + getNota();
	}



	
}
