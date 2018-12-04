package br.edu.fapi.poo.SolutionMakers.operacoes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ColetorData {
	
	public static String datetime() {

		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		return timeStamp;
	}
	
	public static String dateExtense() {

		String timeStamp = new SimpleDateFormat("dd/MMM/yyyy").format(Calendar.getInstance().getTime());
		
		return timeStamp;
	}

}