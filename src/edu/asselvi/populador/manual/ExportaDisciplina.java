package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.DisciplinaDAO;
import edu.asselvi.model.Disciplina;

public class ExportaDisciplina {
    public ExportaDisciplina() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        List<Disciplina> disciplinas = disciplinaDAO.consulta();
        List<String> disciplinasExp = new ArrayList<String>();
        Iterator<Disciplina> var7 = disciplinas.iterator();

        while(var7.hasNext()) {
        	Disciplina disciplina = (Disciplina)var7.next();
        	disciplinasExp.add(disciplina.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\disciplina.txt", disciplinasExp, false);
    }
}
