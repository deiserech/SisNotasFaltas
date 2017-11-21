package edu.asselvi.view;

import edu.asselvi.controller.FuncoesGenericas;

public class Instalador {
	public static void instalaSistema() {
		
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println("|»»      	Instalação     	««|");
		System.out.println("----------------------------------");
		System.out.println("");
		
		System.out.println("Para acesso ao banco é necessário configurar o arquivo de parâmetros em:");
		System.out.println("user.dir");
		System.out.println("Certifique-se que as configuções estejam corretas....");
		System.out.println();
		System.out.println("Deseja continuar(S/N)");
		char option = FuncoesGenericas.lerCampoChar();
	}
}
