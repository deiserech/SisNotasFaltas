package edu.asselvi.populador.manual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asselvi.arquivo.Arquivo;
import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.BimestreDAO;
import edu.asselvi.model.Bimestre;

public class ExportaBimestre {
    public ExportaBimestre() {
    }

    public static void main(String[] args) throws IOException, BDException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entre com o separador...: ");
        String separador = teclado.readLine();
        BimestreDAO bimestreDAO = new BimestreDAO();
        List<Bimestre> bimestres = bimestreDAO.consulta();
        List<String> bimestresExp = new ArrayList();
        Iterator var7 = bimestres.iterator();

        while(var7.hasNext()) {
        	Bimestre bimestre = (Bimestre)var7.next();
        	bimestresExp.add(bimestre.toStringBD(separador));
        }

        Arquivo.gravaArquivo("C:\\Users\\Lorena\\Workspace\\bimestre.txt", bimestresExp, false);
    }
}
