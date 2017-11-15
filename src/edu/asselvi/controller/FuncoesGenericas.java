package edu.asselvi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.BimestreDAO;
import edu.asselvi.model.Bimestre;

public class FuncoesGenericas {
	static Calendar calendar = new GregorianCalendar();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static int buscaBimestre() throws BDException {
		BimestreDAO bimestre = new BimestreDAO();
		List<Bimestre> bimestres = new ArrayList<Bimestre>();
		Date data = calendar.getTime();
		bimestres = bimestre.consulta();
		for (Bimestre bim : bimestres) {
			if ((data.compareTo(bim.getDataInicio()) == 1) 
				&& (bim.getDataFim().compareTo(data) == 1)) {
				return bim.getBimestreId();
			}
		}
		return 0;
	}
}
