package edu.asselvi.dao;


import java.util.List;
import edu.asselvi.bancodados.BDException;

public interface GenericDAO <T> {
	public abstract boolean criaTabela() throws BDException;
	public abstract boolean destroiTabela() throws BDException;
	public abstract boolean insereTrn(List<T> t) throws BDException ;
	public abstract T consulta(int id) throws BDException ;
	public abstract List<T> consulta() throws BDException ;
	public abstract int retornaProximoId() throws BDException ;
	public abstract boolean altera(T t) throws BDException ;
	public abstract boolean exclui(int id) throws BDException ;
	
}
