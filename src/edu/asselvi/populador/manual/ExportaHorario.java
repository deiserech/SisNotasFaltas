package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.HorarioDAO;
import edu.asselvi.model.Escola;
import edu.asselvi.model.Horario;

public class ExportaHorario {
    public ExportaHorario() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        HorarioDAO horarioDAO = new HorarioDAO();
        List<Horario> horarios = horarioDAO.consulta();
        List<String> horariosExp = new ArrayList();
        Iterator var7 = horarios.iterator();

        while(var7.hasNext()) {
        	Horario horario = (Horario)var7.next();
        	horariosExp.add(horario.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\horario.txt", horariosExp, false);
    }
}
