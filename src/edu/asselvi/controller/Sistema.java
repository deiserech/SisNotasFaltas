package edu.asselvi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

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
import edu.asselvi.dao.FuncionarioDAO;
import edu.asselvi.dao.HorarioDAO;
import edu.asselvi.dao.NotaDAO;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.dao.TurmaDAO;
import edu.asselvi.dao.UsuarioDAO;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.AlunoTurma;
import edu.asselvi.model.Base;
import edu.asselvi.model.Disciplina;
import edu.asselvi.model.DisciplinaProfessor;
import edu.asselvi.model.DisciplinaSerie;
import edu.asselvi.model.Funcionario;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Serie;
import edu.asselvi.model.Turma;
import edu.asselvi.model.Usuario;
import edu.asselvi.view.Cadastros;
import edu.asselvi.view.Consulta;
import edu.asselvi.view.Lancamentos;
import edu.asselvi.view.Login;
import edu.asselvi.view.Menu;
import edu.asselvi.view.Relatorios;

public class Sistema {
	static Calendar calendar = new GregorianCalendar();
	private static int idPessoaLogada = 0;
	private static int tpPessoaLogada = 0;
	public static Base base = new Base();

	private static Pessoa login() throws BDException, IOException {
		UsuarioDAO usuario = new UsuarioDAO();
		PessoaDAO pessoaDao = new PessoaDAO();
		int user = usuario.verificaLogin(Login.telaLogin(false));
		while (user == 0) {
			user = usuario.verificaLogin(Login.telaLogin(true));
		}
		return pessoaDao.consultaUsuario(user);
	}

	private static int verificaMenu() throws BDException, IOException {
		switch (tpPessoaLogada) {
		case 1:
			return Menu.menuCoordenador();
		case 2:
			return Menu.menuSecretaria();
		case 3:
			return Menu.menuProfessor();
		case 4:
			return Menu.menuAluno();
		}
		return 0;
	}

