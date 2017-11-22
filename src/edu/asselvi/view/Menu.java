package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import edu.asselvi.controller.FuncoesGenericas;

public class Menu {
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static int menuInicial() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Controle de Notas e     ««|");
		System.out.println("|»»    Frequência de Alunos    ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Instalador............");
		System.out.println("\t2 - Diário de classe......");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
		return FuncoesGenericas.lerCampoInt();
	}

	
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

	public static int menuInstalacao() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»         Instalação         ««|");
		System.out.println("----------------------------------");
		System.out.println();
		System.out.println("*************************************************************");
		System.out.println();
		System.out.println("Para acesso ao banco de dados é necessário ");
		System.out.println("configurar o arquivo de parâmetros em:");
		System.out.println();
		System.out.println(System.getProperty("user.dir") + "\\config\\populador.properties");
		System.out.println();
		System.out.println("Certifique-se que as configurações estão corretas....");
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
		System.out.println("|»»         Importação         ««|");
		System.out.println("----------------------------------");
		System.out.println("Importando informações do diretório:");
		System.out.println(System.getProperty("user.dir") + "/dados/");
	}
	
	public static void menuExportacao() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»         Exportação         ««|");
		System.out.println("----------------------------------");
		System.out.println("Exportando informações......");
	}
	
	public static void mensagens(int msg) {
		switch (msg) {
		case 1:
			System.out.println("Importação de dados finalizada!!!");
			break;
		case 2:
			System.out.println("Opção Inválida!!!");
			break;
		case 3:
			System.out.println("Sistema encerrado!");
			break;
		case 4:
			System.out.println("Exportação de dados finalizada!!!");
			System.out.println("Verifique no diretório:");
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
