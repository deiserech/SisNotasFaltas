package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.model.Serie;

public class ExportaSerie {
    public ExportaSerie() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        SerieDAO serieDAO = new SerieDAO();
        List<Serie> series = serieDAO.consulta();
        List<String> seriesExp = new ArrayList<String>();
        Iterator<Serie> var7 = series.iterator();

        while(var7.hasNext()) {
        	Serie serie = (Serie)var7.next();
        	seriesExp.add(serie.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\serie.txt", seriesExp, false);
    }
}
