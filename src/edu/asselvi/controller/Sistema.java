package edu.asselvi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import edu.asselvi.dao.FrequenciaDAO;
import edu.asselvi.dao.HorarioDAO;
import edu.asselvi.dao.NotaDAO;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.dao.TurmaDAO;
import edu.asselvi.dao.UsuarioDAO;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.AlunoTurma;
import edu.asselvi.model.DisciplinaProfessor;
import edu.asselvi.model.DisciplinaSerie;
import edu.asselvi.model.Funcionario;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Serie;
import edu.asselvi.model.Turma;
import edu.asselvi.model.Usuario;
import edu.asselvi.view.Cadastros;
import edu.asselvi.view.Lancamentos;
import edu.asselvi.view.Login;
import edu.asselvi.view.Menu;

public class Sistema {
	static Calendar calendar = new GregorianCalendar();

	private static Pessoa login() throws BDException, IOException {
		UsuarioDAO usuario = new UsuarioDAO();
		PessoaDAO pessoaDao = new PessoaDAO();
		int user = usuario.verificaLogin(Login.telaLogin(false));
		while (user == 0) {
			user = usuario.verificaLogin(Login.telaLogin(true));
		}
		
		return pessoaDao.consultaUsuario(user);
	}

	private static void insereBanco(List<Object> lista) throws BDException {
		PessoaDAO pessoaDao = new PessoaDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		SerieDAO serieDao = new SerieDAO();
		TurmaDAO turmaDao = new TurmaDAO();
		DisciplinaProfessorDAO discProfDao = new DisciplinaProfessorDAO();
		DisciplinaSerieDAO discSerieDao = new DisciplinaSerieDAO();
		AlunoTurmaDAO AlunoturmaDao = new AlunoTurmaDAO();

		List<Pessoa> alunos = new ArrayList<Pessoa>();
		List<Pessoa> funcionarios = new ArrayList<Pessoa>();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<Serie> series = new ArrayList<Serie>();
		List<Turma> turmas = new ArrayList<Turma>();
		List<DisciplinaProfessor> disciplinasProfessor = new ArrayList<DisciplinaProfessor>();
		List<DisciplinaSerie> disciplinasSerie = new ArrayList<DisciplinaSerie>();
		List<AlunoTurma> alunosTurma = new ArrayList<AlunoTurma>();

		for (Object obj : lista) {
			if (obj instanceof Aluno) {
				alunos.add((Aluno) obj);
				continue;
			}
			if (obj instanceof Funcionario) {
				funcionarios.add((Funcionario) obj);
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

		if (usuarios != null) {
			usuarioDao.insereTrn(usuarios);
		}
		if (alunos != null) {
			pessoaDao.insereTrn(alunos);
		}
		if (funcionarios != null) {
			pessoaDao.insereTrn(funcionarios);
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

	public static void main(String[] args) throws IOException, BDException, ParseException, InputException {
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
		NotaDAO nota = new NotaDAO();
		FrequenciaDAO frequencia = new FrequenciaDAO();
		DisciplinaProfessorDAO discProf = new DisciplinaProfessorDAO();
		Pessoa pessoaLogada = new Pessoa();
		int opcao = 0;
//		pessoaLogada = login();
//		switch (pessoaLogada.getPerfil()) {
//		case 1:
//			opcao = Menu.menuCoordenador();
//			break;
//		case 2:
//			opcao = Menu.menuSecretaria();
//			break;
//		case 3:
//			opcao = Menu.menuProfessor();
//			break;
//		case 4:
//			opcao = Menu.menuAluno();
//			break;
//		}
		opcao = Menu.menuCoordenador();
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
						curso.insereTrn(Cadastros.cadastraCurso(escola.consultaIds()));
						break;
					case 3:
						disciplina.insereTrn(Cadastros.cadastraDisciplina());
						break;
					case 4:
						insereBanco(Cadastros.cadastraSerie(serie.consultaIds(), curso.consultaIds(), disciplina.consultaIds()));
						break;
					case 5:
						turma.insereTrn(Cadastros.cadastraTurma(serie.consultaIds()));
						break;
					case 6:
						bimestre.insereTrn(Cadastros.cadastraBimestre());
						break;
					case 7:
						horario.insereTrn(Cadastros.cadastraHorario(turma.consultaSerieTurmas(), disciplina.consultaIds(), turma.consultaIds()));
						break;
					case 8:
						insereBanco(Cadastros.cadastraFuncionario(pessoa.retornaProximoId(), usuario.retornaProximoId(), disciplina.consultaIds()));
						break;
					}
					opcaoCad = Menu.menuCadastros();
				}
			case 2:
				int opcaoMat = Menu.menuMatriculas();
				while (opcaoMat != 0) {
					switch (opcaoMat) {
					case 1:
						insereBanco(Cadastros.cadastraAluno(pessoa.retornaProximoId(), usuario.retornaProximoId(), turma.consultaIds()));
						break;
					}
				}
				break;
			case 3:
				int opcaoLan = Menu.menuLancamentos();
				int idTurma = 0;
				int idDisciplina = 0;
				while (opcaoLan != 0) {
					switch (opcaoLan) {
					case 1:
						idTurma = Lancamentos.BuscaTurma();
						nota.insereTrn(
								Lancamentos.lancaNotasTurma(idTurma,
										aluno.consultaAlunosTurma(idTurma),
										discProf.disciplinasProfessorTurma(idTurma, pessoaLogada.getId()),
										FuncoesGenericas.buscaBimestre())
								);
						break;
					case 2:
						idTurma = Lancamentos.BuscaTurma();
						idDisciplina = Lancamentos.BuscaDisciplina(discProf.disciplinasProfessorTurma(idTurma, pessoaLogada.getId()));
					//	int idSerie = turma.consulta(idTurma).getSerieId();
						frequencia.insereTrn( 
								Lancamentos.lancaFrequenciaTurma(
										horario.consulta(idTurma,idDisciplina,turma.consulta(idTurma).getSerieId(), calendar.get(Calendar.DAY_OF_WEEK)), 
										aluno.consultaAlunosTurma(idTurma),
										FuncoesGenericas.buscaBimestre()
								));

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
