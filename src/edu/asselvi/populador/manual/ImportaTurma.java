
package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.TurmaDAO;
import edu.asselvi.model.Turma;

public class ImportaTurma {
    public static void ImportacaoTurma(String separador){        
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\turma.txt");
        List<Turma> turmas = new ArrayList<Turma>();
        Iterator<String> var6 = dados.iterator();
      

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Turma turma = new Turma(Integer.parseInt(valores[0]), 
            						   Integer.parseInt(valores[1]), 
            						   valores[2],
            						   Integer.parseInt(valores[3]), 
            						   Integer.parseInt(valores[4]));
            turmas.add(turma);
        }	

        TurmaDAO turmaDAO = new TurmaDAO();

        try {
        	turmaDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	turmaDAO.insereVariosTrn(turmas);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

    }
}
