package edu.asselvi.programa;

public class Horario {
	private int horarioId;
	private int diaSemana;
	private int disciplinaId;//FK - codigo da Disciplina
	private int turmaId;//FK - codigo da turma
	private int horaInicio;
	
	public Horario() {
		this(0,0,0,0,0);
	}
		
	public Horario(int horarioId, int diaSemana, int disciplinaId, int turmaId, int horaInicio) {
		setHorarioId(horarioId);
		setDiaSemana(diaSemana);
		setDisciplinaId(disciplinaId);
		setTurmaId(turmaId);
		setHoraInicio(horaInicio);
	}

	public int getHorarioId() {
		return horarioId;
	}
	
	public void setHorarioId(int horarioId) {
		this.horarioId = horarioId;
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
	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
		
	public String toString() {
		return    "\n\tCód. Horário............: " + getHorarioId()
		        + "\n\tCód. Turma..............: " + getTurmaId()
				+ "\n\tCód. Discilina..........: " + getDisciplinaId()
				+ "\n\tDia da Semana...........: " + getDiaSemana()
				+ "\n\tHorário Início..........: " + getHoraInicio();
	}


	
	

}
