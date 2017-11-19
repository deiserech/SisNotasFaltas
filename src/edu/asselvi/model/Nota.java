package edu.asselvi.model;

public class Nota {
	private int NotaId;
	private int AlunoId;
	private int DisciplinaId;
	private int BimestreId;
	private float nota;

	public Nota() {
		this(0,0,0,0,0);
	}

	public Nota(int NotaId, int AlunoId,int DisciplinaId, int BimestreId, float nota) {
		setNotaId(NotaId);
		setAlunoId(AlunoId);
		setDisciplinaId(DisciplinaId);
		setBimestreId(BimestreId);
		setNota(nota);
	}
	
	public  int getDisciplinaId() {
		return DisciplinaId;
	}
	
	public  void setDisciplinaId(int DisciplinaId) {
		this.DisciplinaId = DisciplinaId;
	}

	public  int getAlunoId() {
		return AlunoId;
	}

	public void setAlunoId(int AlunoId) {
		this.AlunoId = AlunoId;
	}
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}
	public int getBimestreId() {
		return BimestreId;
	}
	
	public void setBimestreId(int BimestreId) {
		this.BimestreId = BimestreId;
	}

	public int getNotaId() {
		return NotaId;
	}
	
	public void setNotaId(int NotaId) {
		this.NotaId = NotaId;
	}
	
	public String toString() {
		return  	"\n\tNúmero da nota..........: " + getNotaId()
		        + 	"\n\tCód. Aluno..............: " + getAlunoId()
				+ 	"\n\tCód. Disciplina.........: " + getDisciplinaId()
				+ 	"\n\tNum. Bimestre...........: " + getBimestreId()
				+ 	"\n\tNota..,,,,,.............: " + getNota();
	}	
	
	 public String toStringBD(String separador) {
	        return this.getNotaId() + separador + getAlunoId() + separador + getDisciplinaId() + separador + getBimestreId() + separador + getNota();
	    }
}
