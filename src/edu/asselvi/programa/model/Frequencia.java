package edu.asselvi.programa.model;

public class Frequencia {
	private  int alunoId;
	private  int disciplinaId;
	private  int turmaId;
	private  int diaSemana;
	private  int dataAula;
	private  boolean presente;

	public Frequencia() {
		this(0,0,0,0,0,false);
	}
	
	public Frequencia(int alunoId, int disciplinaId, int turmaId, int diaSemana, int dataAula, boolean presente) {
		setAlunoId(alunoId);
		setPresente(presente);
		setDisciplinaId(disciplinaId);
		setDiaSemana(diaSemana);
		setDataAula(dataAula);
		setTurmaId(turmaId);
	}
	
	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}

	public int getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public int getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getDataAula() {
		return dataAula;
	}

	public void setDataAula(int dataAula) {
		this.dataAula = dataAula;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}

	public String toString() {
		return    "\n\tCód Aluno...............: " + getAlunoId()
				+ "\n\tCód. Turma..............: " + getTurmaId()
				+ "\n\tCód. Discilina..........: " + getDisciplinaId()
				+ "\n\tDia da Semana...........: " + getDiaSemana()
				+ "\n\tData da Aula............: " + getDataAula()
				+ "\n\tId Presença.............: " + isPresente();
	}


}
