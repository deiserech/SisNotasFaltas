package edu.asselvi.model;

public class Horario {
	private int HorarioId;
	private int TurmaId;
	private int DisciplinaId;
	private int SerieId;
	private int diaSemana;
	private int horaInicio;
	
	public Horario() {
		this(0,0,0,0,0);
	}
		
	public Horario(int HorarioId, int diaSemana, int DisciplinaId, int TurmaId, int horaInicio) {
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
	public int getSerieId() {
		return SerieId;
	}
	
	public void setSerieId(int SerieId) {
		this.SerieId = SerieId;
	}
		
	public Horario(int horarioId, int turmaId, int disciplinaId, int serieId, int diaSemana, int horaInicio) {
		super();
		HorarioId = horarioId;
		TurmaId = turmaId;
		DisciplinaId = disciplinaId;
		SerieId = serieId;
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
	}

	public String toString() {
		return    "\n\tCód. Horário............: " + getHorarioId()
		        + "\n\tCód. Turma..............: " + getTurmaId()
		        + "\n\tCód. Série..............: " + getSerieId()
				+ "\n\tCód. Discilina..........: " + getDisciplinaId()
				+ "\n\tDia da Semana...........: " + getDiaSemana()
				+ "\n\tHorário Início..........: " + getHoraInicio();
	}
}
