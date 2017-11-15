package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
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
import edu.asselvi.model.Horario;
import edu.asselvi.model.Nota;
import edu.asselvi.model.Turma;

public class Lancamentos {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	static Calendar calendar = new GregorianCalendar();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
		System.out.println("|»»          Lançamentos       ««|");
		System.out.println("----------------------------------");

		System.out.println("Informe o código da turma........:");
		int idTurma = (Integer.parseInt(teclado.readLine()));
		return idTurma;
	}

	public static int BuscaDisciplina(Map<Integer, Integer> discTurmaProfessor) throws IOException, BDException {
		boolean disciplinaOk = false;
		System.out.println("Informe o código da disciplina...:");
		int disciplinaId = (Integer.parseInt(teclado.readLine()));
		do {
			if (disciplinaId == discTurmaProfessor.get(disciplinaId)) {
				disciplinaOk = true;
			} else {
				System.out.println("Disciplina não corresponde...:");
				System.out.println("Informe outra disciplina.....:");
				disciplinaId = (Integer.parseInt(teclado.readLine()));
			}
		} while (!disciplinaOk);
		return disciplinaId;
	}

	public static List<Nota> lancaNotasTurma(int turmaId, Map<Integer, Aluno> alunosTurma,
			Map<Integer, Integer> discTurmaProfessor, int bimestreId) throws IOException, BDException {
		List<Nota> notas = new ArrayList<Nota>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Lançamento de Notas     ««|");
		System.out.println("----------------------------------");
		boolean disciplinaOk = false;
		System.out.println("Informe o código da disciplina...:");
		int disciplinaId = (Integer.parseInt(teclado.readLine()));
		do {
			if (disciplinaId == discTurmaProfessor.get(disciplinaId)) {
				disciplinaOk = true;
			} else {
				System.out.println("Disciplina não corresponde...:");
				System.out.println("Informe outra disciplina.....:");
				disciplinaId = (Integer.parseInt(teclado.readLine()));
			}
		} while (!disciplinaOk);

		int nrNota = 0;
		while (nrNota < 2) {
			nrNota++;
			for (Aluno al : alunosTurma.values()) {
				System.out.println("Aluno " + al.getNome() + ":");
				System.out.println("Informe a nota " + nrNota + " ..............:");
				float nota = Float.parseFloat(teclado.readLine());
				notas.add(new Nota(nrNota, al.getId(), disciplinaId, bimestreId, nota));
			}
		}

		System.out.println("Lançamento de notas para este aluno foi realizado com sucesso!");
		return notas;
	}

	public static List<Frequencia> lancaFrequenciaTurma(Horario horario, Map<Integer, Aluno> alunosTurma, int bimestreId) throws IOException, BDException {
		List<Frequencia> frequencias = new ArrayList<Frequencia>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»  Lançamento de Frequência   ««|");
		System.out.println("----------------------------------");
		for (Aluno al : alunosTurma.values()) {
			System.out.println("Aluno " + al.getNome() + ":");
			System.out.println("Informe a frequência(S/N).......:");
			boolean presente = Character.toUpperCase(teclado.readLine().charAt(0)) == 'S';
			frequencias.add(new Frequencia(horario.getHorarioId(), al.getId(), bimestreId, new Date(), presente));
		}

		System.out.println("Lançamento de frequencias para esta turma foi realizada com sucesso!");
		return frequencias;
	}

}
