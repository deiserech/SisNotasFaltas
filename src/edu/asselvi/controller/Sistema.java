package edu.asselvi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.AlunoDAO;
import edu.asselvi.dao.AlunoTurmaDAO;
import edu.asselvi.dao.BimestreDAO;
import edu.asselvi.dao.CursoDAO;
import edu.asselvi.dao.DisciplinaDAO;
import edu.asselvi.dao.DisciplinaProfessorDAO;
import edu.asselvi.dao.DisciplinaSerieDAO;
import edu.asselvi.dao.EscolaDAO;
import edu.asselvi.dao.FuncionarioDAO;
import edu.asselvi.dao.HorarioDAO;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.dao.TurmaDAO;
import edu.asselvi.dao.UsuarioDAO;
import edu.asselvi.model.AlunoTurma;
import edu.asselvi.model.DisciplinaProfessor;
import edu.asselvi.model.DisciplinaSerie;
import edu.asselvi.model.Frequencia;
import edu.asselvi.model.Nota;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Serie;
import edu.asselvi.model.Turma;
import edu.asselvi.model.Usuario;
import edu.asselvi.view.Cadastros;
import edu.asselvi.view.Lancamentos;
import edu.asselvi.view.Login;
import edu.asselvi.view.Menu;

public class Sistema {

	private static int login() throws BDException, IOException {
		UsuarioDAO usuario = new UsuarioDAO();
		int perfil = usuario.verificaLogin(Login.telaLogin(false));
		while (perfil == 0) {
			perfil = usuario.verificaLogin(Login.telaLogin(true));
		}
		return perfil;
	}

	private static void insereBanco(List<Object> lista) throws BDException {
		PessoaDAO pessDao = new PessoaDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		SerieDAO serieDao = new SerieDAO();
		TurmaDAO turmaDao = new TurmaDAO();
		DisciplinaProfessorDAO discProfDao = new DisciplinaProfessorDAO();
		DisciplinaSerieDAO discSerieDao = new DisciplinaSerieDAO();
		AlunoTurmaDAO AlunoturmaDao = new AlunoTurmaDAO();

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<Serie> series = new ArrayList<Serie>();
		List<Turma> turmas = new ArrayList<Turma>();
		List<DisciplinaProfessor> disciplinasProfessor = new ArrayList<DisciplinaProfessor>();
		List<DisciplinaSerie> disciplinasSerie = new ArrayList<DisciplinaSerie>();
		List<AlunoTurma> alunosTurma = new ArrayList<AlunoTurma>();

		for (Object obj : lista) {
			if (obj instanceof Pessoa) {
				pessoas.add((Pessoa) obj);
				continue;
			}
			if (obj instanceof Serie) {
				series.add((Serie) obj);
				continue;
			}
			if (obj instanceof Turma) {
				turmas.add((Turma) obj);
				continue;
			}
			if (obj instanceof DisciplinaProfessor) {
				disciplinasProfessor.add((DisciplinaProfessor) obj);
				continue;
			}
			if (obj instanceof DisciplinaSerie) {
				disciplinasSerie.add((DisciplinaSerie) obj);
				continue;
			}
			if (obj instanceof AlunoTurma) {
				alunosTurma.add((AlunoTurma) obj);
				continue;
			}
			if (obj instanceof Usuario) {
				usuarios.add((Usuario) obj);
				continue;
			}
		}

		if (series != null) {
			serieDao.insereTrn(series);
		}
		if (usuarios != null) {
			usuarioDao.insereTrn(usuarios);
		}
		if (turmas != null) {
			turmaDao.insereTrn(turmas);
		}
		if (disciplinasProfessor != null) {
			discProfDao.insereTrn(disciplinasProfessor);
		}
		if (disciplinasSerie != null) {
			discSerieDao.insereTrn(disciplinasSerie);
		}
		if (alunosTurma != null) {
			AlunoturmaDao.insereTrn(alunosTurma);
		}
	}

	public static void main(String[] args) throws IOException, BDException, ParseException {
		EscolaDAO escola = new EscolaDAO();
		PessoaDAO pessoa = new PessoaDAO();
		AlunoDAO aluno = new AlunoDAO();
		UsuarioDAO usuario = new UsuarioDAO();
		CursoDAO curso = new CursoDAO();
		SerieDAO serie = new SerieDAO();
		DisciplinaDAO disciplina = new DisciplinaDAO();
		TurmaDAO turma = new TurmaDAO();
		HorarioDAO horario = new HorarioDAO();
		BimestreDAO bimestre = new BimestreDAO();
		int opcao = 0;
		int perfil = login();
		switch (perfil) {
		case 1:
			opcao = Menu.menuCoordenador();
			break;
		case 2:
			opcao = Menu.menuSecretaria();
			break;
		case 3:
			opcao = Menu.menuProfessor();
			break;
		case 4:
			opcao = Menu.menuAluno();
			break;
		}
		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcaoCad = Menu.menuCadastros();
				while (opcaoCad != 0) {
					switch (opcaoCad) {
					case 1:
						escola.insereTrn(Cadastros.cadastraEscola());
						break;
					case 2:
						curso.insereTrn(Cadastros.cadastraCurso());
						break;
					case 3:
						disciplina.insereTrn(Cadastros.cadastraDisciplina());
						break;
					case 4:
						insereBanco(Cadastros.cadastraSerie(serie.consultaIds()));
						break;
					case 5:
						turma.insereTrn(Cadastros.cadastraTurma());
						break;
					case 6:
						bimestre.insereTrn(Cadastros.cadastraBimestre());
						break;
					case 7:
						horario.insereTrn(Cadastros.cadastraHorario(turma.consultaSerieTurmas()));
						break;
					case 8:
						insereBanco(Cadastros.cadastraFuncionario(pessoa.retornaProximoId(), usuario.retornaProximoId()));
						break;
					}
					opcaoCad = Menu.menuCadastros();
				}
			case 2:
				int opcaoMat = Menu.menuMatriculas();
				while (opcaoMat != 0) {
					switch (opcaoMat) {
					case 1:
						insereBanco(Cadastros.cadastraAluno(pessoa.retornaProximoId(), usuario.retornaProximoId()));
						break;
					}
				}
				break;
			case 3:
				Nota nota = new Nota();
				Frequencia frequencia = new Frequencia();
				int opcaoLan = Menu.menuLancamentos();
				while (opcaoLan != 0) {
					switch (opcaoLan) {
					case 1:
				//		Lancamentos.lancaNotasTurma(aluno.consultaAlunosTurma(Lancamentos.BuscaTurma()));
						break;
					case 2:
						// frequencia = Lancamentos.lancamentoFrequencia();
						break;
					}
					opcaoLan = Menu.menuLancamentos();
				}
				break;
			case 4:
				int opcaoCon = Menu.menuConsultas();
				while (opcaoCon != 0) {
					switch (opcaoCon) {
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					}
					opcaoCon = Menu.menuConsultas();
				}
				break;
			case 5:
				int opcaoRel = Menu.menuRelatorios();
				while (opcaoRel != 0) {
					switch (opcaoRel) {
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					}
					opcaoRel = Menu.menuRelatorios();
				}

				break;
			}
			// opcao = Menu.menuPrincipal();

		}
	}
}
