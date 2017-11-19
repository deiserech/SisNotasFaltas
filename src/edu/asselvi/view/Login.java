package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import edu.asselvi.controller.FuncoesGenericas;
import edu.asselvi.model.Usuario;

public class Login {

	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	public static Usuario telaLogin(boolean erro){
		if (erro) {
			System.out.println();
			System.out.println("----Login ou senha incorretos----");
			System.out.println();
		} else {
			System.out.println("----------------------------------");
			System.out.println("|»»            Login           ««|");
			System.out.println("----------------------------------");
		}
		System.out.println("Informe o login..................: ");
		String login = FuncoesGenericas.lerCampoString();

		System.out.println("Informe a senha..................: ");
		String senha = FuncoesGenericas.lerCampoString();
		return new Usuario(0, login, senha);
	}

}
