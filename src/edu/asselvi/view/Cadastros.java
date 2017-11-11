package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.AlunoTurma;
import edu.asselvi.model.Bimestre;
import edu.asselvi.model.Curso;
import edu.asselvi.model.DisciplinaProfessor;
import edu.asselvi.model.DisciplinaSerie;
import edu.asselvi.model.Horario;
import edu.asselvi.model.Professor;
import edu.asselvi.model.Serie;
import edu.asselvi.model.Turma;

public class Cadastros {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static void cadastraCurso() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Cursos      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Curso curso = new Curso();
			// criar auto-incremento do c�digo de curso //debug
			System.out.println("Informe a descri��o do curso.....: ");
			curso.setDescricao(teclado.readLine());
			System.out.println("Informe o c�digo da escola.......: ");
			curso.setEscolaId(Integer.parseInt(teclado.readLine()));
			System.out.println("Deseja cadastrar novo curso?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	}

	public static void cadastraSerie() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de S�ries      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Serie serie = new Serie();
			// verificar duplicidade // debug
			System.out.println("Informe o n�mero da s�rie........: ");
			serie.setSerieId(Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a descri��o da s�rie.....: ");
			serie.setDescricao(teclado.readLine());
			System.out.println("Informe a idade m�nima...........: ");
			serie.setIdadeMinima(Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a dura��o(meses).........: ");
			serie.setDuracao((Integer.parseInt(teclado.readLine())));
			System.out.println("Informe o c�digo do curso........: ");
			serie.setCursoId(Integer.parseInt(teclado.readLine()));

			DisciplinaSerie discSerie = new DisciplinaSerie();
			System.out.println("Informe o c�digo das disciplinas.: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int disciplina = Integer.parseInt(teclado.readLine());
			while (disciplina != 0) {
				discSerie.setDisciplinaId(disciplina);
				disciplina = Integer.parseInt(teclado.readLine());
			}

			System.out.println("Deseja cadastrar nova s�rie?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		;
	};

	public static void cadastraTurma() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Turmas      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Turma turma = new Turma();
			// auto incremento do c�d de turma // debug
			System.out.println("Informe a descri��o da turma.....: ");
			turma.setDescricao(teclado.readLine());
			System.out.println("Informe o n�mero de vagas........: ");
			turma.setVagas(Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o ano correspondente.....: ");
			turma.setAno((Integer.parseInt(teclado.readLine())));
			System.out.println("Informe o c�digo da s�rie........: ");
			turma.setSerieId(Integer.parseInt(teclado.readLine()));
			System.out.println("Deseja cadastrar nova turma?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		;
	};

	public static void cadastraDisciplina() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��  Cadastro de Disciplinas   ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Turma turma = new Turma();
			// auto incremento do c�d de turma // debug
			System.out.println("Informe a descri��o da disciplina: ");
			turma.setDescricao(teclado.readLine());
			System.out.println("Deseja cadastrar nova disciplina?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		;
	};

	public static void cadastraProfessor() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��   Cadastro de Professores  ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Professor professor = new Professor();
			// auto incremento do c�d de professor // debug
			System.out.println("Informe o nome...................: ");
			professor.setNome(teclado.readLine());
			System.out.println("Informe o cpf....................: ");
			professor.setCpf(teclado.readLine());
			System.out.println("Informe o telefone...............: ");
			professor.setTelefone(teclado.readLine());
			System.out.println("Informe a data de nascimento.....: ");
			professor.setDataNascimento(new Date(teclado.readLine()));
			System.out.println("Informe o email..................: ");
			professor.setEmail(teclado.readLine());
			System.out.println("Informe o sexo...................: ");
			professor.setSexo(ESexo.valueOf(teclado.readLine()));

			DisciplinaProfessor discProfessor = new DisciplinaProfessor();
			System.out.println("Informe o c�digo das disciplinas.: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int disciplina = Integer.parseInt(teclado.readLine());
			while (disciplina != 0) {
				discProfessor.setDisciplinaId(disciplina);
				disciplina = Integer.parseInt(teclado.readLine());
			}

			System.out.println("Deseja cadastrar novo professor?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	};

	public static void cadastraHorario() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Hor�rios    ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Horario horario = new Horario();
			// criar auto-incremento do c�digo de curso //debug
			System.out.println("Informe o dia da semana(1-2-3-4-5): ");
			horario.setDiaSemana(Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o c�digo da disciplina...: ");
			horario.setDisciplinaId(Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o c�digo da turma........: ");
			horario.setTurmaId(Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a hora de in�cio.........: ");
			horario.setHoraInicio(Integer.parseInt(teclado.readLine()));
			System.out.println("Deseja cadastrar novo hor�rio?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	};

	public static void cadastraAluno() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Alunos      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Aluno aluno = new Aluno();
			// auto incremento do c�d de aluno // debug
			System.out.println("Informe o nome...................: ");
			aluno.setNome(teclado.readLine());
			System.out.println("Informe o cpf....................: ");
			aluno.setCpf(teclado.readLine());
			System.out.println("Informe o telefone...............: ");
			aluno.setTelefone(teclado.readLine());
			System.out.println("Informe a data de nascimento.....: ");
			aluno.setDataNascimento(new Date(teclado.readLine()));
			System.out.println("Informe o email..................: ");
			aluno.setEmail(teclado.readLine());
			System.out.println("Informe o sexo...................: ");
			aluno.setSexo(ESexo.valueOf(teclado.readLine()));
			System.out.println("Informe o nome da m�e............: ");
			aluno.setNomeMae(teclado.readLine());

			AlunoTurma alunoTurma = new AlunoTurma();
			System.out.println("Informe o c�digo da turma........: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int turma = Integer.parseInt(teclado.readLine());
			while (turma != 0) {
				alunoTurma.setTurmaId(turma);
				turma = Integer.parseInt(teclado.readLine());
			}

			System.out.println("Deseja cadastrar novo aluno?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	};

	public static void cadastraBimestre() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Bimestre    ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			// auto incremento do c�d de bimestre // debug
			// limitar a quatro bimestres
			int bimestreId = 0;
			System.out.println("Informe a data de in�cio.........: ");
			String dataInicio = (teclado.readLine());
			System.out.println("Informe a data de t�rmino........: ");
			String dataFim = (teclado.readLine());
			System.out.println("Informe o n�mero de dias letivos.: ");
			int diasLetivos = (Integer.parseInt(teclado.readLine()));
			Bimestre bimestre = new Bimestre(bimestreId, dataInicio, dataFim, diasLetivos);

			System.out.println("Deseja cadastrar novo bimestre?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	}
}
