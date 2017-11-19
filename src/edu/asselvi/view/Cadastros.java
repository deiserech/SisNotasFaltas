package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.asselvi.controller.FuncoesGenericas;
import edu.asselvi.enumerador.EErrosIO;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.AlunoTurma;
import edu.asselvi.model.Bimestre;
import edu.asselvi.model.Curso;
import edu.asselvi.model.Disciplina;
import edu.asselvi.model.DisciplinaProfessor;
import edu.asselvi.model.DisciplinaSerie;
import edu.asselvi.model.Escola;
import edu.asselvi.model.Horario;
import edu.asselvi.model.Funcionario;
import edu.asselvi.model.Serie;
import edu.asselvi.model.Turma;
import edu.asselvi.model.Usuario;

public class Cadastros {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static DateFormat hf = new SimpleDateFormat("hh:mm:ss");

	public static List<Escola> cadastraEscola() {
		List<Escola> escolas = new ArrayList<Escola>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro da Escola      ��|");
		System.out.println("----------------------------------");
		int escolaId = 0;
		System.out.println("Informe o nome da escola.........: ");
		String descricao = FuncoesGenericas.lerCampoString();
		escolas.add(new Escola(escolaId, descricao));
		return escolas;
	}

	public static List<Curso> cadastraCurso(Map<Integer, Integer> escolas) {
		char novo = 'S';
		List<Curso> cursos = new ArrayList<Curso>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Cursos      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			System.out.println("Informe a descri��o do curso.....: ");
			String descricao = FuncoesGenericas.lerCampoString();
			int escolaId = 0;
			int numSeries = 0;
			do {
				System.out.println("Informe o c�digo da escola.......: ");
				escolaId = FuncoesGenericas.lerCampoInt();
				if (escolaId != 0) {
					if (!escolas.values().contains(escolaId)) {
						System.out.println(EErrosIO.INSERE_CODIGO.getMensagem());
						escolaId = 0;
					}
				}
			} while (escolaId == 0);
			do {
				System.out.println("Informe o n�mero de s�ries.......: ");
				numSeries = FuncoesGenericas.lerCampoInt();
			} while (numSeries == 0);
			cursos.add(new Curso(0, escolaId, numSeries, descricao));

			System.out.println("Deseja cadastrar novo curso?(S/N).: ");
			novo = Character.toUpperCase((FuncoesGenericas.lerCampoString().charAt(0)));
		}
		return cursos;
	}

	public static List<Object> cadastraSerie(Map<Integer, Integer> seriesCad, Map<Integer, Integer> cursosCad,
			Map<Integer, Integer> discCad) {
		List<Object> retorno = new ArrayList<Object>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de S�ries      ��|");
		System.out.println("----------------------------------");

		int serieId = 0;
		boolean serieOk = false;
		do {
			System.out.println("Informe o n�mero da s�rie........: ");
			serieId = FuncoesGenericas.lerCampoInt();
			if (serieId > 0 && serieId < 10) {
				if (seriesCad.values().contains(serieId)) {
					System.out.println(EErrosIO.INSERE_EXISTENTE.getMensagem());
					serieId = FuncoesGenericas.lerCampoInt();
				} else {
					serieOk = true;
				}
			} else {
				System.out.println(EErrosIO.INSERE_CODIGO.getMensagem());
			}
		} while (!serieOk || serieId == 0);

		System.out.println("Informe a descri��o..............: ");
		String descricao = FuncoesGenericas.lerCampoString();

		int cursoId = 0;
		do {
			System.out.println("Informe o c�digo do curso........: ");
			cursoId = FuncoesGenericas.lerCampoInt();
			if (cursoId != 0) {
				if (!cursosCad.values().contains(cursoId)) {
					System.out.println(EErrosIO.INSERE_CODIGO.getMensagem());
					cursoId = 0;
				}
			}
		} while (cursoId == 0);

		System.out.println("Informe a idade m�nima...........: ");
		int idadeMinima = FuncoesGenericas.lerCampoInt();
		System.out.println("Informe a dura��o(meses).........: ");
		int duracao = FuncoesGenericas.lerCampoInt();
		retorno.add(new Serie(serieId, cursoId, descricao, idadeMinima, duracao));

		System.out.println("Informe o c�digo das disciplinas.: ");
		System.out.println("Digite '0' para SAIR.............: ");
		int disciplina = FuncoesGenericas.lerCampoInt();
		while (disciplina != 0) {
			if (discCad.values().contains(disciplina)) {
				retorno.add(new DisciplinaSerie(disciplina, serieId));
				discCad.put(disciplina, disciplina);
			} else {
				System.out.println(EErrosIO.INSERE_INVALIDO.getMensagem());
			}

			System.out.println("Informe o c�digo das disciplinas.: ");
			disciplina = FuncoesGenericas.lerCampoInt();
		}
		return retorno;
	};

	public static List<Turma> cadastraTurma(Map<Integer, Integer> seriesCad) {
		char novo = 'S';
		List<Turma> turmas = new ArrayList<Turma>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Turmas      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int turmaId = 0;
			System.out.println("Informe a descri��o da turma.....: ");
			String descricao = FuncoesGenericas.lerCampoString();

			int serieId = 0;
			do {
				System.out.println("Informe o c�digo da s�rie........: ");
				serieId = FuncoesGenericas.lerCampoInt();
				if (serieId != 0) {
					if (!seriesCad.values().contains(serieId)) {
						System.out.println(EErrosIO.INSERE_CODIGO.getMensagem());
						serieId = 0;
					}
				}
			} while (serieId == 0);

			System.out.println("Informe o n�mero de vagas........: ");
			int vagas = FuncoesGenericas.lerCampoInt();
			System.out.println("Informe o ano correspondente.....: ");
			int ano = FuncoesGenericas.lerCampoInt();
			turmas.add(new Turma(turmaId, serieId, descricao, vagas, ano));

			System.out.println("Deseja cadastrar nova turma?(S/N).: ");
			novo = FuncoesGenericas.lerCampoChar();
			;
		}
		return turmas;
	};

	public static List<Disciplina> cadastraDisciplina() throws IOException {
		char novo = 'S';
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��  Cadastro de Disciplinas   ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int disciplinaId = 0;
			System.out.println("Informe a descri��o da disciplina: ");
			String descricao = (teclado.readLine());
			disciplinas.add(new Disciplina(disciplinaId, descricao));

			System.out.println("Deseja cadastrar nova disciplina?(S/N).: ");
			novo = FuncoesGenericas.lerCampoChar();
			;
		}
		return disciplinas;
	};

	public static List<Object> cadastraFuncionario(int funcionarioId, int usuarioId, Map<Integer, Integer> discCad) {
		List<Object> retorno = new ArrayList<Object>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��  Cadastro de Funcion�rios  ��|");
		System.out.println("----------------------------------");

		System.out.println("Informe o nome...................: ");
		String nome = FuncoesGenericas.lerCampoString();
		System.out.println("Informe o cpf....................: ");
		String cpf = FuncoesGenericas.lerCampoString();

		Date dataNascimento = null;
		do {
			System.out.println("Informe a data de nascimento.....: ");
			dataNascimento = FuncoesGenericas.lerData();
		} while (dataNascimento == null);

		ESexo sexo = null;
		do {
			System.out.println("Informe o sexo(M/F)..............: ");
			sexo = FuncoesGenericas.lerSexo();
		} while (sexo == null);

		int tipoUsuario = 0;
		do {
			System.out.println("Informe o perfil do usu�rio......: ");
			System.out.println("(1-Coordenador/2-Secret�ria/3-Professor)");
			tipoUsuario = FuncoesGenericas.lerCampoInt();
			if(tipoUsuario > 3) {
				System.out.println(EErrosIO.INSERE_CODIGO.getMensagem());
			}
		} while (tipoUsuario == 0);

		System.out.println("Informe o login..................: ");
		String login = FuncoesGenericas.lerCampoString();
		System.out.println("Informe a senha..................: ");
		String senha = FuncoesGenericas.lerCampoString();

		retorno.add(new Usuario(usuarioId, login, senha));
		retorno.add(new Funcionario(funcionarioId, usuarioId, tipoUsuario, nome, cpf, dataNascimento, sexo));

		if (tipoUsuario == 3) {
			System.out.println("Informe o c�digo das disciplinas.: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int disciplina = FuncoesGenericas.lerCampoInt();
			while (disciplina != 0) {
				if (discCad.values().contains(disciplina)) {
					retorno.add(new DisciplinaProfessor(disciplina, funcionarioId));
					discCad.put(disciplina, disciplina);
				} else {
					System.out.println(EErrosIO.INSERE_INVALIDO.getMensagem());
				}
				System.out.println("Informe o c�digo das disciplinas.: ");
				disciplina = FuncoesGenericas.lerCampoInt();
			}
		}
		return retorno;
	};

	public static List<Horario> cadastraHorario(Map<Integer, Integer> serieTurma, Map<Integer, Integer> discCad,
			Map<Integer, Integer> turmaCad) {
		char novo = 'S';
		System.out.println(serieTurma.values().toString());
		List<Horario> horarios = new ArrayList<Horario>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Hor�rios    ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int horarioId = 0;
			int diaSemana = 0;
			do {
				System.out.println("Informe o dia da semana(2-3-4-5-6): ");
				diaSemana = FuncoesGenericas.lerCampoInt();
				if(diaSemana < 2 || diaSemana > 6) {
					System.out.println(EErrosIO.INSERE_NUMERO.getMensagem());
				}
			} while (diaSemana < 2 || diaSemana > 6);

			int disciplinaId = 0;
			do {
				System.out.println("Informe o c�digo da disciplina...: ");
				disciplinaId = FuncoesGenericas.lerCampoInt();
				if (disciplinaId != 0) {
					if (!discCad.values().contains(disciplinaId)) {
						System.out.println(EErrosIO.INSERE_CODIGO.getMensagem());
						disciplinaId = 0;
					}
				}
			} while (disciplinaId == 0);

			int turmaId = 0;
			do {
				System.out.println("Informe o c�digo da turma........: ");
				turmaId = FuncoesGenericas.lerCampoInt();
				if (turmaId != 0) {
					if (!turmaCad.values().contains(turmaId)) {
						System.out.println(EErrosIO.INSERE_CODIGO.getMensagem());
						turmaId = 0;
					}
				}
			} while (turmaId == 0);

			System.out.println("Informe a hora de in�cio.........: ");
			String horaInicio = FuncoesGenericas.lerCampoString();
			horarios.add(new Horario(horarioId, diaSemana, disciplinaId, turmaId, horaInicio));

			System.out.println("Deseja cadastrar novo hor�rio?(S/N).: ");
			novo = FuncoesGenericas.lerCampoChar();
			;
		}
		return horarios;
	};

	public static List<Object> cadastraAluno(int alunoId, int usuarioId, Map<Integer, Integer> turmasCad) {
		List<Object> retorno = new ArrayList<Object>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Alunos      ��|");
		System.out.println("----------------------------------");
		int tipoUsuario = 4;
		System.out.println("Informe o nome...................: ");
		String nome = FuncoesGenericas.lerCampoString();
		System.out.println("Informe o cpf....................: ");
		String cpf = FuncoesGenericas.lerCampoString();

		Date dataNascimento = null;
		do {
			System.out.println("Informe a data de nascimento.....: ");
			dataNascimento = FuncoesGenericas.lerData();
		} while (dataNascimento == null);

		ESexo sexo = null;
		do {
			System.out.println("Informe o sexo(M/F)..............: ");
			sexo = FuncoesGenericas.lerSexo();
		} while (sexo == null);
		retorno.add(new Aluno(alunoId, usuarioId, tipoUsuario, nome, cpf, dataNascimento, sexo));

		System.out.println("Informe o login..................: ");
		String login = FuncoesGenericas.lerCampoString();
		System.out.println("Informe a senha..................: ");
		String senha = FuncoesGenericas.lerCampoString();
		retorno.add(new Usuario(usuarioId, login, senha));
		System.out.println("Informe o c�digo da turma........: ");
		System.out.println("Digite '0' para SAIR.............: ");
		List<Integer> turmas = new ArrayList<Integer>();
		int turmaId = FuncoesGenericas.lerCampoInt();
		while (turmaId != 0) {
			if (turmasCad.values().contains(turmaId)) {
				if(!turmas.contains(turmaId)) {
					retorno.add(new AlunoTurma(alunoId, turmaId));
					turmas.add(turmaId);
				}else{
					System.out.println(EErrosIO.INSERE_EXISTENTE.getMensagem());
				}
			} else {
				System.out.println(EErrosIO.INSERE_INVALIDO.getMensagem());
			}
			System.out.println("Informe o c�digo da turma........: ");
			turmaId = FuncoesGenericas.lerCampoInt();
		}

		return retorno;
	};

	public static List<Bimestre> cadastraBimestre() {
		char novo = 'S';
		int cont = 0;
		List<Bimestre> bimestres = new ArrayList<Bimestre>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Bimestre    ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			cont++;
			int bimestreId = 0;
			System.out.println("Informe a desci��o do bimestre...: ");
			String descricao = FuncoesGenericas.lerCampoString();

			Date dataInicio = null;
			do {
				System.out.println("Informe a data de in�cio.........: ");
				dataInicio = FuncoesGenericas.lerData();
			} while (dataInicio == null);

			Date dataFim = null;
			do {
				System.out.println("Informe a data de fim............: ");
				dataFim = FuncoesGenericas.lerData();
			} while (dataFim == null);

			System.out.println("Informe o n�mero de dias letivos.: ");
			int diasLetivos = FuncoesGenericas.lerCampoInt();
			bimestres.add(new Bimestre(bimestreId, descricao, dataInicio, dataFim, diasLetivos));
			if (cont < 4) { // 4 bimestres
				System.out.println("Deseja cadastrar novo bimestre?(S/N).: ");
				novo = FuncoesGenericas.lerCampoChar();
				;
			}
		}
		return bimestres;
	}

}
