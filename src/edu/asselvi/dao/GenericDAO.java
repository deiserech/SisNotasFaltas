package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.bancodados.EErrosBD;
import edu.asselvi.conexao.Conexao;
import edu.asselvi.model.Pessoa;

public class GenericDAO<T extends IEntidadeBase> {

	public boolean insereTrn(List<T> t) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {

			conexao.setAutoCommit(false);
			if (t instanceof Pessoa) {
				PreparedStatement pst = conexao.prepareStatement(
						"INSERT INTO pessoa (codigo, nome, sexo, salario, ativo, nascimento, endereco) VALUES (?, ?, ?, ?, ?, ?, ?);");
				for (T pessoa : t) {
					pst.setInt(1, pessoa.getId());
					pst.setString(2, ((Pessoa) pessoa).getNome());
					pst.setString(4, ((Pessoa) pessoa).getEndereco());
					pst.setString(4, ((Pessoa) pessoa).getCpf());
					pst.setString(4, ((Pessoa) pessoa).getTelefone());
					pst.setDate(6, new java.sql.Date(((Pessoa) pessoa).getDataNascimento().getTime()));
					pst.setString(4, ((Pessoa) pessoa).getEmail());
					pst.setString(3, String.valueOf(((Pessoa) pessoa).getSexo()));
					pst.executeUpdate();
				}
			}
			conexao.commit();
			return true;
		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (Exception e2) {
				throw new BDException(EErrosBD.ROLLBACK, e2.getMessage());
			}
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage());
		} finally {
			Conexao.closeConexao();
		}

	}

}
