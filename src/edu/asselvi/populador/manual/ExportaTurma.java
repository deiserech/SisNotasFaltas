package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.TurmaDAO;
import edu.asselvi.model.Turma;


public class ExportaTurma {
    public ExportaTurma() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        TurmaDAO turmaDAO = new TurmaDAO();
        List<Turma> turmas = turmaDAO.consulta();
        List<String> turmasExp = new ArrayList<String>();
        Iterator<Turma> var7 = turmas.iterator();

        while(var7.hasNext()) {
        	Turma turma = (Turma)var7.next();
        	turmasExp.add(turma.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\turma.txt", turmasExp, false); // tem que ver como por na pasta do prof - 
        //ja salvar numa pasta do projeto, pra qdo instalar ele ja ter na pasta e achar o arquivo ja com dados exportados do nosso teste
    }
}
