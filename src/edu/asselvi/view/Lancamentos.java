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
import edu.asselvi.model.Frequencia;
import edu.asselvi.model.Horario;
import edu.asselvi.model.Nota;
import edu.asselvi.model.Pessoa;

public class Lancamentos {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	static Calendar calendar = new GregorianCalendar();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static int BuscaTurma() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»          Lançamentos       ««|");
		System.out.println("----------------------------------");

		System.out.println("Informe o código da turma........:");
		int idTurma = FuncoesGenericas.lerCampoInt();
		return idTurma;
	}

	public static int BuscaDisciplina(List<Integer> disciplinas) {

		boolean disciplinaOk = false;
		System.out.println("Informe o código da disciplina...:");
		int disciplinaId = FuncoesGenericas.lerCampoInt();
		do {
			if (disciplinas.contains(disciplinaId)) {
				disciplinaOk = true;
			} else {
				System.out.println("Disciplina não corresponde...:");
				System.out.println("Informe outra disciplina.....:");
				disciplinaId = FuncoesGenericas.lerCampoInt();
			}
		} while (!disciplinaOk);
		return disciplinaId;
	}

	public static List<Nota> lancaNotasTurma(int turmaId, int bimestreId, int disciplinaId,
			Map<Integer, Pessoa> alunosTurma) {
		List<Nota> notas = new ArrayList<Nota>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Lançamento de Notas     ««|");
		System.out.println("----------------------------------");
		System.out.println("");

		if (bimestreId > 0) {
			for (Pessoa al : alunosTurma.values()) {
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
				System.out.println("Lançamento de notas para esta turma foi realizado com sucesso!");
			} else {
				System.out.println("Não existem alunos cadastrados para esta turma/disciplina!");
			}
		} else {
			System.out.println("Não há bimestre vigente!");
		}
		return notas;
	}

	public static List<Frequencia> lancaFrequenciaTurma(Horario horario, Map<Integer, Pessoa> alunosTurma,int bimestreId) {
		List<Frequencia> frequencias = new ArrayList<Frequencia>();

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»  Lançamento de Frequência   ««|");
		System.out.println("----------------------------------");
		System.out.println("");
		if (horario.getHorarioId() > 0) {
			if (bimestreId > 0) {
				for (Pessoa al : alunosTurma.values()) {
					System.out.println("Aluno " + al.getNome() + ":");
					System.out.println("Informe a frequência(S/N).......:");
					boolean presente = FuncoesGenericas.lerCampoChar() == 'S';
					frequencias
							.add(new Frequencia(horario.getHorarioId(), al.getId(), bimestreId, new Date(), presente));
				}

				if (alunosTurma.size() > 0) {
					System.out.println("Lançamento de frequência para esta turma foi realizado com sucesso!");
				} else {
					System.out.println("Não existem alunos cadastrados para esta turma/disciplina!");
				}
			} else {
				System.out.println("Não há bimestre vigente!");
			}
		} else {
			System.out.println("Não há há horário cadastrado para esta turma/disciplia/dia!");
		}
		return frequencias;
	}

}
