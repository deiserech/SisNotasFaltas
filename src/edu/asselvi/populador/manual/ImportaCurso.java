
package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.CursoDAO;
import edu.asselvi.model.Curso;

public class ImportaCurso {
  
    public static void ImportacaoCurso(String separador){
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\curso.txt");
        List<Curso> cursos = new ArrayList<Curso>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Curso curso = new Curso(Integer.parseInt(valores[0]), 
            					 	Integer.parseInt(valores[1]), 
            					 	Integer.parseInt(valores[2]),
            					 	valores[3]);
            cursos.add(curso);
        }	

        CursoDAO cursoDAO = new CursoDAO();

        try {
        	cursoDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	cursoDAO.insereVariosTrn(cursos);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

    }
}
