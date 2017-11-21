
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
import edu.asselvi.dao.BimestreDAO;
import edu.asselvi.model.Bimestre;

public class ImportaBimestre {

    public static void ImportacaoBimestre() throws IOException, NumberFormatException, ParseException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\bimestre.txt");
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        List<Bimestre> bimestres = new ArrayList<Bimestre>();
        Iterator<String> var6 = dados.iterator();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Bimestre bimestre = new Bimestre(Integer.parseInt(valores[0]), 
            								 valores[1], 
            								 sdf.parse(valores[2]),
            								 sdf.parse(valores[3]), 
            								 Integer.parseInt(valores[4]));
            bimestres.add(bimestre);
        }	

        BimestreDAO bimestreDAO = new BimestreDAO();

        try {
        	bimestreDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	bimestreDAO.insereVariosTrn(bimestres);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

        System.out.println("Encerrado");
    }
}
