package edu.asselvi.bancodados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asselvi.dao.CursoDAO;
import edu.asselvi.dao.GenericDAO;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Curso;
import edu.asselvi.model.Pessoa;

public class TestaBanco {
	public static void main(String[] args) {
		// BaseDAO baseDAO = new BaseDAO();
		// try {
		// baseDAO.criaBase("xpto");
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }
		// PessoaDAO pessoaDAO = new PessoaDAO();
		// try {
		// System.out.println(pessoaDAO.exclui(5) ? "Sucesso" : "Não existe");
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }
		// Pessoa pessoa = new Pessoa(1, "Danton Cavalcanti Franco Junior", 'M', 300,
		// true, new Date(), "Itoupava Norte");
		// try {
		// Pessoa pessoa = pessoaDAO.consulta(1);
		// pessoa.setSalario(1000);
		// pessoaDAO.altera(pessoa);
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }

		// try {
		// for (Pessoa pessoa : pessoaDAO.consulta()) {
		// System.out.println(pessoa);
		// }
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }
		// try {
		// Pessoa pessoa = pessoaDAO.consulta(100);
		// System.out.println(pessoa.toString());
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }
		//
		System.out.println("Inicio...");
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (int i = 1; i <= 10; i++) {
			pessoas.add(new Pessoa(i, "Deise", "Oswaldo Simon,228", "063.730.909-06", "(47)999114492", new Date(),
					"deiserech@outlook.com", ESexo.FEMININO));
		}
		PessoaDAO pessoaDAO = new PessoaDAO();
		try {
			pessoaDAO.insereTrn(pessoas);
		} catch (BDException e) {
			System.out.println(e.getMessage());
		}

//		List<Curso> cursos = new ArrayList<Curso>();
//		for (int i = 1; i <= 10; i++) {
//			cursos.add(new Curso(i, i+1, "Teste " +  i))	;				
//		}
//		CursoDAO cursoDAO = new CursoDAO();
//		try {
//			cursoDAO.insereTrn(cursos);
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}

		// try {
		// for (Pessoa pessoa : pessoas) {
		// pessoaDAO.insere(pessoa);
		// }
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }
		System.out.println("Fim...");
		// PessoaDAO pessoaDAO = new PessoaDAO();
		// try {
		// pessoaDAO.criaTabela();
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }

		// try {
		// pessoaDAO.destroiTabela();
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }

		// System.out.println("Abrir conexão");
		// try {
		// Connection conexao = Conexao.getConexao();
		// System.out.println("Abri sucesso!!");
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }
		// System.out.println("Fechar a conexão");
		// try {
		// Conexao.closeConexao();
		// System.out.println("Fechei sucesso!!");
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }
		// System.out.println("fim");
	}
}
