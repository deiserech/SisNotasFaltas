package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.DisciplinaDAO;
import edu.asselvi.model.Disciplina;

public class ExportaDisciplina {
  

    public static void ExportacaoDisciplina(String separador) throws  BDException {
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        List<Disciplina> disciplinas = disciplinaDAO.consulta();
        List<String> disciplinasExp = new ArrayList<String>();
        Iterator<Disciplina> var7 = disciplinas.iterator();

        while(var7.hasNext()) {
        	Disciplina disciplina = (Disciplina)var7.next();
        	disciplinasExp.add(disciplina.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\disciplina.txt", disciplinasExp, false);
    }
}
