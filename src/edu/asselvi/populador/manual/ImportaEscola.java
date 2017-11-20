
package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.EscolaDAO;
import edu.asselvi.model.Escola;

public class ImportaEscola {
    public ImportaEscola() {
    }
    
    
  
    public static void main(String[] args) throws IOException, NumberFormatException, ParseException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\escola.txt");
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        List<Escola> escolas = new ArrayList<Escola>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Escola escola = new Escola(Integer.parseInt(valores[0]), 
            						   valores[1]);
            escolas.add(escola);
        }	

        EscolaDAO EscolaDAO = new EscolaDAO();

        try {
        	EscolaDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	EscolaDAO.insereVariosTrn(escolas);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

        System.out.println("Encerrado");
    }
}
