package edu.asselvi.populador.manual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.HorarioDAO;
import edu.asselvi.model.Horario;

public class ExportaHorario {
   

    public static void ExportacaoHorario(String separador) throws BDException {
        HorarioDAO horarioDAO = new HorarioDAO();
        List<Horario> horarios = horarioDAO.consulta();
        List<String> horariosExp = new ArrayList<String>();
        Iterator<Horario> var7 = horarios.iterator();

        while(var7.hasNext()) {
        	Horario horario = (Horario)var7.next();
        	horariosExp.add(horario.toStringBD(separador));
        }

        Arquivo.gravaArquivo(System.getProperty("user.dir") + "\\dados\\horario.txt", horariosExp, false);
    }
}
