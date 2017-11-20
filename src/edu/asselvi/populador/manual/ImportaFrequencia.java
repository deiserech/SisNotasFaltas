
package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public ImportaFrequencia() {
    }
    
    
  
    public static void main(String[] args) throws IOException, NumberFormatException, ParseException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\nota.txt");
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        List<Frequencia> frequencias = new ArrayList();
        Iterator var6 = dados.iterator();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

        System.out.println("Encerrado");
    }
}
