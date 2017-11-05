package edu.asselvi.model;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.IEntidadeBase;

public class Curso implements IEntidadeBase {
	private int cursoId;
	private int escolaId; //FK - c�digo da escola
	private String descricao;
	
	public Curso() {
		this(0, 0, "N�o Informado");
	}
	
	public Curso(int cursoId, int escolaId, String descricao) {
		setCursoId(cursoId);
		setEscolaId(escolaId);
		setDescricao(descricao);
	}	
	
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int id) {
		this.cursoId = id;
	}
	public int getEscolaId() {
		return escolaId;
	}
	public void setEscolaId(int escolaId) {
		this.escolaId = escolaId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return    "\n\tC�d. Curso..............: " + getCursoId()
				+ "\n\tC�d. Escola.............: " + getEscolaId()
				+ "\n\tDescri�ao...............: " + getDescricao();
	}

	@Override
	public int getId() {
		return cursoId;
	}	
}