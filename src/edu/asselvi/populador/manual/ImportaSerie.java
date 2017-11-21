
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
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.model.Serie;

public class ImportaSerie {
    public static void ImportacaoSerie() throws IOException, NumberFormatException {        
    	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\serie.txt");
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        List<Serie> series = new ArrayList<Serie>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Serie serie = new Serie(Integer.parseInt(valores[0]), 
            						   Integer.parseInt(valores[1]), 
            						   valores[3], 
            						   Integer.parseInt(valores[4]), 
            						   Integer.parseInt(valores[5]));
            series.add(serie);
        }	

        SerieDAO serieDAO = new SerieDAO();

        try {
        	serieDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	serieDAO.insereVariosTrn(series);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

        System.out.println("Encerrado");
    }
}
