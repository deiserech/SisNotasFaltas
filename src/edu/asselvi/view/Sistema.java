package edu.asselvi.view;

import java.io.IOException;

import edu.asselvi.model.Lancamentos;

public class Sistema {
	public static void main(String[] args) throws IOException {
		int opcao = Menu.menuPrincipal();
		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcaoCad = Menu.menuCadastros();
				while (opcaoCad != 0) {
					switch (opcaoCad) {
					case 1:
						Cadastros2.cadastraCurso();
						break;
					case 2:
						Cadastros2.cadastraDisciplina();
						break;
					case 3:
						Cadastros2.cadastraSerie();
						break;
					case 4:
						Cadastros2.cadastraTurma();
						break;
					case 5:
						Cadastros2.cadastraProfessor();
						break;
					case 6:
						Cadastros2.cadastraHorario();
						break;
					case 7:
						Cadastros2.cadastraAluno();
						break;
					case 8:
						Cadastros2.cadastraBimestre();
						break;
					}
					opcaoCad = Menu.menuCadastros();
				}

				break;
			case 2:
				
				int opcaoLan = Menu.menuLancamentos();
				while (opcaoLan != 0) {
					switch (opcaoLan) {
					case 1:
						Lancamentos.lancamentoNotas();
						break;
					case 2:

						break;
					}
					opcaoLan = Menu.menuLancamentos();
				}

				break;
			case 3:
				int opcaoCon = Menu.menuConsultas();
				while (opcaoCon != 0) {
					switch (opcaoCon) {
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					}
					opcaoCon = Menu.menuConsultas();
				}

				break;
			case 4:
				int opcaoRel = Menu.menuRelatorios();
				while (opcaoRel != 0) {
					switch (opcaoRel) {
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					}
					opcaoRel = Menu.menuRelatorios();
				}

				break;
//			default: colocar na view
//				System.out.println("Opção Inválida!");
//				break;
			}
			opcao = Menu.menuPrincipal();

		}
	}
}
