package edu.asselvi.view;

import edu.asselvi.controller.FuncoesGenericas;

public class Instalador {
	public static void instalaSistema() {
		
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|��      	Instala��o     	��|");
		System.out.println("----------------------------------");
		System.out.println("");
		
		System.out.println("Para acesso ao banco � necess�rio configurar o arquivo de par�metros em:");
		System.out.println("user.dir");
		System.out.println("Certifique-se que as configu��es estejam corretas....");
		System.out.println();
		System.out.println("Deseja continuar(S/N)");
		char option = FuncoesGenericas.lerCampoChar();
	}
}
