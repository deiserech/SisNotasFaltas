package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static int menuCoordenador() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Controle de Notas e     ��|");
		System.out.println("|��    Frequ�ncia de Alunos    ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Cadastros.............");
		System.out.println("\t2 - Matr�culas............");
		System.out.println("\t3 - Lan�amentos...........");
		System.out.println("\t4 - Consultas.............");
		System.out.println("\t5 - Relat�rios............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

	public static int menuSecretaria() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Controle de Notas e     ��|");
		System.out.println("|��    Frequ�ncia de Alunos    ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Matr�culas............");
		System.out.println("\t2 - Lan�amentos...........");
		System.out.println("\t3 - Consultas.............");
		System.out.println("\t4 - Relat�rios............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

	public static int menuProfessor() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Controle de Notas e     ��|");
		System.out.println("|��    Frequ�ncia de Alunos    ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Lan�amentos...........");
		System.out.println("\t2 - Relat�rios............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

	public static int menuAluno() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Controle de Notas e     ��|");
		System.out.println("|��    Frequ�ncia de Alunos    ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Consultas.............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

	public static int menuCadastros() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��         Cadastros          ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Escola................");
		System.out.println("\t2 - Cursos................");
		System.out.println("\t3 - Disciplinas...........");
		System.out.println("\t4 - S�ries................");
		System.out.println("\t5 - Turmas................");
		System.out.println("\t6 - Bimestres.............");
		System.out.println("\t7 - Hor�rios..............");
		System.out.println("\t8 - Funcion�rios..........");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................: ");

		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

	public static int menuMatriculas() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��         Matr�culas          ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Matricular Aluno......");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................: ");

		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

	public static int menuLancamentos() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��         Lan�amentos        ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas.................");
		System.out.println("\t2 - Frequ�ncia............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");

		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

	public static int menuConsultas() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��          Consultas         ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas.................");
		System.out.println("\t2 - Frequ�ncia............");
		System.out.println("\t3 - Situa��o..............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");

		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

	public static int menuRelatorios() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��          Relat�rios        ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas da Turma........");
		System.out.println("\t2 - Frequ�ncia da Turma...");
		System.out.println("\t3 - Situa��o da Turma.....");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");

		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			return 0;
		}
	}

}
