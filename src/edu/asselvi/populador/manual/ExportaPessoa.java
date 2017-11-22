package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.model.Pessoa;

public class ExportaPessoa {
   

    public static void ExportacaoPessoa(String separador) throws BDException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = pessoaDAO.consulta();
        List<String> pessoasExp = new ArrayList<String>();
        Iterator<Pessoa> var7 = pessoas.iterator();

        while(var7.hasNext()) {
        	Pessoa pessoa = (Pessoa)var7.next();
        	pessoasExp.add(pessoa.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\pessoa.txt", pessoasExp, false);
    }
}
