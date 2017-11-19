package edu.asselvi.controller;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.AlunoTurmaDAO;
import edu.asselvi.dao.BimestreDAO;
import edu.asselvi.dao.CursoDAO;
import edu.asselvi.dao.DisciplinaDAO;
import edu.asselvi.dao.DisciplinaProfessorDAO;
import edu.asselvi.dao.DisciplinaSerieDAO;
import edu.asselvi.dao.EscolaDAO;
import edu.asselvi.dao.FrequenciaDAO;
import edu.asselvi.dao.HorarioDAO;
import edu.asselvi.dao.NotaDAO;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.dao.TurmaDAO;
import edu.asselvi.dao.UsuarioDAO;

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
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		EscolaDAO escolaDAO = new EscolaDAO();
		CursoDAO cursoDAO = new CursoDAO();
		SerieDAO serieDAO = new SerieDAO();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		DisciplinaSerieDAO disciplinaSerieDAO = new DisciplinaSerieDAO();
		DisciplinaProfessorDAO disciplinaProfessorDAO = new DisciplinaProfessorDAO();
		TurmaDAO turmaDAO = new TurmaDAO();
		HorarioDAO horarioDAO = new HorarioDAO();
		BimestreDAO bimestreDAO = new BimestreDAO();
		AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO();
		NotaDAO notaDAO = new NotaDAO();
		FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
		try {
			horarioDAO.criaTabela();
			usuarioDAO.criaTabela();
			pessoaDAO.criaTabela();
			escolaDAO.criaTabela();
			disciplinaDAO.criaTabela();
			cursoDAO.criaTabela();
			bimestreDAO.criaTabela();
			disciplinaSerieDAO.criaTabela();
			disciplinaProfessorDAO.criaTabela();
			alunoTurmaDAO.criaTabela();			
			notaDAO.criaTabela();
			frequenciaDAO.criaTabela();
			serieDAO.criaTabela();
			turmaDAO.criaTabela();
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
