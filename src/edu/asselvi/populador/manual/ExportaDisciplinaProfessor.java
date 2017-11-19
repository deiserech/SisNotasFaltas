package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.DisciplinaProfessorDAO;
import edu.asselvi.model.DisciplinaProfessor;

public class ExportaDisciplinaProfessor {
    public ExportaDisciplinaProfessor() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        DisciplinaProfessorDAO disciplinaProfessorDAO = new DisciplinaProfessorDAO();
        List<DisciplinaProfessor> disciplinaProfessores = disciplinaProfessorDAO.consulta();
        List<String> disciplinaProfessoresExp = new ArrayList();
        Iterator var7 = disciplinaProfessores.iterator();

        while(var7.hasNext()) {
        	DisciplinaProfessor disciplinaProfessor = (DisciplinaProfessor)var7.next();
        	disciplinaProfessoresExp.add(disciplinaProfessor.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\disciplinaProfessor.txt", disciplinaProfessoresExp, false);
    }
}
