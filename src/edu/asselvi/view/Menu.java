package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import edu.asselvi.controller.FuncoesGenericas;

public class Menu {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static int menuInicial() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Controle de Notas e     ��|");
		System.out.println("|��    Frequ�ncia de Alunos    ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Instalador............");
		System.out.println("\t2 - Di�rio de classe......");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	
	public static int menuCoordenador() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Controle de Notas e     ��|");
		System.out.println("|��    Frequ�ncia de Alunos    ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Cadastros.............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuSecretaria() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��    Controle de Notas e     ��|");
		System.out.println("|��    Frequ�ncia de Alunos    ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Matr�culas............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
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
		return FuncoesGenericas.lerCampoInt();
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
		return FuncoesGenericas.lerCampoInt();
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
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuMatriculas() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��         Matr�culas          ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Matricular Aluno......");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................: ");
		return FuncoesGenericas.lerCampoInt();
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
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuConsultas() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��          Consultas         ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas.................");
		System.out.println("\t2 - Frequ�ncia............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuRelatorios() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��          Relat�rios        ��|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas da Turma........");
		System.out.println("\t2 - Frequ�ncia da Turma...");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static int menuInstalacao() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��         Instala��o         ��|");
		System.out.println("----------------------------------");
		System.out.println();
		System.out.println("*************************************************************");
		System.out.println();
		System.out.println("Para acesso ao banco de dados � necess�rio ");
		System.out.println("configurar o arquivo de par�metros em:");
		System.out.println();
		System.out.println(System.getProperty("user.dir") + "\\config\\populador.properties");
		System.out.println();
		System.out.println("Certifique-se que as configura��es est�o corretas....");
		System.out.println();
		System.out.println("*************************************************************");
		System.out.println();
		System.out.println("\t1 - Criar database..........");
		System.out.println("\t2 - Importar base de dados..");
		System.out.println("\t3 - Emportar base de dados..");
		System.out.println("\t0 - Sair....................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	public static void menuImportacao() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��         Importa��o         ��|");
		System.out.println("----------------------------------");
		System.out.println("Importando informa��es do diret�rio:");
		System.out.println(System.getProperty("user.dir") + "/dados/");
	}
	
	public static void menuExportacao() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��         Exporta��o         ��|");
		System.out.println("----------------------------------");
		System.out.println("Exportando informa��es......");
	}
	
	public static void mensagens(int msg) {
		switch (msg) {
		case 1:
			System.out.println("Importa��o de dados finalizada!!!");
			break;
		case 2:
			System.out.println("Op��o Inv�lida!!!");
			break;
		case 3:
			System.out.println("Sistema encerrado!");
			break;
		case 4:
			System.out.println("Exporta��o de dados finalizada!!!");
			System.out.println("Verifique no diret�rio:");
			System.out.println(System.getProperty("user.dir") + "/dados/");
			break;
		case 5:
			System.out.println("Database criado com sucesso!");
			break;
		}
		
	}
	
	public static void mensagem(String msg) {
			System.out.println(msg);		
	}
	

}
