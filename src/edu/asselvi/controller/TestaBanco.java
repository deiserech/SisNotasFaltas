package edu.asselvi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.AlunoTurmaDAO;
import edu.asselvi.dao.BimestreDAO;
import edu.asselvi.dao.CursoDAO;
import edu.asselvi.dao.DisciplinaDAO;
import edu.asselvi.dao.DisciplinaProfessorDAO;
import edu.asselvi.dao.DisciplinaSerieDAO;
import edu.asselvi.dao.NotaDAO;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.dao.TurmaDAO;
import edu.asselvi.dao.UsuarioDAO;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Pessoa;

public class TestaBanco {
	public static void main(String[] args) {
//		IPadraoDAO baseDAO = new IPadraoDAO();
//		try {
//	//		baseDAO.criaBase("xpto");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		try {
//			System.out.println(pessoaDAO.exclui(5) ? "Sucesso" : "Não existe");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		Pessoa pessoa = new Pessoa(1, "Danton Cavalcanti Franco Junior", 'M', 300, true, new Date(), "Itoupava Norte");
//		try {
//			Pessoa pessoa = pessoaDAO.consulta(1);
//			pessoa.setSalario(1000);
//			pessoaDAO.altera(pessoa);
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			for (Pessoa pessoa : pessoaDAO.consulta()) {
//				System.out.println(pessoa);
//			}
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			Pessoa pessoa = pessoaDAO.consulta(100);
//			System.out.println(pessoa.toString());
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println("Inicio...");
//		List<Pessoa> pessoas = new ArrayList<Pessoa>();
//		for(int i = 1; i <= 00; i++) {
//			pessoas.add(new Pessoa("Deise Rech", "Oswaldo Simon,228","063-730-909-06", "(47)999114492","07/12/1988", "deiserech@outlook.com", ESexo.FEMININO ));
////			pessoas.add(new Pessoa());
//		}
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		try {
//			pessoaDAO.insereTrn(pessoas, "Pessoa");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			for (Pessoa pessoa : pessoas) {
//				pessoaDAO.insere(pessoa);
//			}
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("Início...");
		CursoDAO cursoDAO = new CursoDAO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		DisciplinaSerieDAO disciplinaSerieDAO = new DisciplinaSerieDAO();
		DisciplinaProfessorDAO disciplinaProfessorDAO = new DisciplinaProfessorDAO();
		AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO();
		NotaDAO notaDAO = new NotaDAO();
		SerieDAO serieDAO = new SerieDAO();
		TurmaDAO turmaDAO = new TurmaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		BimestreDAO bimestreDAO = new BimestreDAO();
		try {
			cursoDAO.criaTabela();
			bimestreDAO.criaTabela();
			pessoaDAO.criaTabela();
			disciplinaDAO.criaTabela();
			disciplinaSerieDAO.criaTabela();
			disciplinaProfessorDAO.criaTabela();
			alunoTurmaDAO.criaTabela();			
			notaDAO.criaTabela();
			serieDAO.criaTabela();
			turmaDAO.criaTabela();
			usuarioDAO.criaTabela();
		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fim...");

//		try {
//			pessoaDAO.destroiTabela();
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}

//		System.out.println("Abrir conexão");
//		try {
//			Connection conexao = Conexao.getConexao();
//			System.out.println("Abri sucesso!!");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("Fechar a conexão");
//		try {
//			Conexao.closeConexao();
//			System.out.println("Fechei sucesso!!");
//		} catch (BDException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("fim");
	}
}
