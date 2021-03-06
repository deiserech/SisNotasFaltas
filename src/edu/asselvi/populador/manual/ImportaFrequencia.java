
package edu.asselvi.populador.manual;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.FrequenciaDAO;
import edu.asselvi.model.Frequencia;

public class ImportaFrequencia {
	
    public static void ImportacaoFrequencia(String separador) throws NumberFormatException, ParseException{
    	List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\frequencia.txt");
        List<Frequencia> frequencias = new ArrayList<Frequencia>();
        Iterator<String> var6 = dados.iterator();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            
            Frequencia frequencia = new Frequencia(Integer.parseInt(valores[0]), 
            					 				   Integer.parseInt(valores[1]), 
            					 				   Integer.parseInt(valores[2]),
            					 				   sdf.parse(valores[3]), 
            					 				   Boolean.getBoolean((valores[4])));
            frequencias.add(frequencia);
        }	

        FrequenciaDAO frequenciaDAO = new FrequenciaDAO();

        try {
        	frequenciaDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	frequenciaDAO.insereVariosTrn(frequencias);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

    }
}
