package edu.asselvi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.asselvi.model.Usuario;

public class Login {

	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	
	public static Usuario telaLogin() throws IOException {
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»            Login            ««|");
		System.out.println("----------------------------------");
		System.out.println("Informe o login..................: ");
		String login = (teclado.readLine());
		System.out.println("Informe a senha..................: ");
		String senha = (teclado.readLine());
		return new Usuario(0, login, senha,0);
		
	}

}
