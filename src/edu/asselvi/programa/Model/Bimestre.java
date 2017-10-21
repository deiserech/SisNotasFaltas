package edu.asselvi.programa;

import java.util.Map;

public class Bimestre {
	private int bimestreId;
	private String dataInicio;
	private String dataFim;
	private int diasLetivos;
	private int contaNota = 1;
	//chave = num nota (1,2)
	private Map<Integer, Nota> notas;
	// ver o que usar como chave de frequência - debug
	private Map<Integer, Frequencia> frequencias;

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

	public void adicionaNota(Nota nota) {
		this.notas.put(new Integer(contaNota), nota);
	}
	
	public int lancaNota( int alunoId,int disciplinaId, int nrBimestre, float nota) {
		Nota notaAluno = new Nota(contaNota, alunoId, disciplinaId, nrBimestre, nota);
		return contaNota++;
	}	
	
	//encontrar chave única para a frequencia
	public void adicionaFrequencia(Frequencia frequencia) {
		this.frequencias.put(new Integer(frequencia.getDataAula()), frequencia);
	}

	public int lancaFrequencia(int alunoId, int disciplinaId, int turmaId, int diaSemana, int dataAula, boolean presente) {
		Frequencia frequencia = new Frequencia(alunoId, disciplinaId, turmaId, diaSemana, dataAula, presente);
		return contaNota++;
	}	

	@Override
	public String toString() {
		return        "\n\tCód Bimestre............: " + getBimestreId()
					+ "\n\tData Início.............: " + getDataInicio()
					+ "\n\tData Fim................: " + getDataFim()
					+ "\n\tDias Letivos............: " + getDiasLetivos();
	}

	
}
