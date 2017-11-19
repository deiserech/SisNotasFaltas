package edu.asselvi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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
	private static int idPessoaLogada = 0;
	private static int tpPessoaLogada = 0;
	
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
	
	public static void acessoCoordenador() throws BDException, IOException, ParseException {
		EscolaDAO escola = new EscolaDAO();
		PessoaDAO pessoa = new PessoaDAO();
		AlunoTurmaDAO alunoTurma = new AlunoTurmaDAO();
		UsuarioDAO usuario = new UsuarioDAO();
		CursoDAO curso = new CursoDAO();
		SerieDAO serie = new SerieDAO();
		DisciplinaDAO disciplina = new DisciplinaDAO();
		HorarioDAO horario = new HorarioDAO();
		BimestreDAO bimestre = new BimestreDAO();
		NotaDAO nota = new NotaDAO();
		FrequenciaDAO frequencia = new FrequenciaDAO();
		DisciplinaProfessorDAO discProf = new DisciplinaProfessorDAO();
		TurmaDAO turmaDao = new TurmaDAO();
		DisciplinaSerieDAO discSerie = new DisciplinaSerieDAO();

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
						insereBanco(Cadastros.cadastraFuncionario(pessoa.retornaProximoId(), usuario.retornaProximoId(),
								disciplina.consultaIds()));
						break;
					}
					opcaoCad = Menu.menuCadastros();
				}
				opcao = verificaMenu();
				break;
			case 2:
				int opcaoMat = Menu.menuMatriculas();
				;
				while (opcaoMat != 0) {
					switch (opcaoMat) {
					case 1:
						insereBanco(Cadastros.cadastraAluno(pessoa.retornaProximoId(), usuario.retornaProximoId(),
								turmaDao.consultaIds()));
						break;
					}
				}
				opcao = verificaMenu();
				break;
			case 3:
				int opcaoLan = Menu.menuLancamentos();
				int idTurma = 0;
				int idDisciplina = 0;
				while (opcaoLan != 0) {
					idTurma = Lancamentos.BuscaTurma();
					Turma turmaObj = turmaDao.consulta(idTurma);
					List <Integer> discProfessor = discProf.consultaDisciplinas(idPessoaLogada);
					List <Integer> disciplinas = discSerie.consultaDisciProf(turmaObj.getSerieId(), discProfessor );
					idDisciplina = Lancamentos.BuscaDisciplina(disciplinas);						
					List <Integer> alunos = alunoTurma.consultaAlunosTurma(idTurma);
					
					switch (opcaoLan) {
					case 1:
						nota.insereTrn(Lancamentos.lancaNotasTurma(idTurma,
								FuncoesGenericas.buscaBimestre(),
								idDisciplina,
								pessoa.consultaAlunosTurma(alunos),
								idDisciplina)
								);
						break;
					case 2:
						frequencia.insereTrn(Lancamentos.lancaFrequenciaTurma(
								horario.consulta(idTurma, idDisciplina, turmaDao.consulta(idTurma).getSerieId(),
								calendar.get(Calendar.DAY_OF_WEEK)),
								pessoa.consultaAlunosTurma(alunos), 
								FuncoesGenericas.buscaBimestre()));

						break;
					}
					opcaoLan = Menu.menuLancamentos();
				}
				opcao = verificaMenu();
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
				opcao = verificaMenu();
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
				opcao = verificaMenu();
				break;
			}
		}
		
	};
	public static void acessoSecretaria() throws BDException, IOException, ParseException {
		PessoaDAO pessoa = new PessoaDAO();
		AlunoTurmaDAO alunoTurma = new AlunoTurmaDAO();
		UsuarioDAO usuario = new UsuarioDAO();
		HorarioDAO horario = new HorarioDAO();
		NotaDAO nota = new NotaDAO();
		FrequenciaDAO frequencia = new FrequenciaDAO();
		DisciplinaProfessorDAO discProf = new DisciplinaProfessorDAO();
		TurmaDAO turmaDao = new TurmaDAO();
		DisciplinaSerieDAO discSerie = new DisciplinaSerieDAO();

		int opcao = verificaMenu();
		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcaoMat = Menu.menuMatriculas();
				;
				while (opcaoMat != 0) {
					switch (opcaoMat) {
					case 1:
						insereBanco(Cadastros.cadastraAluno(pessoa.retornaProximoId(), usuario.retornaProximoId(),
								turmaDao.consultaIds()));
						break;
					}
				}
				opcao = verificaMenu();
				break;
			case 2:
				int opcaoLan = Menu.menuLancamentos();
				int idTurma = 0;
				int idDisciplina = 0;
				while (opcaoLan != 0) {
					idTurma = Lancamentos.BuscaTurma();
					Turma turmaObj = turmaDao.consulta(idTurma);
					List <Integer> discProfessor = discProf.consultaDisciplinas(idPessoaLogada);
					List <Integer> disciplinas = discSerie.consultaDisciProf(turmaObj.getSerieId(), discProfessor );
					idDisciplina = Lancamentos.BuscaDisciplina(disciplinas);						
					List <Integer> alunos = alunoTurma.consultaAlunosTurma(idTurma);
					
					switch (opcaoLan) {
					case 1:
						nota.insereTrn(Lancamentos.lancaNotasTurma(idTurma,
								FuncoesGenericas.buscaBimestre(),
								idDisciplina,
								pessoa.consultaAlunosTurma(alunos),
								idDisciplina)
								);
						break;
					case 2:
						frequencia.insereTrn(Lancamentos.lancaFrequenciaTurma(
								horario.consulta(idTurma, idDisciplina, turmaDao.consulta(idTurma).getSerieId(),
								calendar.get(Calendar.DAY_OF_WEEK)),
								pessoa.consultaAlunosTurma(alunos), 
								FuncoesGenericas.buscaBimestre()));

						break;
					}
					opcaoLan = Menu.menuLancamentos();
				}
				opcao = verificaMenu();
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
				opcao = verificaMenu();
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
				opcao = verificaMenu();
				break;
			}
		}
		
	};
	public static void acessoProfessor() throws BDException, IOException, ParseException {
		PessoaDAO pessoa = new PessoaDAO();
		AlunoTurmaDAO alunoTurma = new AlunoTurmaDAO();
		TurmaDAO turma = new TurmaDAO();
		HorarioDAO horario = new HorarioDAO();
		NotaDAO nota = new NotaDAO();
		FrequenciaDAO frequencia = new FrequenciaDAO();
		DisciplinaProfessorDAO discProf = new DisciplinaProfessorDAO();
		TurmaDAO turmaDao = new TurmaDAO();
		DisciplinaSerieDAO discSerie = new DisciplinaSerieDAO();
		
		int opcao = verificaMenu();

		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcaoLan = Menu.menuLancamentos();
				int idTurma = 0;
				int idDisciplina = 0;
				while (opcaoLan != 0) {
					idTurma = Lancamentos.BuscaTurma();
					Turma turmaObj = turmaDao.consulta(idTurma);
					List <Integer> discProfessor = discProf.consultaDisciplinas(idPessoaLogada);
					List <Integer> disciplinas = discSerie.consultaDisciProf(turmaObj.getSerieId(), discProfessor );
					idDisciplina = Lancamentos.BuscaDisciplina(disciplinas);						
					List <Integer> alunos = alunoTurma.consultaAlunosTurma(idTurma);
					
					switch (opcaoLan) {
					case 1:
						nota.insereTrn(Lancamentos.lancaNotasTurma(idTurma,
								FuncoesGenericas.buscaBimestre(),
								idDisciplina,
								pessoa.consultaAlunosTurma(alunos),
								idDisciplina)
								);
						break;
					case 2:
						frequencia.insereTrn(Lancamentos.lancaFrequenciaTurma(
								horario.consulta(idTurma, idDisciplina, turma.consulta(idTurma).getSerieId(),
								calendar.get(Calendar.DAY_OF_WEEK)),
								pessoa.consultaAlunosTurma(alunos), 
								FuncoesGenericas.buscaBimestre()));

						break;
					}
					opcaoLan = Menu.menuLancamentos();
				}
				opcao = verificaMenu();
				break;
			case 2:
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
				opcao = verificaMenu();
				break;
			}
		}
		
		
	};
	public static void acessoAluno() throws BDException, IOException {
		int opcao = verificaMenu();

		while (opcao != 0) {
			switch (opcao) {
			case 1:
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
				opcao = verificaMenu();
				break;
			}
		}
		
		
	};

	public static void main(String[] args) throws IOException, BDException, ParseException, InputException {
		Pessoa pessoaLogada = login(); // ver trows
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

}
