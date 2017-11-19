package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.CursoDAO;
import edu.asselvi.model.Curso;

public class ExportaCurso {
    public ExportaCurso() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.consulta();
        List<String> cursosExp = new ArrayList();
        Iterator var7 = cursos.iterator();

        while(var7.hasNext()) {
        	Curso curso = (Curso)var7.next();
        	cursosExp.add(curso.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\curso.txt", cursosExp, false);
    }
}
