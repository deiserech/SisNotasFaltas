package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.DisciplinaProfessorDAO;
import edu.asselvi.model.DisciplinaProfessor;

public class ExportaDisciplinaProfessor {
 

    public static void ExportacaoDisciplinaProfessor(String separador) throws  BDException {
        DisciplinaProfessorDAO disciplinaProfessorDAO = new DisciplinaProfessorDAO();
        List<DisciplinaProfessor> disciplinaProfessores = disciplinaProfessorDAO.consulta();
        List<String> disciplinaProfessoresExp = new ArrayList<String>();
        Iterator<DisciplinaProfessor> var7 = disciplinaProfessores.iterator();

        while(var7.hasNext()) {
        	DisciplinaProfessor disciplinaProfessor = (DisciplinaProfessor)var7.next();
        	disciplinaProfessoresExp.add(disciplinaProfessor.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\disciplinaProfessor.txt", disciplinaProfessoresExp, false);
    }
}
