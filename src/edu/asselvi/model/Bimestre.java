package edu.asselvi.model;

import java.util.Date;


public class Bimestre {
	private int BimestreId;
	private String descricao;
	private Date dataInicio;
	private Date dataFim;
	private int diasLetivos;

	public Bimestre() {
		this(0,"Não informado", new Date(), new Date(), 0);
	}

	public Bimestre(int BimestreId, String descricao, Date dataInicio, Date dataFim, int diasLetivos) { 
		setBimestreId(BimestreId);
		setDescricao(descricao);
		setDataInicio(dataInicio);
		setDataFim(dataFim);
		setDiasLetivos(diasLetivos);
	}
	
	
	public int getBimestreId() {
		return BimestreId;
	}

	public void setBimestreId(int BimestreId) {
		this.BimestreId = BimestreId;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getDiasLetivos() {
		return diasLetivos;
	}

	public void setDiasLetivos(int diasLetivos) {
		this.diasLetivos = diasLetivos;
	}

	@Override
	public String toString() {
		return        "\n\tCod Bimestre............: " + getBimestreId()
					+ "\n\tData Inicio.............: " + getDataInicio()
					+ "\n\tData Fim................: " + getDataFim()
					+ "\n\tDias Letivos............: " + getDiasLetivos();
	}
	
	 public String toStringBD(String separador) {
	        return this.getBimestreId() + separador + this.getDescricao() + separador + getDataInicio() +  separador + getDataFim() + separador + getDiasLetivos();
	    }
}
