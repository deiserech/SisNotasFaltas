package edu.asselvi.programa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sistema {
	// =======================================================================================================
	// Menus
	private static void menuPrincipal() {

		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»    Controle de Notas e     ««|");
		System.out.println("|»»    Frequência de Alunos    ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Cadastros.............");
		System.out.println("\t2 - Lançamentos...........");
		System.out.println("\t3 - Consultas.............");
		System.out.println("\t4 - Relatórios............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
	}

	private static void menuCadastros() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»         Cadastros          ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Cursos................");
		System.out.println("\t2 - Disciplinas...........");
		System.out.println("\t3 - Séries................");
		System.out.println("\t4 - Turmas................");
		System.out.println("\t5 - Professores...........");
		System.out.println("\t6 - Horários..............");
		System.out.println("\t7 - Alunos................");
		System.out.println("\t8 - Bimestres.............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................: ");
	}

	private static void menuLancamentos() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»         Lançamentos        ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas.................");
		System.out.println("\t2 - Frequência............");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
	}

	private static void menuConsultas() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»          Consultas         ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas do Aluno........");
		System.out.println("\t2 - Frequência do Aluno...");
		System.out.println("\t3 - Situação do Aluno.....");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
	}

	private static void menuRelatorios() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»          Relatórios        ««|");
		System.out.println("----------------------------------");
		System.out.println("\t1 - Notas da Turma........");
		System.out.println("\t2 - Frequência da Turma...");
		System.out.println("\t3 - Situação da Turma.....");
		System.out.println("\t0 - Sair..................");
		System.out.print("Escolha..........................:");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		menuPrincipal();

		int opcao = Integer.parseInt(teclado.readLine());

		while (opcao != 0) {
			switch (opcao) {
			case 1:
				menuCadastros();
				int opcaoCad = Integer.parseInt(teclado.readLine());
				while (opcaoCad != 0) {
					switch (opcaoCad) {
					case 1:
						Cadastros.cadastraCurso();
						break;
					case 2:
						Cadastros.cadastraDisciplina();
						break;
					case 3:
						Cadastros.cadastraSerie();
						break;
					case 4:
						Cadastros.cadastraTurma();
						break;
					case 5:
						Cadastros.cadastraProfessor();
						break;
					case 6:
						Cadastros.cadastraHorario();
						break;
					case 7:
						Cadastros.cadastraAluno();
						break;
					case 8:
						Cadastros.cadastraBimestre();
						break;
					}
					menuCadastros();
					opcaoCad = Integer.parseInt(teclado.readLine());
				}

				break;
			case 2:
				menuLancamentos();
				int opcaoLan = Integer.parseInt(teclado.readLine());
				while (opcaoLan != 0) {
					switch (opcaoLan) {
					case 1:
						Lancamentos.lancamentoNotas();
						break;
					case 2:

						break;
					}
					menuLancamentos();
					opcaoLan = Integer.parseInt(teclado.readLine());
				}

				break;
			case 3:
				menuConsultas();
				int opcaoCon = Integer.parseInt(teclado.readLine());
				while (opcaoCon != 0) {
					switch (opcaoCon) {
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					}
					menuConsultas();
					opcaoCon = Integer.parseInt(teclado.readLine());
				}

				break;
			case 4:
				menuRelatorios();
				int opcaoRel = Integer.parseInt(teclado.readLine());
				while (opcaoRel != 0) {
					switch (opcaoRel) {
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					}
					menuRelatorios();
					opcaoRel = Integer.parseInt(teclado.readLine());
				}

				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			menuPrincipal();
			opcao = Integer.parseInt(teclado.readLine());

		}
	}
}
