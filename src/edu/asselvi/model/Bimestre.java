package edu.asselvi.model;

import java.util.Map;

public class Bimestre {
	private int bimestreId;
	private String dataInicio;
	private String dataFim;
	private int diasLetivos;

	public Bimestre() {
		this(0, "00/00/0000", "00/00/0000", 0);
	}

	public Bimestre(int bimestreId, String dataInicio, String dataFim, int diasLetivos) { 
		setBimestreId(bimestreId);
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

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
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
