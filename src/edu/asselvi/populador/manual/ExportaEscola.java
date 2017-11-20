package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.EscolaDAO;
import edu.asselvi.model.Escola;

public class ExportaEscola {
    public ExportaEscola() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        EscolaDAO escolaDAO = new EscolaDAO();
        List<Escola> escolas = escolaDAO.consulta();
        List<String> escolasExp = new ArrayList<String>();
        Iterator<Escola> var7 = escolas.iterator();

        while(var7.hasNext()) {
        	Escola escola = (Escola)var7.next();
        	escolasExp.add(escola.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\escola.txt", escolasExp, false);
    }
}
