package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.DisciplinaSerieDAO;
import edu.asselvi.model.DisciplinaSerie;

public class ExportaDisciplinaSerie {
    

    public static void ExportacaoDisciplinaSerie(String separador) throws  BDException {
        DisciplinaSerieDAO disciplinaSerieDAO = new DisciplinaSerieDAO();
        List<DisciplinaSerie> disciplinaSeries = disciplinaSerieDAO.consulta();
        List<String> disciplinaSeriesExp = new ArrayList<String>();
        Iterator<DisciplinaSerie> var7 = disciplinaSeries.iterator();

        while(var7.hasNext()) {
        	DisciplinaSerie disciplinaSerie = (DisciplinaSerie)var7.next();
        	disciplinaSeriesExp.add(disciplinaSerie.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\disciplinaSerie.txt", disciplinaSeriesExp, false);
    }
}
