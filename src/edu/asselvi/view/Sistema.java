package edu.asselvi.view;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.AlunoTurmaDAO;
import edu.asselvi.dao.DisciplinaProfessorDAO;
import edu.asselvi.dao.DisciplinaSerieDAO;
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
		SerieDAO serieDao = new SerieDAO();
		TurmaDAO turmaDao = new TurmaDAO();
		DisciplinaProfessorDAO discProfDao = new DisciplinaProfessorDAO();
		DisciplinaSerieDAO discSerieDao = new DisciplinaSerieDAO();
		AlunoTurmaDAO AlunoturmaDao = new AlunoTurmaDAO();

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
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
		}
		
		if (pessoas != null) {
			pessDao.insereTrn(pessoas);
		}
		if (series != null) {
			serieDao.insereTrn(series);
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
		PessoaDAO pessoa = new PessoaDAO();
		// CursoDAO curso = new CursoDAO();
		// DisciplinaDAO disciplina = new DisciplinaDAO();
		// SerieDAO disciplina = new SerieDAO();
		// TurmaDAO turma = new TurmaDAO();
		// FuncionarioDAO funcionario = new FuncionarioDAO();
		// HorarioDAO Horario = new HorarioDAO();
		// BimestreDAO bimestre = new BimestreDAO();
		// AlunoDAO aluno = new AlunoDAO();
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
						// curso.insereTrn(Cadastros.cadastraCurso());
						Cadastros.cadastraCurso();
						break;
					case 2:
						// disciplina.insereTrn(Cadastros.cadastraDisciplina());
						Cadastros.cadastraDisciplina();
						break;
					case 3:
						// serie.insereTrn(Cadastros.cadastraSerie());
						Cadastros.cadastraSerie();
						break;
					case 4:
						// turma.insereTrn(Cadastros.cadastraTurma());
						Cadastros.cadastraTurma();
						break;
					case 5:
						int funcionarioId = pessoa.retornaProximoId();
						// pessoa.insereTrn(Cadastros.cadastraFuncionario(funcionarioId));
						insereBanco(Cadastros.cadastraFuncionario(funcionarioId));
						break;
					case 6:
						// horario.insereTrn(Cadastros.cadastraHorario());
						Cadastros.cadastraHorario();
						break;
					case 7:
						// Aluno.insereTrn(Cadastros.cadastraAluno());
						Cadastros.cadastraAluno();
						break;
					case 8:
						// Aluno.insereTrn(Cadastros.cadastraAluno());
						Cadastros.cadastraBimestre();
						break;
					}
					opcaoCad = Menu.menuCadastros();
				}
				break;
			case 2:
				Nota nota = new Nota();
				Frequencia frequencia = new Frequencia();
				int opcaoLan = Menu.menuLancamentos();
				while (opcaoLan != 0) {
					switch (opcaoLan) {
					case 1:
						// nota = Lancamentos.lancamentoNotas();
						break;
					case 2:
						// frequencia = Lancamentos.lancamentoFrequencia();
						break;
					}
					opcaoLan = Menu.menuLancamentos();
				}
				break;
			case 3:
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
			case 4:
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
