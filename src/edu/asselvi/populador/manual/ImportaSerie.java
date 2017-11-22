
package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.model.Serie;

public class ImportaSerie {
    public static void ImportacaoSerie(String separador) {        
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\serie.txt");
        List<Serie> series = new ArrayList<Serie>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Serie serie = new Serie(Integer.parseInt(valores[0]), 
            						   Integer.parseInt(valores[1]), 
            						   valores[2], 
            						   Integer.parseInt(valores[3]), 
            						   Integer.parseInt(valores[4]));
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

    }
}
