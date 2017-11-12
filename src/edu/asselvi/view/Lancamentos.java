package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.asselvi.model.Nota;

public class Lancamentos {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static void lancamentoNotas() throws IOException {
		char novo = 'S';
		char novaNota = 'S';
		int cont = 1;
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Lançamento de Notas     ««|");
		System.out.println("----------------------------------");
		while (novo == 'S') {
			System.out.println("Informe o código do aluno........:");
			int alunoId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o código da disciplina...:");
			int disciplinaId = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe o número do bimestre.....:");
			int nrBimestre = (Integer.parseInt(teclado.readLine()));
			System.out.println("Informe a nota 1.................: ");
			float nrNota = (Integer.parseInt(teclado.readLine()));
			//Lançar notas dentro de Bimestre
			Nota nota = new Nota(cont, alunoId, disciplinaId, nrBimestre, nrNota);

			while ((novaNota == 'S') && (cont < 4)) {
				System.out.println("Deseja inserir nova nota para");
				System.out.println("este aluno/disciplina/bimestre?(S/N).: ");
				novaNota = Character.toUpperCase((teclado.readLine().charAt(0)));
				cont++;
				System.out.println("Informe a nota " + cont + ".................: ");
				nota.setNota(Integer.parseInt(teclado.readLine()));
			}
			if (cont == 4) {
				System.out
						.println("Lançamento de notas para este aluno/disciplina/bimestre foi realizado com sucesso!");
			}
			System.out.println();
			System.out.println("Deseja inserir nova nota?(S/N).: ");
			novo = Character.toUpperCase((teclado.readLine().charAt(0)));
		}
	}
}
