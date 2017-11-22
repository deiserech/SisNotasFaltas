
package edu.asselvi.populador.manual;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Pessoa;

public class ImportaPessoa {
  
    public static void ImportacaoPessoa(String separador) throws NumberFormatException, ParseException{ 
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\pessoa.txt");
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Iterator<String> var6 = dados.iterator();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Pessoa pessoa = new Pessoa(Integer.parseInt(valores[0]), 
            						   Integer.parseInt(valores[1]), 
            						   Integer.parseInt(valores[2]),
            						   valores[3], 
            						   valores[4], 
            						   sdf.parse(valores[5]),
            						   ESexo.valueOf(valores[6]));
            pessoas.add(pessoa);
        }	

        PessoaDAO pessoaDAO = new PessoaDAO();

        try {
            pessoaDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
            pessoaDAO.insereVariosTrn(pessoas);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

    }
}
