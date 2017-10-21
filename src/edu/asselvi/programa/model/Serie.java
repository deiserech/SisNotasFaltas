package edu.asselvi.programa.Model;

import java.util.ArrayList;
import java.util.List;

public class Serie {
	private int serieId;
	private int cursoId; //FK - código do curso
	private String descricao;
	private int idadeMinima;
	private int duracao; // meses
//	private Map<Integer, Disciplina> disciplinas;
//	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private List<Integer> disciplinas = new ArrayList<Integer>();

	
	public Serie() {
		this(0, 0, "Não Informado", 0, 0);
	}
	
	public Serie(int serieId, int cursoId, String descricao, int idadeMinima, int duracao) {
		setSerieId(serieId);
		setDescricao(descricao);
		setCursoId(cursoId);
		setIdadeMinima(idadeMinima);
		setDuracao(duracao);
	}	
	
	public int getSerieId() {
		return serieId;
	}
	public void setSerieId(int serieId) {
		this.serieId = serieId;
	}
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdadeMinima() {
		return idadeMinima;
	}
	public void setIdadeMinima(int idadeMinima) {
		this.idadeMinima = idadeMinima;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
//	public void adicionaDisciplina(Disciplina disciplina) {
//		this.disciplinas.add(new Integer(disciplina.getDisciplinaId()), disciplina);
//	}
	
	public void adicionaDisciplina(int disciplina) {
		this.disciplinas.add(new Integer(disciplina));
	}

	public String toString() {
		return super.toString()
				+ "\n\tCód. Sérei..............: " + getSerieId()
				+ "\n\tDescrição...............: " + getDescricao()
				+ "\n\tCód. Curso..............: " + getCursoId()
				+ "\n\tIdade Mínima............: " + getIdadeMinima()
				+ "\n\tDuração.................: " + getDuracao();
	}

}
