package edu.asselvi.model;

import java.util.Date;

public class Horario {
	private int HorarioId;
	private int TurmaId;
	private int DisciplinaId;
	private int diaSemana;
	private String horaInicio;
	
	public Horario() {
		this(0,0,0,0,"");
	}
		
	public Horario(int HorarioId, int diaSemana, int DisciplinaId, int TurmaId, String horaInicio) {
		setHorarioId(HorarioId);
		setDiaSemana(diaSemana);
		setDisciplinaId(DisciplinaId);
		setTurmaId(TurmaId);
		setHoraInicio(horaInicio);
	}

	public int getHorarioId() {
		return HorarioId;
	}
	
	public void setHorarioId(int HorarioId) {
		this.HorarioId = HorarioId;
	}
	
	public int getDisciplinaId() {
		return DisciplinaId;
	}
	public void setDisciplinaId(int DisciplinaId) {
		this.DisciplinaId = DisciplinaId;
	}
	public int getTurmaId() {
		return TurmaId;
	}
	public void setTurmaId(int TurmaId) {
		this.TurmaId = TurmaId;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
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
	
	 public String toStringBD(String separador) {
	        return this.getHorarioId() + separador + getTurmaId() + separador + getDisciplinaId() + separador + getDiaSemana() + separador + getHoraInicio();
	    }
}
