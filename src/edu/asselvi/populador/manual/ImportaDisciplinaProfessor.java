
package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.DisciplinaProfessorDAO;
import edu.asselvi.model.DisciplinaProfessor;

public class ImportaDisciplinaProfessor {
  
    public static void ImportacaoDisciplinaProfessor(String separador) {
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\disciplinaProfessor.txt");
        List<DisciplinaProfessor> disciplinaProfessores = new ArrayList<DisciplinaProfessor>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            DisciplinaProfessor disciplinaProfessor = new DisciplinaProfessor(Integer.parseInt(valores[0]), 
            					 Integer.parseInt(valores[1]));
            disciplinaProfessores.add(disciplinaProfessor);
        }	

        DisciplinaProfessorDAO disciplinaProfessorDAO = new DisciplinaProfessorDAO();

        try {
        	disciplinaProfessorDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	disciplinaProfessorDAO.insereVariosTrn(disciplinaProfessores);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

    }
}
