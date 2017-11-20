
package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.DisciplinaDAO;
import edu.asselvi.model.Disciplina;

public class ImportaDisciplina {
    public ImportaDisciplina() {
    }
    
    
  
    public static void main(String[] args) throws IOException, NumberFormatException, ParseException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\disciplina.txt");
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        List<Disciplina> disciplinas = new ArrayList();
        Iterator var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Disciplina disciplina = new Disciplina(Integer.parseInt(valores[0]), 
            									   valores[1]);
            disciplinas.add(disciplina);
        }	

        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

        try {
        	disciplinaDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	disciplinaDAO.insereVariosTrn(disciplinas);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

        System.out.println("Encerrado");
    }
}
