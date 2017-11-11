package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.Bimestre;
import edu.asselvi.model.Curso;
import edu.asselvi.model.Disciplina;
import edu.asselvi.model.Horario;
import edu.asselvi.model.Professor;
import edu.asselvi.model.Serie;
import edu.asselvi.model.Turma;

public class Cadastros {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static List<Curso> cadastraCurso() throws IOException {
		char novo = 'S';
		List<Curso> cursos = new ArrayList<Curso>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Cursos      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			System.out.println("Informe a descri��o do curso.....: ");
			String descricao = (teclado.readLine());
			System.out.println("Informe o c�digo da escola.......: ");
			int escolaId = (Integer.parseInt(teclado.readLine()));
			cursos.add(new Curso(0, escolaId, descricao));

			System.out.println("Deseja cadastrar novo curso?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return cursos;
	}

	public static List<Serie> cadastraSerie() throws IOException {
		char novo = 'S';
		List<Serie> series = new ArrayList<Serie>();
		List<Integer> disciplinas = new ArrayList<Integer>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de S�ries      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			// verificar duplicidade // debug
			Serie serie = new Serie();
			System.out.println("Informe o n�mero da s�rie........: ");
			int serieId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a descri��o da s�rie.....: ");
			String descricao = (teclado.readLine());
			System.out.println("Informe a idade m�nima...........: ");
			int idadeMinima = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a dura��o(meses).........: ");
			int duracao = ((Integer.parseInt(teclado.readLine())));
			System.out.println("Informe o c�digo do curso........: ");
			int cursoId = (Integer.parseInt(teclado.readLine()));

			System.out.println("Informe o c�digo das disciplinas.: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int disciplina = Integer.parseInt(teclado.readLine());
			while (disciplina != 0) {
				disciplina = Integer.parseInt(teclado.readLine());
				disciplinas.add(disciplina);
			}
			series.add(new Serie(serieId, cursoId, descricao, idadeMinima, duracao, disciplinas));

			System.out.println("Deseja cadastrar nova s�rie?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));

		}
		return series;
	};

	public static List<Turma> cadastraTurma() throws IOException {
		char novo = 'S';
		List<Turma> turmas = new ArrayList<Turma>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Turmas      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int turmaId = 0;
			System.out.println("Informe a descri��o da turma.....: ");
			String descricao = (teclado.readLine());
			System.out.println("Informe o n�mero de vagas........: ");
			int vagas = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o ano correspondente.....: ");
			int ano = ((Integer.parseInt(teclado.readLine())));
			System.out.println("Informe o c�digo da s�rie........: ");
			int serieId = (Integer.parseInt(teclado.readLine()));
			turmas.add(new Turma(turmaId, descricao, vagas, ano, serieId));

			System.out.println("Deseja cadastrar nova turma?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
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
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return disciplinas;
	};

	public static void cadastraProfessor() throws IOException {
		char novo = 'S';
		List<Professor> professores = new ArrayList<Professor>();
		List<Integer> disciplinas = new ArrayList<Integer>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��   Cadastro de Professores  ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int professorId = 0;
			System.out.println("Informe o nome...................: ");
			String nome = (teclado.readLine());
			System.out.println("Informe o cpf....................: ");
			String cpf = (teclado.readLine());
			System.out.println("Informe o telefone...............: ");
			String telefone = (teclado.readLine());
			System.out.println("Informe a data de nascimento.....: ");
			Date dataNascimento = new Date((teclado.readLine()));
			System.out.println("Informe o n�mero da CTPS.........: ");
			int nrCartTrabalho = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o email..................: ");
			String email = (teclado.readLine());
			System.out.println("Informe o sexo...................: ");
			ESexo sexo = (ESexo.valueOf(teclado.readLine()));

			System.out.println("Informe o c�digo das disciplinas.: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int disciplina = Integer.parseInt(teclado.readLine());
			while (disciplina != 0) {
				disciplina = Integer.parseInt(teclado.readLine());
				disciplinas.add(disciplina);
			}
			professores.add(new Professor(professorId, nrCartTrabalho, nome, cpf, telefone, dataNascimento, email, sexo, disciplinas));

			System.out.println("Deseja cadastrar novo professor?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	};

	public static void cadastraHorario() throws IOException {
		char novo = 'S';
		List<Horario> horarios = new ArrayList<Horario>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Hor�rios    ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int horarioId = 0;
			System.out.println("Informe o dia da semana(1-2-3-4-5): ");
			int diaSemana = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o c�digo da disciplina...: ");
			int disciplinaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o c�digo da turma........: ");
			int turmaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a hora de in�cio.........: ");
			int horaInicio = (Integer.parseInt(teclado.readLine()));
			horarios.add(new Horario(horarioId, diaSemana, disciplinaId, turmaId, horaInicio));

			System.out.println("Deseja cadastrar novo hor�rio?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	};

	public static void cadastraAluno() throws IOException {
		char novo = 'S';
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Integer> turmas = new ArrayList<Integer>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Alunos      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int alunoId = 0;
			System.out.println("Informe o nome...................: ");
			String nome = (teclado.readLine());
			System.out.println("Informe o cpf....................: ");
			String cpf = (teclado.readLine());
			System.out.println("Informe o telefone...............: ");
			String telefone = (teclado.readLine());
			System.out.println("Informe a data de nascimento.....: ");
			Date dataNascimento = new Date((teclado.readLine()));
			System.out.println("Informe a idade..................: ");
			int idade = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o email..................: ");
			String email = (teclado.readLine());
			System.out.println("Informe o sexo...................: ");
			ESexo sexo = (ESexo.valueOf(teclado.readLine()));
			System.out.println("Informe o nome da m�e............: ");
			String nomeMae = (teclado.readLine());

			System.out.println("Informe o c�digo da turma........: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int turma = Integer.parseInt(teclado.readLine());
			while (turma != 0) {
				turma = Integer.parseInt(teclado.readLine());
				turmas.add(turma);
			}
			alunos.add(new Aluno(alunoId, nomeMae, nome, cpf, telefone, dataNascimento, email, sexo, turmas));

			System.out.println("Deseja cadastrar novo aluno?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	};

	public static void cadastraBimestre() throws IOException {
		char novo = 'S';
		List<Bimestre> bimestres = new ArrayList<Bimestre>();
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Bimestre    ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			// limitar a quatro bimestres - debug
			int bimestreId = 0;
			System.out.println("Informe a data de in�cio.........: ");
			String dataInicio = (teclado.readLine());
			System.out.println("Informe a data de t�rmino........: ");
			String dataFim = (teclado.readLine());
			System.out.println("Informe o n�mero de dias letivos.: ");
			int diasLetivos = (Integer.parseInt(teclado.readLine()));
			bimestres.add(new Bimestre(bimestreId, dataInicio, dataFim, diasLetivos));
			
			System.out.println("Deseja cadastrar novo bimestre?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		;
	};

}
