
package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.NotaDAO;
import edu.asselvi.model.Nota;

public class ImportaNota {
  
    public static void ImportacaoNota() throws IOException, NumberFormatException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\nota.txt");
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        List<Nota> notas = new ArrayList<Nota>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Nota nota = new Nota(Integer.parseInt(valores[0]), 
            					 Integer.parseInt(valores[1]), 
            					 Integer.parseInt(valores[2]),
            					 Integer.parseInt(valores[3]), 
            					 Float.parseFloat(valores[4]), 
            					 Integer.parseInt(valores[5]));
            notas.add(nota);
        }	

        NotaDAO notaDAO = new NotaDAO();

        try {
        	notaDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	notaDAO.insereVariosTrn(notas);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

        System.out.println("Encerrado");
    }
}
