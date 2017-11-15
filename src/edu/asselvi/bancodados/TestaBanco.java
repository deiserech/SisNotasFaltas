package edu.asselvi.bancodados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asselvi.dao.BimestreDAO;
import edu.asselvi.dao.CursoDAO;
import edu.asselvi.dao.DisciplinaDAO;
import edu.asselvi.dao.DisciplinaProfessorDAO;
import edu.asselvi.dao.HorarioDAO;
import edu.asselvi.dao.NotaDAO;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.dao.TurmaDAO;
import edu.asselvi.dao.UsuarioDAO;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Pessoa;

public class TestaBanco {
	public static void main(String[] args) throws BDException {
		System.out.println("Início..");
		// BaseDAO baseDAO = new BaseDAO();
		// try {
		// baseDAO.criaBase("xpto");
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }
		PessoaDAO pessoa = new PessoaDAO();
		DisciplinaProfessorDAO disciplinaProfessor = new DisciplinaProfessorDAO();
		NotaDAO nota = new NotaDAO();
		SerieDAO serie = new SerieDAO();
		TurmaDAO turma = new TurmaDAO();
		UsuarioDAO usuario = new UsuarioDAO();
		
	//	pessoa.criaTabela();
//		disciplinaProfessor.criaTabela();
//		nota.criaTabela();
//		serie.criaTabela();
//		turma.criaTabela();
		usuario.criaTabela();

//		try {
//			System.out.println(pessoaDAO.exclui(8) ? "Sucesso" : "Não existe");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		
//		Pessoa pessoa = new Pessoa(1, "Danton Cavalcanti Franco Junior", 'M', 300, true, new Date(), "Itoupava Norte");

		// //ALTERA
		// try {
		// Pessoa pessoa = pessoaDAO.consulta(1);
		// pessoa.setNome("Carlos");
		// pessoa.setSexo(ESexo.MASCULINO);
		// pessoaDAO.altera(pessoa);
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }

		// Consuta todos
		// try {
		// for (Pessoa pessoa : pessoaDAO.consulta()) {
		// System.out.println(pessoa);
		// }
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }

		// try {
		// Pessoa pessoa = pessoaDAO.consulta(2);
		// System.out.println(pessoa.toString());
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }

		// System.out.println("Inicio...");
		// List<Pessoa> pessoas = new ArrayList<Pessoa>();
		// for (int i = 1; i <= 10; i++) {
		// pessoas.add(new Pessoa(0,"Deise", "063.730.909-06", "(47)999114492", new
		// Date(),
		// "deiserech@outlook.com", ESexo.FEMININO));
		// }
		// PessoaDAO pessoaDAO = new PessoaDAO();
		// try {
		// pessoaDAO.insereTrn(pessoas);
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }

		// List<Curso> cursos = new ArrayList<Curso>();
		// for (int i = 1; i <= 10; i++) {
		// cursos.add(new Curso( i+1, "Teste " + i)) ;
		// }
		// CursoDAO cursoDAO = new CursoDAO();
		// try {
		// cursoDAO.insereTrn(cursos);
		// } catch (BDException e) {
		// System.out.println(e.getMessage());
		// }

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
