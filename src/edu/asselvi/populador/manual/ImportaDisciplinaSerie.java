
package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.DisciplinaSerieDAO;
import edu.asselvi.model.DisciplinaSerie;

public class ImportaDisciplinaSerie {
    public static void ImportacaoDisciplinaSerie() throws IOException, NumberFormatException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\disciplinaSerie.txt");
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        List<DisciplinaSerie> disciplinaSeries = new ArrayList<DisciplinaSerie>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            DisciplinaSerie disciplinaSerie = new DisciplinaSerie(Integer.parseInt(valores[0]), 
            					 Integer.parseInt(valores[1]));
            disciplinaSeries.add(disciplinaSerie);
        }	

        DisciplinaSerieDAO disciplinaSerieDAO = new DisciplinaSerieDAO();

        try {
        	disciplinaSerieDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	disciplinaSerieDAO.insereVariosTrn(disciplinaSeries);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

        System.out.println("Encerrado");
    }
}
