package edu.asselvi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import edu.asselvi.bancodados.BDException;
import edu.asselvi.dao.BimestreDAO;
import edu.asselvi.enumerador.EErrosIO;
import edu.asselvi.enumerador.ESexo;
import edu.asselvi.model.Bimestre;

public class FuncoesGenericas {
	static Calendar calendar = new GregorianCalendar();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	
	public static int buscaBimestre() throws BDException, ParseException {
		BimestreDAO bimestre = new BimestreDAO();
		List<Bimestre> bimestres = new ArrayList<Bimestre>();
		Date data = calendar.getTime();
		bimestres = bimestre.consulta();
		for (Bimestre bim : bimestres) {
			if ((data.compareTo(bim.getDataInicio()) >= 0 ) 
				&& (bim.getDataFim().compareTo(data) >= 0)) {
				return bim.getBimestreId();
			}
		}
		return 0;
	}
	
	public static int buscaDiaSemana() {
		 return calendar.get(Calendar.DAY_OF_WEEK);		
	}
	
	public static int lerCampoInt() {
		try {
			return Integer.parseInt(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println(EErrosIO.INSERE_NUMERO.getMensagem());
			return 0;
		}
	}

	public static float lerCampoFloat() {
		try {
			return Float.parseFloat(teclado.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println(EErrosIO.INSERE_NUMERO.getMensagem());
			return 0;
		}
	}

	public static String lerCampoString() {
		try {
			return teclado.readLine();
		} catch (IOException e) {
			System.out.println(EErrosIO.INFORMACAO_INVALIDA.getMensagem());
			return "";
		}
	}

	public static char lerCampoChar() {
		try {
			return Character.toUpperCase((teclado.readLine().charAt(0)));
		} catch (IOException e) {
			System.out.println(EErrosIO.INFORMACAO_INVALIDA.getMensagem());
			return ' ';
		}
	}
	
	public static Date lerData() {
		sdf.setLenient(false); 
		try {
			String data = teclado.readLine();
			return sdf.parse(data);
		} catch (ParseException | IOException e) {
			System.out.println(EErrosIO.DATA_INVALIDO.getMensagem());
		}
		return null;
	}
	
	public static ESexo lerSexo() {
		try {
			return ESexo.valueOf(teclado.readLine());
		} catch (IllegalArgumentException | IOException e) {
			System.out.println(EErrosIO.SEXO_INVALIDO.getMensagem());
		}
		return null;		
	}
}

