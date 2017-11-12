package edu.asselvi.model;

public class Escola {
	private int cdEscola;
	private String nmEscola;
	
	public Escola() {
		this(0, "Não Informado");
	}
	public Escola(int cdEscola, String nmEscola) {
		setCdEscola(cdEscola);
		setNmEscola(nmEscola);
	}
	
	public int getCdEscola() {
		return cdEscola;
	}
	public void setCdEscola(int cdEscola) {
		this.cdEscola = cdEscola;
	}
	public String getNmEscola() {
		return nmEscola;
	}
	public void setNmEscola(String nmEscola) {
		this.nmEscola = nmEscola;
	}
	
	
}
