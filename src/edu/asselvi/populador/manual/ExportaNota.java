package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.NotaDAO;
import edu.asselvi.model.Nota;

public class ExportaNota {
   

    public static void ExportacaoNota() throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        NotaDAO notaDAO = new NotaDAO();
        List<Nota> notas = notaDAO.consulta();
        List<String> notasExp = new ArrayList<String>();
        Iterator<Nota> var7 = notas.iterator();

        while(var7.hasNext()) {
        	Nota nota = (Nota)var7.next();
        	notasExp.add(nota.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\nota.txt", notasExp, false);
    }
}
