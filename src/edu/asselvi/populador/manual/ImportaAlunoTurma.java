
package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.AlunoTurmaDAO;
import edu.asselvi.model.AlunoTurma;

public class ImportaAlunoTurma {
    public static void ImportacaoAlunoTurma(String separador) {
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\alunoTurma.txt");
        List<AlunoTurma> alunoTurmas = new ArrayList<AlunoTurma>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            AlunoTurma alunoTurma = new AlunoTurma(Integer.parseInt(valores[0]), 
            					 Integer.parseInt(valores[1]));
            alunoTurmas.add(alunoTurma);
        }	

        AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO();

        try {
        	alunoTurmaDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	alunoTurmaDAO.insereVariosTrn(alunoTurmas);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

    }
}
