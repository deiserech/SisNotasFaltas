package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.NotaDAO;
import edu.asselvi.model.Nota;

public class ExportaNota {
   

    public static void ExportacaoNota(String separador ) throws BDException {
        NotaDAO notaDAO = new NotaDAO();
        List<Nota> notas = notaDAO.consulta();
        List<String> notasExp = new ArrayList<String>();
        Iterator<Nota> var7 = notas.iterator();

        while(var7.hasNext()) {
        	Nota nota = (Nota)var7.next();
        	notasExp.add(nota.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\nota.txt", notasExp, false);
    }
}
