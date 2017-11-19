package edu.asselvi.populador.automatizado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.dao.UsuarioDAO;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Pessoa;
import edu.asselvi.model.Usuario;



public class PessoaPopDinamica {
	
	public static Date getRandomDateAluno() throws ParseException
    {
		try {
			String date="";
	        int yearBegin=1970;
	        int yearEnd=2000-yearBegin;

	      date="" + (1 + (int)(Math.random() * 12) + "-" + (1 + (int)(Math.random() * 31) + "-" + (yearBegin + (int)(Math.random() * yearEnd))));		      
	      SimpleDateFormat  formatter = new SimpleDateFormat("MM-dd-yyyy");
		  Date date2 = formatter.parse(date);
		  
	      //java.util.Date dt = new java.util.Date();
	      //java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	      //String currentTime = sdf.format(date2);
		  return date2;
		 
		} catch (ParseException e) {
			  e.printStackTrace();
			}
	        return null;
    }
	
	public static Date getRandomDateFuncionario() throws ParseException
    {
		try {
			String date="";
	        int yearBegin=2000;
	        int yearEnd=2017-yearBegin;

	      date="" + (1 + (int)(Math.random() * 12) + "-" + (1 + (int)(Math.random() * 31) + "-" + (yearBegin + (int)(Math.random() * yearEnd))));		      
	      SimpleDateFormat  formatter = new SimpleDateFormat("MM-dd-yyyy");
		  Date date2 = formatter.parse(date);
		  
	      //java.util.Date dt = new java.util.Date();
	      //java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	      //String currentTime = sdf.format(date2);
		  return date2;
		 
		} catch (ParseException e) {
			  e.printStackTrace();
			}
	        return null;
    }
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		// Criar apontador para arquivo de propriedades
		String caminho = System.getProperty("user.dir") + "/config/populador.properties";
		FileInputStream arquivo = new FileInputStream(new File(caminho));
		Properties propriedades = new Properties();
		propriedades.load(arquivo);
		arquivo.close();
		// Ler e armazenar as propriedades
		caminho = propriedades.getProperty("origemArquivos");
		String arqMas = propriedades.getProperty("nomeMas");
		String arqFem = propriedades.getProperty("nomeFem");
		String arqSobrenome = propriedades.getProperty("sobrenome");
		String arqSobrenome2 = propriedades.getProperty("sobrenome2");
		// Mostrar propriedades lidas
		System.out.println("Populando com as seguintes configurações:");
		System.out.println("\tCaminho dos populadores......: " + caminho);
		System.out.println("\tArquivo de nomes masculinos..: " + arqMas);
		System.out.println("\tArquivo de nomes femininos...: " + arqFem);
		System.out.println("\tArquivo de sobrenomes........: " + arqSobrenome);
		System.out.println("\tArquivo de 2o sobrenome......: " + arqSobrenome2);
		// Leitura dos arquivos e criação dos vetores
		String [] nomesMas = Arquivo.leArquivo(caminho + "/" + arqMas, true, "#").split("#");
		String [] nomesFem = Arquivo.leArquivo(caminho + "/" + arqFem, true, "#").split("#");
		String [] sobrenomes = Arquivo.leArquivo(caminho + "/" + arqSobrenome, true, "#").split("#");
		String [] sobrenomes2 = Arquivo.leArquivo(caminho + "/" + arqSobrenome2, true, "#").split("#");
		System.out.print("Informe código inicial.........: ");
		int codIni = Integer.parseInt(teclado.readLine());
		System.out.print("Informe código final...........: ");
		int codFim = Integer.parseInt(teclado.readLine());
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (int i = codIni; i < codFim; i++) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(i);
			
			Usuario usuario = new Usuario();
			usuario.setUsuarioId(i);
			usuario.setLogin("user" + i);
			Random sorteioSenha = new Random();
			int senhaAleatoria = sorteioSenha.nextInt(100000000-1000000) + 1000000;
			String senha = senhaAleatoria + "";
			usuario.setSenha(senha);
			
			Random sorteioPerfil = new Random();
			int perfil = sorteioPerfil.nextInt(5-1) + 1;			
			pessoa.setPerfil(perfil);
			
			String segundoNome = (int) (Math.random() * 2) == 0  ? " " + sobrenomes2[(int) (Math.random() * sobrenomes2.length)] : "";
			String sobrenome = " " + sobrenomes[(int) (Math.random() * sobrenomes.length)] + segundoNome;
			
			if((int) (Math.random() * 2) == 0) {
				pessoa.setSexo(ESexo.M);;
				pessoa.setNome(nomesMas[(int) (Math.random() * nomesMas.length)] + sobrenome);
			} else {
				pessoa.setSexo(ESexo.F);
				pessoa.setNome(nomesFem[(int) (Math.random() * nomesFem.length)] + sobrenome);
			}
			
			Random sorteioCPF = new Random();
			int CPFAleatorio = sorteioCPF.nextInt(100000000-1000000) + 1000000;
			String cpf = CPFAleatorio + "";
			pessoa.setCpf(cpf);
			
			int perfilUsuario = pessoa.getPerfil();
			if(perfilUsuario == 4) {
				pessoa.setDataNascimento(getRandomDateAluno()); 
			} else {
				pessoa.setDataNascimento(getRandomDateFuncionario());
			}			
			
			pessoas.add(pessoa);
			usuarios.add(usuario); 
		}
		PessoaDAO pessoaDAO = new PessoaDAO();
		try {
			pessoaDAO.criaTabela();
		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
		try {
			pessoaDAO.insereTrn(pessoas);
		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try {
			usuarioDAO.criaTabela();
		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
		try {
			usuarioDAO.insereTrn(usuarios);
		} catch (BDException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Terminado");
	}
}
