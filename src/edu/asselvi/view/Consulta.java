package edu.asselvi.view;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import edu.asselvi.model.Frequencia;
import edu.asselvi.model.Nota;

public class Consulta {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static DecimalFormat df = new DecimalFormat("#0.00"); 

	
	public static void consultaNota(List<Nota> notas, Map<Integer, String> disciplinas) {
		
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»      Consulta de Notas     ««|");
		System.out.println("----------------------------------");
		System.out.println("");

		for(Nota nota : notas){
			System.out.println(
					"Bimestre: " + nota.getBimestreId() 
					+ "\tDisciplina: " + disciplinas.get(nota.getDisciplinaId())
					+ "\tNota: " + (df.format(nota.getNota())));
		}
	}

	public static void consultaFrequencia(List<Frequencia> frequencias) {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»   Consulta de Frequência   ««|");
		System.out.println("----------------------------------");
		System.out.println("");

		for(Frequencia frequencia : frequencias){
			System.out.println(
					"Bimestre: " + frequencia.getBimestreId() 
					+ "\tData: " + sdf.format(frequencia.getDataAula())
					+ "\tPresença: " + (frequencia.isPresente() ? "Presente" : "Ausente"));
		}
		
	}

	public static void consultaSituacao(int alunoId) {
		
	}
	
}