	private static void insereBanco(List<Object> lista) throws BDException {
		AlunoDAO alunoDao = new AlunoDAO();
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		SerieDAO serieDao = new SerieDAO();
		TurmaDAO turmaDao = new TurmaDAO();
		DisciplinaProfessorDAO discProfDao = new DisciplinaProfessorDAO();
		DisciplinaSerieDAO discSerieDao = new DisciplinaSerieDAO();
		AlunoTurmaDAO AlunoturmaDao = new AlunoTurmaDAO();

		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
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
			alunoDao.insereTrn(alunos);
		}
		if (funcionarios != null) {
			funcionarioDao.insereTrn(funcionarios);
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

	public static void acessoCoordenador() throws BDException, IOException, ParseException {
		EscolaDAO escola = new EscolaDAO();
		FuncionarioDAO funcionario = new FuncionarioDAO();
		UsuarioDAO usuario = new UsuarioDAO();
		CursoDAO curso = new CursoDAO();
		SerieDAO serie = new SerieDAO();
		DisciplinaDAO disciplina = new DisciplinaDAO();
		HorarioDAO horario = new HorarioDAO();
		BimestreDAO bimestre = new BimestreDAO();
		TurmaDAO turmaDao = new TurmaDAO();

		int opcao = verificaMenu();
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
						insereBanco(Cadastros.cadastraSerie(serie.consultaIds(), curso.consultaIds(),
								disciplina.consultaIds()));
						break;
					case 5:
						turmaDao.insereTrn(Cadastros.cadastraTurma(serie.consultaIds()));
						break;
					case 6:
						bimestre.insereTrn(Cadastros.cadastraBimestre());
						break;
					case 7:
						horario.insereTrn(Cadastros.cadastraHorario(turmaDao.consultaSerieTurmas(),
								disciplina.consultaIds(), turmaDao.consultaIds()));
						break;
					case 8:
						insereBanco(Cadastros.cadastraFuncionario(funcionario.retornaProximoId(),
								usuario.retornaProximoId(), disciplina.consultaIds()));
						break;
					default:
						Menu.mensagens(2);
						opcaoCad = Menu.menuCadastros();
						break;
					}
					opcaoCad = Menu.menuCadastros();
				}
				opcao = verificaMenu();
				break;
			default:
				Menu.mensagens(2);
				opcao = verificaMenu();
				break;
			}
		}
		Menu.mensagens(3);
	};

	public static void acessoSecretaria() throws BDException, IOException, ParseException {
		AlunoDAO aluno = new AlunoDAO();
		UsuarioDAO usuario = new UsuarioDAO();
		TurmaDAO turmaDao = new TurmaDAO();

		int opcao = verificaMenu();
		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcaoMat = Menu.menuMatriculas();
				while (opcaoMat != 0) {
					switch (opcaoMat) {
					case 1:
						insereBanco(Cadastros.cadastraAluno(aluno.retornaProximoId(), usuario.retornaProximoId(),
								turmaDao.consultaIds()));
						break;
					default:
						Menu.mensagens(2);
						opcaoMat = Menu.menuMatriculas();
						break;
					}
					opcaoMat = Menu.menuMatriculas();
				}
				opcao = verificaMenu();
				break;
			default:
				Menu.mensagens(2);
				opcao = verificaMenu();
				break;
			}
		}
		Menu.mensagens(3);

	};

	public static void acessoProfessor() throws BDException, IOException, ParseException {
		AlunoDAO alunoDao = new AlunoDAO();
		AlunoTurmaDAO alunoTurmaDao = new AlunoTurmaDAO();
		TurmaDAO turmaDao = new TurmaDAO();
		HorarioDAO horarioDao = new HorarioDAO();
		NotaDAO notaDao = new NotaDAO();
		FrequenciaDAO frequenciaDao = new FrequenciaDAO();
		DisciplinaProfessorDAO discProfDao = new DisciplinaProfessorDAO();
		DisciplinaSerieDAO discSerieDao = new DisciplinaSerieDAO();
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();

		int opcao = verificaMenu();

		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcaoLan = Menu.menuLancamentos();
				int idTurma = 0;
				int idDisciplina = 0;
				while (opcaoLan != 0) {
					idTurma = Lancamentos.BuscaTurma(turmaDao.consultaIds());
					Turma turmaObj = turmaDao.consulta(idTurma);
					List<Integer> discProfessor = discProfDao.consultaDisciplinas(idPessoaLogada);
					List<Integer> disciplinas = discSerieDao.consultaDisciProf(turmaObj.getSerieId(), discProfessor);
					Map<Integer, Disciplina> disciplinaObj = disciplinaDao.consultaDescricao(disciplinas);
					idDisciplina = Lancamentos.BuscaDisciplina(disciplinaObj);
					List<Integer> alunos = alunoTurmaDao.consultaAlunosTurma(idTurma);

					switch (opcaoLan) {
					case 1:
						notaDao.insereTrn(Lancamentos.lancaNotasTurma(idTurma, FuncoesGenericas.buscaBimestre(),
								idDisciplina, alunoDao.consultaAlunosTurma(alunos)));
						break;
					case 2:
						frequenciaDao.insereTrn(Lancamentos.lancaFrequenciaTurma(
								horarioDao.consulta(idTurma, idDisciplina, turmaDao.consulta(idTurma).getSerieId(),
										calendar.get(Calendar.DAY_OF_WEEK)),
								alunoDao.consultaAlunosTurma(alunos), FuncoesGenericas.buscaBimestre()));

						break;
					default:
						Menu.mensagens(2);
						opcaoLan = Menu.menuLancamentos();
						break;
					}
					opcaoLan = Menu.menuLancamentos();
				}
				opcao = verificaMenu();
				break;
			case 2:
				int opcaoRel = Menu.menuRelatorios();
				while (opcaoRel != 0) {
					idTurma = Lancamentos.BuscaTurma(turmaDao.consultaIds());
					Turma turmaObj = turmaDao.consulta(idTurma);
					List<Integer> alunosCod = alunoTurmaDao.consultaAlunosTurma(idTurma);
					Map<Integer, Aluno> alunos = alunoDao.consultaAlunosTurma(alunosCod);
					List<Integer> discProfessor = discProfDao.consultaDisciplinas(idPessoaLogada);
					List<Integer> disciplinas = discSerieDao.consultaDisciProf(turmaObj.getSerieId(), discProfessor);

					switch (opcaoRel) {
					case 1:
						Relatorios.relatorioNotas(turmaObj, alunos, disciplinaDao.consultaIds(),
								notaDao.consultaNotasTurma(alunos), disciplinas);
						break;
					case 2:
						Relatorios.relatorioFrequencia(turmaObj, alunos, disciplinaDao.consultaIds(),
								frequenciaDao.consultaFreqTurma(alunos));
						break;
					default:
						Menu.mensagens(2);
						opcaoLan = Menu.menuRelatorios();
						break;
					}
					opcaoRel = Menu.menuRelatorios();
				}
				opcao = verificaMenu();
				break;
			default:
				Menu.mensagens(2);
				opcao = verificaMenu();
				break;

			}
		}
		Menu.mensagens(3);

	};

	public static void acessoAluno() throws BDException, IOException {
		NotaDAO notaDao = new NotaDAO();
		FrequenciaDAO frequenciaDao = new FrequenciaDAO();
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();

		int opcao = verificaMenu();

		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcaoCon = Menu.menuConsultas();
				while (opcaoCon != 0) {
					switch (opcaoCon) {
					case 1:
						Consulta.consultaNota(notaDao.consultaNotasAluno(idPessoaLogada), disciplinaDao.consultaIds());
						break;
					case 2:
						Consulta.consultaFrequencia(frequenciaDao.consultaFreqAluno(idPessoaLogada));
						break;
					default:
						opcaoCon = Menu.menuConsultas();
						Menu.mensagens(2);
						break;
					}
					opcaoCon = Menu.menuConsultas();
				}
				opcao = verificaMenu();
				break;
			default:
				opcao = verificaMenu();
				Menu.mensagens(2);
				break;

			}
		}
		Menu.mensagens(3);

	};

	public static void controlaAcesso() throws BDException, IOException, ParseException {
		Pessoa pessoaLogada = login();
		idPessoaLogada = pessoaLogada.getId();
		tpPessoaLogada = pessoaLogada.getPerfil();

		switch (tpPessoaLogada) {
		case 1:
			acessoCoordenador();
			break;
		case 2:
			acessoSecretaria();
			break;
		case 3:
			acessoProfessor();
			break;
		case 4:
			acessoAluno();
			break;
		}
	}

	public static void main(String[] args) throws IOException, BDException, ParseException {
		Instalador.buscaParametros();

		int opcao = Menu.menuInicial();
		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcInstal = Menu.menuInstalacao();
				while (opcInstal != 0) {
					switch (opcInstal) {
					case 1:
						Instalador.criarDatabase();
						opcInstal = Menu.menuInstalacao();
						break;
					case 2:
						Instalador.importarDados();
						opcInstal = Menu.menuInstalacao();
						break;
					case 3:
						Instalador.exportarDados();
						opcInstal = Menu.menuInstalacao();
						break;
					default:
						opcInstal = Menu.menuInstalacao();
						Menu.mensagens(2);
						break;
					}
				//	opcao = Menu.menuInicial();
				}
				break;
			case 2:
				controlaAcesso();
				break;
			default:
				Menu.mensagens(2);
				opcao = Menu.menuInicial();
				break;
			}
			opcao = Menu.menuInicial();
		}
		Menu.mensagens(3);
	}

}
