package edu.asselvi.view;

import java.io.IOException;
import java.text.ParseException;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.UsuarioDAO;

public class Sistema {
	
	private static int login() throws BDException, IOException {
		UsuarioDAO usuario = new UsuarioDAO();
		int perfil = usuario.verificaLogin(Login.telaLogin(false)); 
		while(perfil == 0) {
			perfil = usuario.verificaLogin(Login.telaLogin(true)); 
		}
		return perfil; 
	}
	
	public static void main(String[] args) throws IOException, BDException, ParseException {
		int opcao = 0;
		int perfil = login();
		switch (perfil) {
		case 1:
			
			Menu.menuCoordenador();
			break;
		case 2:
			Menu.menuSecretaria();
			break;
		case 3:
			Menu.menuProfessor();
			break;
		case 4:
			Menu.menuAluno();
			break;
		}
		while (opcao != 0) {
			switch (opcao) {
			case 1:
				int opcaoCad = Menu.menuCadastros();
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
						Cadastros.cadastraFuncionario();
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
	//		opcao = Menu.menuPrincipal();

		}
	}
}
