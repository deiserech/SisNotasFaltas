package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import edu.asselvi.controller.FuncoesGenericas;
import edu.asselvi.model.Aluno;
import edu.asselvi.model.Disciplina;
import edu.asselvi.model.Frequencia;
import edu.asselvi.model.Horario;
import edu.asselvi.model.Nota;
import edu.asselvi.model.Turma;

public class Lancamentos {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	static Calendar calendar = new GregorianCalendar();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static int BuscaTurma(Map<Integer, Turma> turmas) {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��          Lan�amentos       ��|");
		System.out.println("----------------------------------");

		System.out.println("Informe o c�digo da turma........:");
		for(Turma tm : turmas.values()) {
			System.out.println(tm.getTurmaId() + " - " + tm.getDescricao());
		}
		int idTurma = FuncoesGenericas.lerCampoInt();
		return idTurma;
	}

	public static int BuscaDisciplina(Map<Integer, Disciplina> disciplinas) {

		boolean disciplinaOk = false;
		System.out.println("Informe o c�digo da disciplina...:");
		for(Disciplina disc : disciplinas.values()) {
			System.out.println(disc.getDisciplinaId() + " - " + disc.getDescricao());
		}
		int disciplinaId = FuncoesGenericas.lerCampoInt();
		do {
			if (disciplinas.get(disciplinaId) instanceof Disciplina) {
				disciplinaOk = true;
			} else {
				System.out.println("Disciplina n�o corresponde...:");
				System.out.println("Informe outra disciplina.....:");
				disciplinaId = FuncoesGenericas.lerCampoInt();
			}
		} while (!disciplinaOk);
		return disciplinaId;
	}

	public static List<Nota> lancaNotasTurma(int turmaId, int bimestreId, int disciplinaId,
			Map<Integer, Aluno> alunosTurma) {
		List<Nota> notas = new ArrayList<Nota>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Lan�amento de Notas     ��|");
		System.out.println("----------------------------------");
		System.out.println("");

		if (bimestreId > 0) {
			for (Aluno al : alunosTurma.values()) {
				int nrNota = 0;
				while (nrNota < 2) {
					nrNota++;
					System.out.println("Aluno " + al.getNome() + ":");
					System.out.println("Informe a nota " + nrNota + " ..............:");
					float nota = FuncoesGenericas.lerCampoFloat();
					notas.add(new Nota(0, al.getId(), disciplinaId, bimestreId, nota, nrNota));
				}
			}

			if (alunosTurma.size() > 0) {
				System.out.println("Lan�amento de notas para esta turma foi realizado com sucesso!");
			} else {
				System.out.println("N�o existem alunos cadastrados para esta turma/disciplina!");
			}
		} else {
			System.out.println("N�o h� bimestre vigente!");
		}
		return notas;
	}

	public static List<Frequencia> lancaFrequenciaTurma(Horario horario, Map<Integer, Aluno> alunosTurma,int bimestreId) {
		List<Frequencia> frequencias = new ArrayList<Frequencia>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��  Lan�amento de Frequ�ncia   ��|");
		System.out.println("----------------------------------");
		System.out.println("");
		if (horario.getHorarioId() > 0) {
			if (bimestreId > 0) {
				for (Aluno al : alunosTurma.values()) {
					System.out.println("Aluno " + al.getNome() + ":");
					System.out.println("Informe a frequ�ncia(S/N).......:");
					boolean presente = FuncoesGenericas.lerCampoChar() == 'S';
					frequencias
							.add(new Frequencia(horario.getHorarioId(), al.getId(), bimestreId, new Date(), presente));
				}

				if (alunosTurma.size() > 0) {
					System.out.println("Lan�amento de frequ�ncia para esta turma foi realizado com sucesso!");
				} else {
					System.out.println("N�o existem alunos cadastrados para esta turma/disciplina!");
				}
			} else {
				System.out.println("N�o h� bimestre vigente!");
			}
		} else {
			System.out.println("N�o h� hor�rio cadastrado para esta turma/disciplia/dia!");
		}
		return frequencias;
	}

}
