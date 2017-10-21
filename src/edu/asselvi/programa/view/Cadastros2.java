package edu.asselvi.programa.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.asselvi.programa.enumerador.ESexo;
import edu.asselvi.programa.model.Aluno;
import edu.asselvi.programa.model.Bimestre;
import edu.asselvi.programa.model.Curso;
import edu.asselvi.programa.model.Disciplina;
import edu.asselvi.programa.model.Horario;
import edu.asselvi.programa.model.Professor;
import edu.asselvi.programa.model.Serie;
import edu.asselvi.programa.model.Turma;

public class Cadastros2 {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static void cadastraCurso() throws IOException {
		char novo = 'S';
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Cadastro de Cursos      ��|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			// criar auto-incremento do c�digo de curso //debug
			int cursoId = 0;
			System.out.println("Informe a descri��o do curso.....: ");
			String descricao = (teclado.readLine());
			System.out.println("Informe o c�digo da escola.......: ");
			int escolaId = (Integer.parseInt(teclado.readLine()));
			Curso curso = new Curso(cursoId, escolaId, descricao);

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
			// verificar duplicidade // debug
			System.out.println("Informe o n�mero da s�rie........: ");
			int serieId=(Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a descri��o da s�rie.....: ");
			String descricao=(teclado.readLine());
			System.out.println("Informe a idade m�nima...........: ");
			int idadeMinima=(Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a dura��o(meses).........: ");
			int duracao=((Integer.parseInt(teclado.readLine())));
			System.out.println("Informe o c�digo do curso........: ");
			int cursoId=(Integer.parseInt(teclado.readLine()));
			Serie serie = new Serie();

//			DisciplinaSerie discSerie = new DisciplinaSerie();
			System.out.println("Informe o c�digo das disciplinas.: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int disciplina = Integer.parseInt(teclado.readLine());
			while (disciplina != 0) {
				serie.adicionaDisciplina(disciplina);
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
			// auto incremento do c�d de turma // debug
			int turmaId = 0;
			System.out.println("Informe a descri��o da turma.....: ");
			String descricao = (teclado.readLine());
			System.out.println("Informe o n�mero de vagas........: ");
			int vagas = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o ano correspondente.....: ");
			int ano = ((Integer.parseInt(teclado.readLine())));
			System.out.println("Informe o c�digo da s�rie........: ");
			int serieId = (Integer.parseInt(teclado.readLine()));
			Turma turma = new Turma(turmaId, descricao, vagas, ano, serieId);

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
			// auto incremento do c�d de turma // debug
			int disciplinaId = 0;
			System.out.println("Informe a descri��o da disciplina: ");
			String descricao = (teclado.readLine());
			Disciplina disciplina = new Disciplina(disciplinaId, descricao);

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
			// auto incremento do c�d de professor // debug
			int professorId = 0;
			System.out.println("Informe o nome...................: ");
			String nome = (teclado.readLine());
			System.out.println("Informe o endere�o...............: ");
			String endereco = (teclado.readLine());
			System.out.println("Informe o cpf....................: ");
			String cpf = (teclado.readLine());
			System.out.println("Informe o telefone...............: ");
			String telefone = (teclado.readLine());
			System.out.println("Informe a data de nascimento.....: ");
			String dataNasc = (teclado.readLine());
			System.out.println("Informe a idade..................: ");
			int idade = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o n�mero da CTPS.........: ");
			int nrCartTrabalho = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o email..................: ");
			String email = (teclado.readLine());
			System.out.println("Informe o sexo...................: ");
			ESexo sexo = (ESexo.valueOf(teclado.readLine()));
			Professor professor = new Professor(professorId, nrCartTrabalho, nome, endereco, cpf, telefone, dataNasc, idade, email, sexo);
			
//			DisciplinaProfessor discProfessor = new DisciplinaProfessor();
			System.out.println("Informe o c�digo das disciplinas.: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int disciplina = Integer.parseInt(teclado.readLine());
			while (disciplina != 0) {
				professor.adicionaDisciplina(disciplina);
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
			// criar auto-incremento do c�digo de curso //debug
			int horarioId = 0;
			System.out.println("Informe o dia da semana(1-2-3-4-5): ");
			int diaSemana = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o c�digo da disciplina...: ");
			int disciplinaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o c�digo da turma........: ");
			int turmaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a hora de in�cio.........: ");
			int horaInicio = (Integer.parseInt(teclado.readLine()));
			Horario horario = new Horario(horarioId, diaSemana, disciplinaId, turmaId, horaInicio);

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
			// auto incremento do c�d de aluno // debug
			int alunoId = 0;
			System.out.println("Informe o nome...................: ");
			String nome = (teclado.readLine());
			System.out.println("Informe o endere�o...............: ");
			String endereco = (teclado.readLine());
			System.out.println("Informe o cpf....................: ");
			String cpf = (teclado.readLine());
			System.out.println("Informe o telefone...............: ");
			String telefone = (teclado.readLine());
			System.out.println("Informe a data de nascimento.....: ");
			String dataNasc = (teclado.readLine());
			System.out.println("Informe a idade..................: ");
			int idade = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o email..................: ");
			String email = (teclado.readLine());
			System.out.println("Informe o sexo...................: ");
			ESexo sexo = (ESexo.valueOf(teclado.readLine()));
			System.out.println("Informe o nome da m�e............: ");
			String nomeMae = (teclado.readLine());
			Aluno aluno = new Aluno(alunoId, nomeMae, nome, endereco, cpf, telefone, dataNasc, idade, email, sexo);
			
//			AlunoTurma alunoTurma = new AlunoTurma();
			System.out.println("Informe o c�digo da turma........: ");
			System.out.println("Digite '0' para SAIR.............: ");
			int turma = Integer.parseInt(teclado.readLine());
			while (turma != 0) {
				aluno.adicionaTurma(turma);
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
			//limitar a quatro bimestres
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
		;
	};
	

}
