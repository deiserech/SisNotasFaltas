package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.AlunoTurmaDAO;
import edu.asselvi.model.AlunoTurma;

public class ExportaAlunoTurma {
   

    public static void ExportacaoAlunoTurma() throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO();
        List<AlunoTurma> alunoTurmas = alunoTurmaDAO.consulta();
        List<String> alunoTurmasExp = new ArrayList<String>();
        Iterator<AlunoTurma> var7 = alunoTurmas.iterator();

        while(var7.hasNext()) {
        	AlunoTurma alunoTurma = (AlunoTurma)var7.next();
        	alunoTurmasExp.add(alunoTurma.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\alunoTurma.txt", alunoTurmasExp, false);
    }
}
