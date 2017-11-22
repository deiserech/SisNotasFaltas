package edu.asselvi.populador.manual;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.CursoDAO;
import edu.asselvi.model.Curso;

public class ExportaCurso {
  
    public static void ExportacaoCurso(String separador) throws BDException {
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.consulta();
        List<String> cursosExp = new ArrayList<String>();
        Iterator<Curso> var7 = cursos.iterator();

        while(var7.hasNext()) {
        	Curso curso = (Curso)var7.next();
        	cursosExp.add(curso.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\curso.txt", cursosExp, false);
    }
}
