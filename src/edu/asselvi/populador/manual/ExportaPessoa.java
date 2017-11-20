package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.PessoaDAO;
import edu.asselvi.model.Pessoa;

public class ExportaPessoa {
    public ExportaPessoa() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = pessoaDAO.consulta();
        List<String> pessoasExp = new ArrayList<String>();
        Iterator<Pessoa> var7 = pessoas.iterator();

        while(var7.hasNext()) {
        	Pessoa pessoa = (Pessoa)var7.next();
        	pessoasExp.add(pessoa.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\pessoa.txt", pessoasExp, false);
    }
}
