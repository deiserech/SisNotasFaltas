package edu.asselvi.model;

import java.util.Date;

public class Frequencia {
	private  int HorarioId;
	private  int AlunoId;
	private  int BimestreId;
	private  Date dataAula;
	private  boolean presente;

	public Frequencia() {
		this(0,0,0,new Date(),false);
	}
	
	public Frequencia(int horaroiId, int AlunoId, int BimestreId, Date dataAula, boolean presente) {
		setHorarioId(HorarioId);
		setAlunoId(AlunoId);
		setBimestreId(BimestreId);
		setDataAula(dataAula);
		setPresente(presente);
	}
	
	public int getAlunoId() {
		return AlunoId;
	}

	public void setAlunoId(int AlunoId) {
		this.AlunoId = AlunoId;
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
		return BimestreId;
	}
	
	public void setBimestreId(int BimestreId) {
		this.BimestreId = BimestreId;
	}
	
	public int getHorarioId() {
		return HorarioId;
	}
	
	public void setHorarioId(int HorarioId) {
		this.HorarioId = HorarioId;
	}

	public String toString() {
		return    "\n\tCód Aluno...............: " + getAlunoId()
				+ "\n\tCód. Horário............: " + getHorarioId()
				+ "\n\tCód. Bimestre...........: " + getBimestreId()
				+ "\n\tData da Aula............: " + getDataAula()
				+ "\n\tId Presença.............: " + isPresente();
	}
	
	 public String toStringBD(String separador) {
	        return this.getAlunoId() + separador + getHorarioId() + separador + getBimestreId() + separador + getDataAula() + separador + isPresente();
	    }
}
