package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.FrequenciaDAO;
import edu.asselvi.model.Frequencia;

public class ExportaFrequencia {
    

    public static void ExportacaoFrequencia(String separador) throws  BDException {
        FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
        List<Frequencia> frequencias = frequenciaDAO.consulta();
        List<String> frequenciasExp = new ArrayList<String>();
        Iterator<Frequencia> var7 = frequencias.iterator();

        while(var7.hasNext()) {
        	Frequencia frequencia = (Frequencia)var7.next();
        	frequenciasExp.add(frequencia.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\frequencia.txt", frequenciasExp, false);
    }
}
