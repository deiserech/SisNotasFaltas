
package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.HorarioDAO;
import edu.asselvi.model.Horario;

public class ImportaHorario {
  
    public static void ImportacaoHorario(String separador){
    	List<String> dados = Arquivo.leArquivo(System.getProperty("user.dir") + "\\dados\\horario.txt");
        List<Horario> horarios = new ArrayList<Horario>();
        Iterator<String> var6 = dados.iterator();

        while(var6.hasNext()) {
            String linha = (String)var6.next();
            String[] valores = linha.split(separador);
            Horario horario = new Horario(Integer.parseInt(valores[0]), 
            					 Integer.parseInt(valores[1]), 
            					 Integer.parseInt(valores[2]),
            					 Integer.parseInt(valores[3]), 
            					 valores[4]);
            horarios.add(horario);
        }	

        HorarioDAO horarioDAO = new HorarioDAO();

        try {
        	horarioDAO.criaTabela();
        } catch (BDException var10) {
            System.out.println(var10.getMessage());
        }

        try {
        	horarioDAO.insereVariosTrn(horarios);
        } catch (BDException var9) {
            System.out.println(var9.getMessage());
        }

    }
}
