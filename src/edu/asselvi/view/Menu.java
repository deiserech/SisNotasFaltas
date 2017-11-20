package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import edu.asselvi.controller.FuncoesGenericas;

public class Menu {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static int menuCoordenador() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Controle de Notas e     ««|");
		System.out.println("|»»    Frequência de Alunos    ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Cadastros.............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuSecretaria() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Controle de Notas e     ««|");
		System.out.println("|»»    Frequência de Alunos    ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Matrículas............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuProfessor() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Controle de Notas e     ««|");
		System.out.println("|»»    Frequência de Alunos    ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Lançamentos...........");
		System.out.println("\t2 - Relatórios............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuAluno() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Controle de Notas e     ««|");
		System.out.println("|»»    Frequência de Alunos    ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Consultas.............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuCadastros() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»         Cadastros          ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Escola................");
		System.out.println("\t2 - Cursos................");
		System.out.println("\t3 - Disciplinas...........");
		System.out.println("\t4 - Séries................");
		System.out.println("\t5 - Turmas................");
		System.out.println("\t6 - Bimestres.............");
		System.out.println("\t7 - Horários..............");
		System.out.println("\t8 - Funcionários..........");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................: ");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuMatriculas() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»         Matrículas          ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Matricular Aluno......");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................: ");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuLancamentos() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»         Lançamentos        ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas.................");
		System.out.println("\t2 - Frequência............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuConsultas() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»          Consultas         ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas.................");
		System.out.println("\t2 - Frequência............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuRelatorios() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»          Relatórios        ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas da Turma........");
		System.out.println("\t2 - Frequência da Turma...");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

}
