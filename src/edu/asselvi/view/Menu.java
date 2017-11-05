package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	// Menus
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static int menuPrincipal() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Controle de Notas e     ��|");
		System.out.println("|��    Frequ�ncia de Alunos    ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Cadastros.............");
		System.out.println("\t2 - Lan�amentos...........");
		System.out.println("\t3 - Consultas.............");
		System.out.println("\t4 - Relat�rios............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		try {
			return Integer.parseInt(teclado.readLine());
		}catch(NumberFormatException | IOException e){
			return 0;
		}
		
	}

	public static int menuCadastros() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��         Cadastros          ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Cursos................");
		System.out.println("\t2 - Disciplinas...........");
		System.out.println("\t3 - S�ries................");
		System.out.println("\t4 - Turmas................");
		System.out.println("\t5 - Professores...........");
		System.out.println("\t6 - Hor�rios..............");
		System.out.println("\t7 - Alunos................");
		System.out.println("\t8 - Bimestres.............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................: ");

		try {
			return Integer.parseInt(teclado.readLine());
		}catch(NumberFormatException | IOException e){
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
		}catch(NumberFormatException | IOException e){
			return 0;
		}
	}

	public static int menuConsultas() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��          Consultas         ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas do Aluno........");
		System.out.println("\t2 - Frequ�ncia do Aluno...");
		System.out.println("\t3 - Situa��o do Aluno.....");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");

		try {
			return Integer.parseInt(teclado.readLine());
		}catch(NumberFormatException | IOException e){
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
		}catch(NumberFormatException | IOException e){
			return 0;
		}
	}


}
