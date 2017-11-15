package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.AlunoDAO;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.Frequencia;
import edu.asselvi.model.Nota;

public class Lancamentos {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	static Calendar calendar = new GregorianCalendar();

	public static List<Nota> lancaNotasAluno() throws IOException {
		List<Nota> notas = new ArrayList<Nota>();
		char novo = 'S';
		int nrNota = 1;
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Lançamento de Notas     ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			int nrBimestre = 0; // pegar da data
			System.out.println("Informe o código do aluno........:");
			int alunoId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o código da disciplina...:");
			int disciplinaId = (Integer.parseInt(teclado.readLine()));
			// System.out.println("Informe o número do bimestre.....:"); // pegar do sistema
			// int nrBimestre = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a nota " + nrNota + ".................: ");
			float nota = (Integer.parseInt(teclado.readLine()));
			notas.add(new Nota(nrNota, alunoId, disciplinaId, nrBimestre, nota));

			System.out.println("Deseja inserir nova nota para");
			System.out.println("este aluno/disciplina/bimestre?(S/N).: ");
			if (Character.toUpperCase((teclado.readLine().charAt(0))) == 'S') {
				System.out.println("Informe a nota " + ++nrNota + ".................: ");
				nota = Float.parseFloat(teclado.readLine());
				notas.add(new Nota(nrNota, alunoId, disciplinaId, nrBimestre, nota));
			}
			System.out.println("Lançamento de notas foi realizado com sucesso!");
			System.out.println();
			System.out.println("Deseja inserir novas notas?(S/N) ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return notas;
	}

	public static int BuscaTurma() throws IOException, BDException {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Lançamento de Notas     ««|");
		System.out.println("----------------------------------");
		
		System.out.println("Informe o código da turma........:");
		int turmaId = (Integer.parseInt(teclado.readLine()));
		return turmaId; 
	}

	
	public static List<Nota> lancaNotasTurma(Map<Integer, Integer> alunosTurma, Map<Integer, Integer> disciTurmaProfessor, int bimestre) throws IOException, BDException {
		List<Nota> notas = new ArrayList<Nota>();
		List<Aluno> alunos = new ArrayList<Aluno>();
		AlunoDAO aluno = new AlunoDAO();

		char novo = 'S';
		int nrNota = 1;
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Lançamento de Notas     ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Date dataAula = calendar.getTime();
			int nrBimestre = 0; // pegar do sistema
			int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
			System.out.println("Informe o código da turma........:");
			int turmaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o código da disciplina...:");
			int disciplinaId = (Integer.parseInt(teclado.readLine()));
			alunos = aluno.consulta();

			for (Aluno al : alunos) {
				System.out.println("Informe a nota do aluno.........:");
				float nota = Float.parseFloat(teclado.readLine());
				int alunoId = 0; // pegar da lista
				int horrsrsrarioId = 0; // juntar campos
				int bimestreId = 0; // pegar do sistema
				notas.add(new Nota(nrNota, alunoId, disciplinaId, nrBimestre, nota));
			}
			System.out.println("Lançamento de notas para este aluno foi realizado com sucesso!");
		}
		return notas;
	}

	public static List<Frequencia> lancamentoFrequencia() throws IOException, BDException {
		List<Frequencia> frequencias = new ArrayList<Frequencia>();
		List<Aluno> alunos = new ArrayList<Aluno>();
		Calendar calendar = new GregorianCalendar();
		AlunoDAO aluno = new AlunoDAO();
		char novo = 'S';
		int nrNota = 1;
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»  Lançamento de Frequências  ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			Date dataAula = calendar.getTime();
			int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
			System.out.println("Informe o código da turma........:");
			int turmaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o código da disciplina...:");
			int disciplinaId = (Integer.parseInt(teclado.readLine()));

			alunos = aluno.consulta();

			for (Aluno al : alunos) {
				System.out.println("Informe a frequência(S/N).......:");
				boolean presente = Character.toUpperCase((teclado.readLine().charAt(0))) == 'S';
				int alunoId = 0;
				int horarioId = 0;
				int bimestreId = 0;
				frequencias.add(new Frequencia(horarioId, alunoId, bimestreId, dataAula, presente));
			}
			System.out.println("Lançamento de frequencias para esta turma foi realizada com sucesso!");
			System.out.println();
			System.out.println("Deseja inserir novas frequências?(S/N) ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
		return frequencias;
	}

}
