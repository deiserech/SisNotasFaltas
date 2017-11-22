package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.SerieDAO;
import edu.asselvi.model.Serie;

public class ExportaSerie {
   

    public static void ExportacaoSerie(String separador ) throws BDException {
        SerieDAO serieDAO = new SerieDAO();
        List<Serie> series = serieDAO.consulta();
        List<String> seriesExp = new ArrayList<String>();
        Iterator<Serie> var7 = series.iterator();

        while(var7.hasNext()) {
        	Serie serie = (Serie)var7.next();
        	seriesExp.add(serie.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\serie.txt", seriesExp, false);
    }
}
