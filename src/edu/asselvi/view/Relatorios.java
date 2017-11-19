package edu.asselvi.view;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import edu.asselvi.model.Disciplina;
import edu.asselvi.model.Frequencia;
import edu.asselvi.model.Nota;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Turma;

public class Relatorios {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static DecimalFormat df = new DecimalFormat("#0.00"); 

	public static void relatorioNotas(Turma turma,Map<Integer, Pessoa> alunos, Map<Integer, Disciplina> disciplinas, List<Nota> notas ) {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Relatório de Notas     ««|");
		System.out.println("----------------------------------");
		System.out.println("");
		
		System.out.println("Turma: " + turma.getDescricao()); 
		System.out.println("");
		
		if (notas.size() > 0) {
			for (Nota nota : notas) {
				System.out.println("Bimestre: " + nota.getBimestreId()
									+ "\tAluno: " + alunos.get(nota.getAlunoId()).getNome()
									+"\t\tDisciplina: " + disciplinas.get(nota.getDisciplinaId()).getDescricao()
									+ "\tNota: " + (df.format(nota.getNota())));
			}
		} else {
			System.out.println("Não existem alunos cadastrados para esta turma!");
		}

	}

	public static void relatorioFrequencia(Turma turma,Map<Integer, Pessoa> alunos, Map<Integer, Disciplina> disciplinas, List<Frequencia> frequencias ) {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»  Relatório de Frequência   ««|");
		System.out.println("----------------------------------");
		System.out.println("");
		
		System.out.println("Turma: " + turma.getDescricao()); 
		System.out.println("");
		
		if (frequencias.size() > 0) {
			for (Frequencia freq : frequencias) {
				System.out.println("Bimestre: " + freq.getBimestreId()
									+ "\tAluno: " + alunos.get(freq.getAlunoId()).getNome()
									+ "\t\tData: " + sdf.format(freq.getDataAula())
									+ "\t\tPresença: " + (freq.isPresente() ? "Presente" : "Ausente"));
			}
		} else {
			System.out.println("Não existem alunos cadastrados para esta turma!");
		}

	}

}
