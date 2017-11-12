package edu.asselvi.model;

import java.util.Date;

public class Bimestre {
	private int bimestreId;
	private String descricao;
	private Date dataInicio;
	private Date dataFim;
	private int diasLetivos;

	public Bimestre() {
		this(0,"Não informado", new Date(), new Date(), 0);
	}

	public Bimestre(int bimestreId, String descricao, Date dataInicio, Date dataFim, int diasLetivos) { 
		setBimestreId(bimestreId);
		setDescricao(descricao);
		setDataInicio(dataInicio);
		setDataFim(dataFim);
		setDiasLetivos(diasLetivos);
	}
	
	
	public int getBimestreId() {
		return bimestreId;
	}

	public void setBimestreId(int bimestreId) {
		this.bimestreId = bimestreId;
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
		return        "\n\tCód Bimestre............: " + getBimestreId()
					+ "\n\tData Início.............: " + getDataInicio()
					+ "\n\tData Fim................: " + getDataFim()
					+ "\n\tDias Letivos............: " + getDiasLetivos();
	}
}
