package edu.asselvi.model;

import java.util.Date;

public class Frequencia {
	private  int horarioId;
	private  int alunoId;
	private  int bimestreId;
	private  Date dataAula;
	private  boolean presente;

	public Frequencia() {
		this(0,0,0,new Date(),false);
	}
	
	public Frequencia(int horaroiId, int alunoId, int bimestreId, Date dataAula, boolean presente) {
		setHorarioId(horarioId);
		setAlunoId(alunoId);
		setBimestreId(bimestreId);
		setDataAula(dataAula);
		setPresente(presente);
	}
	
	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	public Date getDataAula() {
		return dataAula;
	}

	public void setDataAula(Date dataAula) {
		this.dataAula = dataAula;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}
	
	public int getBimestreId() {
		return bimestreId;
	}
	
	public void setBimestreId(int bimestreId) {
		this.bimestreId = bimestreId;
	}
	
	public int getHorarioId() {
		return horarioId;
	}
	
	public void setHorarioId(int horarioId) {
		this.horarioId = horarioId;
	}

	public String toString() {
		return    "\n\tCód Aluno...............: " + getAlunoId()
				+ "\n\tCód. Horário............: " + getHorarioId()
				+ "\n\tCód. Bimestre...........: " + getBimestreId()
				+ "\n\tData da Aula............: " + getDataAula()
				+ "\n\tId Presença.............: " + isPresente();
	}
}
