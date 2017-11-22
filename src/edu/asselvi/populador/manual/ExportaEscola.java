package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.EscolaDAO;
import edu.asselvi.model.Escola;

public class ExportaEscola {
    

    public static void ExportacaoEscola(String separador) throws BDException {
        EscolaDAO escolaDAO = new EscolaDAO();
        List<Escola> escolas = escolaDAO.consulta();
        List<String> escolasExp = new ArrayList<String>();
        Iterator<Escola> var7 = escolas.iterator();

        while(var7.hasNext()) {
        	Escola escola = (Escola)var7.next();
        	escolasExp.add(escola.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\escola.txt", escolasExp, false);
    }
}
