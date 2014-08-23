package util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Vector;

@SuppressWarnings("unchecked")
public final class UsefulMethods {

		public static String formatValueToString(double valor) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setCurrency(Currency.getInstance(new Locale("pt","BR")));
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		String n = nf.format(valor);
		return n;
	}

	public static String formatValueToString(Double valor) {
		if (valor == null) {
			return "";
		}
		return UsefulMethods.formatValueToString(valor.doubleValue());
	}

	public static String formatValueToString(String valor) {
		if ((valor == null) || (valor.trim().length() == 0)) {
			return "";
		}
		double d = Double.parseDouble(valor);
		return UsefulMethods.formatValueToString(d);
	}

	public static String formatStringToValue(String valor) {
		if ((valor == null) || (valor.trim().length() == 0)) {
			return "";
		}
		
		if ((valor.indexOf('.') >= 0) && (valor.indexOf(',') >= 0)) {
			valor = valor.substring(0, valor.indexOf('.')) +
			valor.substring(valor.indexOf('.') + 1, valor.length());
		}
		if ((valor.indexOf('.') >= 0) && (valor.indexOf(',') >= 0)) {
			valor = valor.substring(0, valor.indexOf('.')) +
			valor.substring(valor.indexOf('.') + 1, valor.length());
		}
		if ((valor.indexOf('.') >= 0) && (valor.indexOf(',') >= 0)) {
			valor = valor.substring(0, valor.indexOf('.')) +
			valor.substring(valor.indexOf('.') + 1, valor.length());
		}
		if ((valor.indexOf('.') >= 0) && (valor.indexOf(',') >= 0)) {
			valor = valor.substring(0, valor.indexOf('.')) +
			valor.substring(valor.indexOf('.') + 1, valor.length());
		}
		if ((valor.indexOf('.') >= 0) && (valor.indexOf(',') >= 0)) {
			valor = valor.substring(0, valor.indexOf('.')) +
			valor.substring(valor.indexOf('.') + 1, valor.length());
		}
		if (valor.indexOf(',') > 0) {
			valor = valor.replace(',', '.');
		}
		return valor;
	}
	
	

	public static String formatIntToPeriod(String periodo) {
		if ((periodo == null) || (periodo.trim().length() ==0) ) {
			return "";
		}
		return periodo.trim().substring(4,periodo.trim().length()) + "/" + periodo.trim().substring(0,4);
	}

	public static String formatIntToPeriod(int iPeriodo) {
		String periodo = String.valueOf(iPeriodo);
		return UsefulMethods.formatIntToPeriod(periodo);
	}

	public static String formatIntToPeriod(Integer iPeriodo) {
		if (iPeriodo == null) {
			return "";
		}
		String periodo = String.valueOf(iPeriodo.intValue());
		return UsefulMethods.formatIntToPeriod(periodo);
	}

	public static String formatPeriodToInt(String periodo) {
		if ((periodo == null) || (periodo.trim().length() ==0) ) {
			return "";
		}
		return periodo.trim().substring(3, periodo.trim().length()) + periodo.trim().substring(0, 2);
	}

	public static String dateToPeriod(String data) {
		if ((data == null) || (data.trim().length() ==0) ) {
			return "";
		}
		return UsefulMethods.formatPeriodToInt(data.trim().substring(3, data.trim().length()));
	}


	public static float parseFloat(String value) {
		if (value == null || value.trim().length() == 0) return 0.0f;
		NumberFormat nf = NumberFormat.getInstance();
		try {
			Number n = nf.parse(value);
			return n.floatValue();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0.0f;
	}

	public static long parseLong(String value) {
		if (value == null || value.trim().length() == 0) return 0;
		NumberFormat nf = NumberFormat.getInstance();
		try {
			Number n = nf.parse(value);
			return n.longValue();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0L;
	}

	public static int parseInt(String value) {
		if (value == null || value.trim().length() == 0) return 0;
		NumberFormat nf = NumberFormat.getInstance();
		try {
			Number n = nf.parse(value);
			return n.intValue();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static String decimalFormat(double s) {
		DecimalFormat f = new DecimalFormat("#,##0.00");
        return f.format(s);
	}
	
	public static String decimalFormat(String s) {
		if (s == null || s.trim().length() == 0) return "";
		DecimalFormat f = new DecimalFormat();
		f.setCurrency(Currency.getInstance(new Locale("en", "US")));
		f.setMaximumFractionDigits(2);
		f.setMinimumFractionDigits(2);
        return f.format(Double.valueOf(s));
	}
	
	public static double parseDoubleUS(String value) {
		if (value == null || value.trim().length() == 0) return 0.0;
		NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		try {
			Number n = nf.parse(value);
			return n.doubleValue();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0.0;
	}

	public static double parseDouble(String value) {
		if (value == null || value.trim().length() == 0) return 0.0;
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		try {
			Number n = nf.parse(value);
			return n.doubleValue();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0.0;
	}
	
	public static String truncaDecimais(Double value) {
		
		String formatado = String.format("%.4f", value);
		formatado = formatStringToValue(formatado);
		return formatado;
	}
	

	public static double parseDouble(Double value) {
		return UsefulMethods.parseDouble(value.toString());
	}

	public static short parseShort(String value) {
		if (value == null || value.trim().length() == 0) return 0;
		NumberFormat nf = NumberFormat.getInstance();
		try {
			Number n = nf.parse(value);
			return n.shortValue();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static byte parseByte(String value) {
		if (value == null || value.trim().length() == 0) return 0;
		NumberFormat nf = NumberFormat.getInstance();
		try {
			Number n = nf.parse(value);
			return n.byteValue();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static String today() {
		Calendar c = Calendar.getInstance();
		int daux = c.get(Calendar.DATE);
		String dia = (daux < 10 ? "0" + daux : "" + daux);
		int maux = (c.get(Calendar.MONTH) + 1);
		String mes = (maux < 10 ? "0" + maux : "" + maux);
		String ano = c.get(Calendar.YEAR) + "";
		String data = dia + "/" + mes + "/" + ano;
		return data;
	}

	public static String now() {
		Calendar c = Calendar.getInstance();
		int haux = c.get(Calendar.HOUR);
		String hora = (haux < 10 ? "0" + haux : "" + haux);
		int maux = (c.get(Calendar.MINUTE));
		String minuto = (maux < 10 ? "0" + maux : "" + maux);
		String segundo = c.get(Calendar.SECOND) + "";
		String horario = hora + ":" + minuto + ":" + segundo;
		return horario;
	}

	public static String mesAtual() {
		Calendar c = Calendar.getInstance();
		int maux = (c.get(Calendar.MONTH) + 1);
		String mes = (maux < 10 ? "0" + maux : "" + maux);
		String ano = c.get(Calendar.YEAR) + "";
		String data = mes + "/" + ano;
		return data;
	}

	public static String inicioMesAtual() {
		Calendar c = Calendar.getInstance();
		int maux = (c.get(Calendar.MONTH) + 1);
		String mes = (maux < 10 ? "0" + maux : "" + maux);
		String ano = c.get(Calendar.YEAR) + "";
		String data = "01/" + mes + "/" + ano;
		return data;
	}

	public static String fimMesAtual() {
		Calendar c = Calendar.getInstance();
		int maux = (c.get(Calendar.MONTH) + 1);
		int daux = (c.getActualMaximum(Calendar.DATE) + 1);
		String dia = (daux < 10 ? "0" + daux : "" + daux);
		String mes = (maux < 10 ? "0" + maux : "" + maux);
		String ano = c.get(Calendar.YEAR) + "";
		String data = dia + "/" + mes + "/" + ano;
		return data;
	}

	public static Collection stringToCollection(String value, String delim) {
		StringTokenizer tokens = new StringTokenizer(value, delim);
		Vector v = new Vector();
		while (tokens.hasMoreTokens()) {
			v.add(tokens.nextToken());
		}
		return v;
	}

	public static String formatCurrency(double custo) {
		if (custo <= 0.0) {
			return "0,00";
		}
		//Double d = new Double(custo);
		String custoFormatado;
		Currency c = Currency.getInstance(new Locale("pt", "BR"));
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
		nf.setCurrency(c);
		custoFormatado = nf.format(custo);
		if (custoFormatado.indexOf(",") < 0) {
			custoFormatado = custoFormatado + ",00";
		}
		//return nf.format(custo);
		return custoFormatado;
	}

	//formata um Float para usar o padrão pt-BR
	//não é um preço, é um decimal qualquer
	public static String setLocale(Float s) {
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));

		if(s != null) {
			return nf.format(s.doubleValue()); //parse funcionou, retorna o esperado
		}

		return "";
	}

	//faz o parse de uma String para usar o padrão pt-BR
	//não é um preço, é um decimal qualquer
	public static String getLocale(String s) throws ParseException {
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));

		if((s != null) && (s.trim().length() > 0)) {
			Number n = nf.parse(s.trim());

			return n.toString();
		}

		return "";
	}

	public static boolean isValidDouble( String value ) {
		
		if (value == null || value.trim().length() == 0) return false;
		if (possuiCaracteresInvalidos(value)) return false;
		try {
			NumberFormat nf = NumberFormat.getInstance();
			Number n = nf.parse(value);
			new Double(n.doubleValue());
		} catch (Exception e) {
			return false;
		}
		
		
		
		return true;
	}

	public static boolean possuiCaracteresInvalidos(String value) {
		if (value == null) return true;
		
		if ((value.indexOf("-") > 0) ||
			(value.indexOf("#") > 0) ||
			(value.indexOf("&") > 0) ||
			(value.indexOf("{") > 0) ||
			(value.indexOf("}") > 0) ||
			(value.indexOf("[") > 0) ||
			(value.indexOf("]") > 0) ||
			(value.indexOf(":") > 0) ||
			(value.indexOf("?") > 0) ||
			(value.indexOf("/") > 0) ||
			(value.indexOf("\\") > 0) ||
			(value.indexOf("!") > 0) ||
			(value.indexOf("@") > 0) ||
			(value.indexOf("$") > 0) ||
			(value.indexOf("(") > 0) ||
			(value.indexOf(")") > 0) ||
			(value.indexOf("_") > 0) ||
			(value.indexOf("=") > 0) ||
			(value.indexOf(";") > 0)) {
			return true;
		}
		
		return false;
	}
	public static String collectionToString(Collection<String> col) {
		String s = "";
		if ((col == null) || (col.size() == 0)) {
			return s;
		}
		Iterator<String> i = col.iterator();
		while (i.hasNext()) {
			s += i.next() + ",";
		}
		return s.substring(0, s.length()-1);
	}

	//specific to brazil
	//private static String cnpj = null;
	public static String formataSqlCnpj(String campo, String apelido) {
		return " case when length(" + campo +
		") = 14 then concat(  substring( " + campo + ", length(" +
		campo + ") - 13, 2), " +
		" '.', substring( " + campo + ", length(" + campo +
		") - 11, 3), " +
		" '.', substring( " + campo + ", length(" + campo +
		") - 8, 3), " +
		" '/', substring( " + campo + ", length(" + campo +
		") - 5, 4), '-' , " +
		" substring( " + campo + ", length(" + campo + ") - 1)) " +
		" else concat( SUBSTRING(" + campo + ", 1, 3), '.', " +
		" SUBSTRING(" + campo + ", 4, 3), '.', " +
		" SUBSTRING(" + campo + ", 7, 3), '-', " +
		" SUBSTRING(" + campo + ", 10)) end " + apelido + " ";
	}

	public static String formatDateTime(Date data, boolean longDate,
			boolean useSystem) {

		String DATE_FORMAT;
		if (longDate) {
			if (useSystem) {
				DATE_FORMAT = "EEEE, dd 'de' MMMM 'de' yyyy, 'às' HH:mm:ss";
			} else {
				return UsefulMethods.formatDateTime(data);
			}
		} else {
			DATE_FORMAT = "dd/MM/yyyy 'às' HH:mm:ss";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());

		return sdf.format(data);

	}
	
	public static String formatShortDateTime(Date data) {

		String DATE_FORMAT;
		DATE_FORMAT = "dd/MM/yyyy";
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(data);

	}

	public static String formatDateTime(Date data, boolean longDate) {
		return UsefulMethods.formatDateTime(data, longDate, true);
	}

	public static String formatDateTime(Date data) {
		return UsefulMethods.formatDateTime(data, false, true);
	}
	//BRAZIL
	public static String retornaDiaDaSemana(Date data) {
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(data);

		String formatado = "";

		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			formatado = "Segunda-feira";
			break;
		case Calendar.TUESDAY:
			formatado = "Terça-feira";
			break;
		case Calendar.WEDNESDAY:
			formatado = "Quarta-feira";
			break;
		case Calendar.THURSDAY:
			formatado = "Quinta-feira";
			break;
		case Calendar.FRIDAY:
			formatado = "Sexta-feira";
			break;
		case Calendar.SATURDAY:
			formatado = "Sábado";
			break;
		case Calendar.SUNDAY:
			formatado = "Domingo";
			break;
		}
		return formatado;
	}

	//BRAZIL
	public static String retornaNomeMes(Date data) {
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(data);

		String formatado = "";

		switch (cal.get(Calendar.MONTH)) {
		case Calendar.JANUARY:
			formatado = "Janeiro";
			break;
		case Calendar.FEBRUARY:
			formatado = "Fevereiro";
			break;
		case Calendar.MARCH:
			formatado = "Março";
			break;
		case Calendar.APRIL:
			formatado = "Abril";
			break;
		case Calendar.MAY:
			formatado = "Maio";
			break;
		case Calendar.JUNE:
			formatado = "Junho";
			break;
		case Calendar.JULY:
			formatado = "Julho";
			break;
		case Calendar.AUGUST:
			formatado = "Agosto";
			break;
		case Calendar.SEPTEMBER:
			formatado = "Setembro";
			break;
		case Calendar.OCTOBER:
			formatado = "Outubro";
			break;
		case Calendar.NOVEMBER:
			formatado = "Novembro";
			break;
		case Calendar.DECEMBER:
			formatado = "Dezembro";
			break;
		}
		return formatado;
	}

	
	public static Collection<String[]> listMeses() {
		ArrayList<String[]> a = new ArrayList();
		String[] b = new String[2];
		b[0] = "01";
		b[1] = "Janeiro";
		a.add(b);
		
		b = new String[2];
		b[0] = "02";
		b[1] = "Fevereiro";
		a.add(b);
		
		b = new String[2];
		b[0] = "03";
		b[1] = "Março";
		a.add(b);
		
		b = new String[2];
		b[0] = "04";
		b[1] = "Abril";
		a.add(b);
		
		b = new String[2];
		b[0] = "05";
		b[1] = "Maio";
		a.add(b);
		
		b = new String[2];
		b[0] = "06";
		b[1] = "Junho";
		a.add(b);
		
		b = new String[2];
		b[0] = "07";
		b[1] = "Julho";
		a.add(b);
		
		b = new String[2];
		b[0] = "08";
		b[1] = "Agosto";
		a.add(b);
		
		b = new String[2];
		b[0] = "09";
		b[1] = "Setembro";
		a.add(b);
		
		b = new String[2];
		b[0] = "10";
		b[1] = "Outubro";
		a.add(b);
		
		b = new String[2];
		b[0] = "11";
		b[1] = "Novembro";
		a.add(b);
		
		b = new String[2];
		b[0] = "12";
		b[1] = "Dezembro";
		a.add(b);
		return a;
	}
	
	public static Collection<String[]> listBimestres() {
		ArrayList<String[]> a = new ArrayList();
		String[] b = new String[2];
		b[0] = "01";
		b[1] = "Bimestre 01";
		a.add(b);
		
		b = new String[2];
		b[0] = "02";
		b[1] = "Bimestre 02";
		a.add(b);
		
		b = new String[2];
		b[0] = "03";
		b[1] = "Bimestre 03";
		a.add(b);
		
		b = new String[2];
		b[0] = "04";
		b[1] = "Bimestre 04";
		a.add(b);
		
		b = new String[2];
		b[0] = "05";
		b[1] = "Bimestre 05";
		a.add(b);
		
		b = new String[2];
		b[0] = "06";
		b[1] = "Bimestre 06";
		a.add(b);
		
		return a;
	}
	
	public static Collection<String[]> listSemestres() {
		ArrayList<String[]> a = new ArrayList();
		String[] b = new String[2];
		b[0] = "01";
		b[1] = "Semestre 01";
		a.add(b);
		
		b = new String[2];
		b[0] = "02";
		b[1] = "Semestre 02";
		a.add(b);
		
		return a;
	}
	
	public static Collection<String[]> listTrimestres() {
		ArrayList<String[]> a = new ArrayList();
		String[] b = new String[2];
		b[0] = "01";
		b[1] = "Trimestre 01";
		a.add(b);
		
		b = new String[2];
		b[0] = "02";
		b[1] = "Trimestre 02";
		a.add(b);
		
		b = new String[2];
		b[0] = "03";
		b[1] = "Trimestre 03";
		a.add(b);
		
		b = new String[2];
		b[0] = "04";
		b[1] = "Trimestre 04";
		a.add(b);
		
		return a;
	}
	
	public static Collection<String[]> listQuadrimestres() {
		ArrayList<String[]> a = new ArrayList();
		String[] b = new String[2];
		b[0] = "01";
		b[1] = "Quadrimestre 01";
		a.add(b);
		
		b = new String[2];
		b[0] = "02";
		b[1] = "Quadrimestre 02";
		a.add(b);
		
		b = new String[2];
		b[0] = "03";
		b[1] = "Quadrimestre 03";
		a.add(b);
		
		return a;
	}
	
	public static Date getCurrentDateTime() {

		Calendar cal = Calendar.getInstance(TimeZone.getDefault());

		return cal.getTime();
	}

	public static Timestamp getCurrentDateTimestamp() {

		Calendar cal = Calendar.getInstance(TimeZone.getDefault());

		return new Timestamp(cal.getTimeInMillis());
	}

	public static boolean isValidInteger( String str ){
		try{
			Integer.parseInt(str);
			return true;
		}catch( Exception ex){

		}
		return false;
	}


	public static String formataValorToString(double valor) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setCurrency(Currency.getInstance(new Locale("pt","BR")));
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		//System.out.println("> " + valor);
		String n = nf.format(valor);
		//System.out.println(">> " + n);
		return n;
		//return valor+"";
	}


	public static String formataValorToString(Double valor) {
		if (valor == null) {
			return "";
		}
		return UsefulMethods.formataValorToString(valor.doubleValue());
	}

	public static String formataValorToString(String valor) {
		if ((valor == null) || (valor.trim().length() == 0)) {
			return "";
		}
		double d = Double.parseDouble(valor.trim());
		//if (valor.indexOf(".") < 0 && valor.indexOf(",") < 0) d *= 100.0;
		return UsefulMethods.formataValorToString(d);
	}

	public static String formataStringToValor(String valor) {
		if ((valor == null) || (valor.trim().length() == 0)) {
			return "";
		}
		if ((valor.indexOf('.') >= 0) && (valor.indexOf(',') >= 0)) {
			valor = valor.substring(0, valor.indexOf('.')) +
			valor.substring(valor.indexOf('.') + 1, valor.length());
		}
		if ((valor.indexOf('.') >= 0) && (valor.indexOf(',') >= 0)) {
			valor = valor.substring(0, valor.indexOf('.')) +
			valor.substring(valor.indexOf('.') + 1, valor.length());
		}
		if ((valor.indexOf('.') >= 0) && (valor.indexOf(',') >= 0)) {
			valor = valor.substring(0, valor.indexOf('.')) +
			valor.substring(valor.indexOf('.') + 1, valor.length());
		}
		if (valor.indexOf(',') > 0) {
			valor = valor.replace(',', '.');
		}
		return valor;
	}


	public static String formataIntToPeriodo(String periodo) {
		if ((periodo == null) || (periodo.trim().length() ==0) ) {
			return "";
		}
		return periodo.trim().substring(4,periodo.trim().length()) + "/" + periodo.trim().substring(0,4);
	}

	public static String formataIntToPeriodo(int iPeriodo) {
		String periodo = String.valueOf(iPeriodo);
		return UsefulMethods.formataIntToPeriodo(periodo);
	}

	public static String formataIntToPeriodo(Integer iPeriodo) {
		if (iPeriodo == null) {
			return "";
		}
		String periodo = String.valueOf(iPeriodo.intValue());
		return UsefulMethods.formataIntToPeriodo(periodo);
	}

	public static String formataPeriodoToInt(String periodo) {
		if ((periodo == null) || (periodo.trim().length() ==0) ) {
			return "";
		}
		return periodo.trim().substring(3, periodo.trim().length()) + periodo.trim().substring(0, 2);
	}

	public static String dataToPeriodo(String data) {
		if ((data == null) || (data.trim().length() == 0) ) {
			return "";
		}
		return UsefulMethods.formataPeriodoToInt(data.trim().substring(3, data.trim().length()));
	}

	public static String getDataAtual() {
		Calendar c = Calendar.getInstance();
		int daux = c.get(Calendar.DATE);
		String dia = (daux < 10 ? "0" + daux : "" + daux);
		int maux = (c.get(Calendar.MONTH) + 1);
		String mes = (maux < 10 ? "0" + maux : "" + maux);
		String ano = c.get(Calendar.YEAR) + "";
		String data = dia + "/" + mes + "/" + ano;
		return data;
	}

	public static String getHoraAtual() {
		Calendar c = Calendar.getInstance();
		int haux = c.get(Calendar.HOUR);
		String hora = (haux < 10 ? "0" + haux : "" + haux);
		int maux = (c.get(Calendar.MINUTE));
		String minuto = (maux < 10 ? "0" + maux : "" + maux);
		String segundo = c.get(Calendar.SECOND) + "";
		String horario = hora + ":" + minuto + ":" + segundo;
		return horario;
	}

	public static String[] calculaPeriodosMes(String periodo) {
		String vAux[] = new String[13];
		int mesAtual = 0;
		int anoAtual = 0;
		if ((periodo == null) || (periodo.trim().length() == 0)) {
			Calendar c = Calendar.getInstance();
			mesAtual = c.get(Calendar.MONTH) + 1;
			anoAtual = c.get(Calendar.YEAR);
			mesAtual++;
			if (mesAtual > 12) {
				mesAtual = 1;
			} else {
				anoAtual--;
			}
		} else {
			if (periodo.indexOf("/") > 0) {
				mesAtual = Integer.parseInt(periodo.substring(0, 2));
				anoAtual = Integer.parseInt(periodo.substring(3, periodo.length()));
			} else {
				mesAtual = Integer.parseInt(periodo.substring(4, periodo.length()));
				anoAtual = Integer.parseInt(periodo.substring(0, 4));
			}
		}
		vAux[0] = "Imposto";
		for (int i = 1; i < vAux.length; i++) {
			if (mesAtual > 12) {
				mesAtual = 1;
				anoAtual++;
			}
			String mes = "";
			if (mesAtual < 10) {
				mes = "0" + mesAtual;
			} else {
				mes = "" + mesAtual;
			}
			mesAtual++;
			vAux[i] = (mes) + "/" + anoAtual;
		}
		return vAux;
	}

	public static String[] calculaPeriodosAnos(String periodo) {
		String vAux[] = new String[6];
		int anoAtual = 0;
		if ((periodo == null) || (periodo.trim().length() == 0)) {
			Calendar c = Calendar.getInstance();
			anoAtual = c.get(Calendar.YEAR);
			anoAtual = anoAtual - 4;
		} else {
			anoAtual = Integer.parseInt(periodo.substring(3, periodo.length()));
		}
		vAux[0] = "Imposto";
		for (int i = 1; i < vAux.length; i++) {
			vAux[i] = "01/" + (anoAtual++);
		}
		return vAux;
	}

	public static int acertaPeriodo(String periodo,String tipo) {
		String aux = null;
		String mes = "";
		if ((periodo == null) || (periodo.trim().length() == 0)) {
			Calendar c = Calendar.getInstance();
			int mesAtual = c.get(Calendar.MONTH) + 1;
			int anoAtual = c.get(Calendar.YEAR);
			if ((tipo != null) && tipo.equals("4")) {
				mesAtual++;
				if (mesAtual > 12) {
					mesAtual = 1;
				} else {
					anoAtual--;
				}
				if (mesAtual < 10) {
					mes = "0" + mesAtual;
				} else {
					mes = mesAtual + "";
				}
				aux = anoAtual + "" + mes;
			} else {
				anoAtual -= 4;
				aux = anoAtual + "01";
			}
		} else {
			if (periodo.indexOf("/") > 0) {
				aux = periodo.substring(3, periodo.length()) +
				periodo.substring(0, 2);
			} else {
				aux = periodo;
			}
		}
		return Integer.parseInt(aux);
	}

	public static String getProximaData(String dataLimite) {
		if ((dataLimite == null) || (dataLimite.trim().length() == 0)) {
			return "";
		}
		String tdia = dataLimite.substring(0,2);
		String tmes = dataLimite.substring(3,5);
		String tano = dataLimite.substring(6, dataLimite.length());
		GregorianCalendar c = new GregorianCalendar();

		int dia = Integer.parseInt(tdia);
		int mes = Integer.parseInt(tmes);
		int ano = Integer.parseInt(tano);

		c.set(ano, mes-1, dia);
		c.add(Calendar.MONTH, 1);
		dia = c.get(Calendar.DATE);
		mes = c.get(Calendar.MONTH)+1;
		ano = c.get(Calendar.YEAR);
		if (mes == 0) {
			mes = 12;
		}
		return (dia < 10 ? "0" + dia : dia + "") + "/" + (mes < 10 ? "0" + mes : mes + "") + "/" + ano ;
	}

	public static String getProximaData2(String dataLimite, int numMes) {
		if ((dataLimite == null) || (dataLimite.trim().length() == 0)) {
			return "";
		}
		String tdia = dataLimite.substring(0,2);
		String tmes = dataLimite.substring(3,5);
		String tano = dataLimite.substring(6, dataLimite.length());

		GregorianCalendar c = new GregorianCalendar();

		int dia = Integer.parseInt(tdia);
		int mes = Integer.parseInt(tmes)+numMes;
		int ano = Integer.parseInt(tano);

		c.set(ano, mes-1, 1);
		int ultimoDia = c.getActualMaximum(Calendar.DATE);

		if (dia > ultimoDia) {
			dia = ultimoDia;
		}
		c.set(ano, mes - 1, dia);

		//c.add(Calendar.MONTH, 1);
		dia = c.get(Calendar.DATE);
		mes = c.get(Calendar.MONTH) + 1;
		ano = c.get(Calendar.YEAR);
		if (mes == 0) {
			mes = 12;
		}
		return (dia < 10 ? "0" + dia : dia + "") + "/" + (mes < 10 ? "0" + mes : mes + "") + "/" + ano ;
	}

	public static String getDataCorreta(String dataLimite) {
		if ((dataLimite == null) || (dataLimite.trim().length() == 0)) {
			return "";
		}

		String tdia = dataLimite.substring(0,2);
		String tmes = dataLimite.substring(3,5);
		String tano = dataLimite.substring(6, dataLimite.length());

		int dia = Integer.parseInt(tdia);
		int mes = Integer.parseInt(tmes);
		int ano = Integer.parseInt(tano);

		GregorianCalendar cAtual = new GregorianCalendar();
		GregorianCalendar cLimite = new GregorianCalendar();
		cLimite.set(ano, mes-1, 1);

		if (cLimite.getTimeInMillis() > cAtual.getTimeInMillis()) {
			dia = cAtual.get(Calendar.DATE);
			mes = cAtual.get(Calendar.MONTH)+1;
			ano = cAtual.get(Calendar.YEAR);
		}
		return (dia < 10 ? "0" + dia : dia + "") + "/" + (mes < 10 ? "0" + mes : mes + "") + "/" + ano ;
	}

	public static String getUltimoDiaMes(String dataInicio) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, Integer.parseInt(dataInicio.substring(dataInicio.indexOf("/")+ 1, dataInicio.lastIndexOf("/")))-1);
		int dia = c.getActualMaximum(Calendar.DATE);
		//int mes = c.get(Calendar.MONTH) + 1;
		int mes = c.get(Calendar.MONTH);
		int ano = c.get(Calendar.YEAR);
		return (dia < 10 ? "0" + dia : dia + "") + "/" + (mes < 10 ? "0" + mes : mes + "") + "/" + ano;
	}

	

	public static String formataCusto(BigDecimal custo) {
		if(custo == null) {
			return "";
		}
		return UsefulMethods.formataCusto(custo.doubleValue());
	}
	
	public static BigDecimal formatStringToValor(String custo) {
		if(custo == null) {
			return null;
		}
		return new BigDecimal(UsefulMethods.formataStringToValor(custo));
	}

	public static Integer verificaIdIdioma(Integer idIdioma) {
		if ((idIdioma == null) || (idIdioma.intValue() == 0)) {
			return 1;
		}
		return idIdioma;
	}

	public static String acertaNome(String nome) {
		if (nome == null) {
			return "";
		}
		if (nome.equalsIgnoreCase("nala_nm_nome")) {
			return "Natureza do Lançamento";
		} else if (nome.equalsIgnoreCase("pess_nm_nome")) {
			return "Nome";
		} else if (nome.trim().length() == 0) {
			return "Total";
		} else {
			return nome;
		}
	}

	

	public static String sqlTimestampToDate(java.sql.Timestamp data) {
		Calendar c = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		c.setTimeInMillis(data.getTime());
		Date date1 = c.getTime();
		return formatter.format(date1);
	}

	
	public static String retornaValoresSemAspa(String nome){
		String temp ="";
		if(nome != null){
			temp = nome.replace("\""," ");
			temp = temp.replace("\'"," ");
			temp = temp.replace(";", ",");
		}
		return temp;
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	public static boolean isLong(String s) {
		try {
			Long.parseLong(s);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	public static Map sortByValue(Map map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		// logger.info(list);
		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry)it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	

	public static ArrayList<String> split(String nome, String deli){
		StringBuilder string = new StringBuilder(nome);
		int inicio = 0;
		int fim;
		ArrayList<String> array = new ArrayList<String>();
		for(int i=0 ; i < string.length() ; i++) {
			fim = string.indexOf(deli, i);
			if(fim ==  -1){
				fim = string.length();
			}
			i = fim + deli.length() - 1;
			array.add(string.substring(inicio, fim));
			inicio = i;
			inicio++;
		}
		return array;
	}

	public static String traduzCodigoDeEquipamento(String codigo) {
		StringBuilder s = new StringBuilder();

		StringTokenizer st = new StringTokenizer(codigo, ".");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			int len = token.length();
			for (int i = 3; i > len; --i) {
				token = "0" + token;
			}

			s.append(token);
		}

		return s.toString();
	}

	public static boolean testaElemento(String elemento) {
		if((elemento != null)
				&& (elemento.trim().length() >1)
				&& (!elemento.trim().equals("clique na lupa ao lado para obter as informações"))) {
			return true;
		}

		return false;
	}
	public static Float arredondaNumero(Float din,int digitos){
		Locale locBR = new Locale("en","US");
		NumberFormat formataNumero = NumberFormat.getInstance(locBR);
		formataNumero.setMaximumFractionDigits(digitos);
		formataNumero.setMinimumFractionDigits(digitos);
		Float c = new Float(formataNumero.format(din).replace(",", ""));
		return c;
	}

	/**
	 * Recebe um número de PS tal como digitado pelo usuário e converte
	 * no número de verdade e id, se houver.
	 * 
	 * @param numeroDoPS
	 * @return vetor com duas posições, sendo a primeira a string número
	 * 			e a segunda o id do PS
	 * @throws IllegalArgumentException - se o parâmetro passado ao método
	 * 										for nulo ou vazio
	 */
	public static Object[] parseNumeroPS(String numeroDoPS) {
		if ((numeroDoPS == null) || (numeroDoPS.trim().length() <= 0)) {
			throw new IllegalArgumentException();
		}

		if (numeroDoPS.contains("/")) {
			int i = numeroDoPS.lastIndexOf("/");
			String numero = null;
			Long idNumero = null;

			numero = numeroDoPS.substring(0, i);
			if (numeroDoPS.length() > i+1) {
				idNumero = Long.parseLong(numeroDoPS.substring(i+1, numeroDoPS.length()));
			}

			return new Object[] {numero, idNumero};
		} else {
			return new Object[] {numeroDoPS, null};
		}
	}

	/**
	 * Recebe uma string s representando um número com pontos e vírgulas.
	 * Retorna a string correspondente a este número com apenas um ponto
	 * separando a casa decimal da parte inteira e removendo todos os
	 * outros caracteres não número.
	 */
	public static String getSimpleCurrency(String s) {
		s = s.replaceAll("[^0-9,.]", "");
		s = s.replace(",", ".");
		StringBuilder sb = new StringBuilder(s);
		int indice = sb.lastIndexOf(".") - 1;
		while (indice >= 0) {
			if (sb.charAt(indice) == '.') {
				sb.deleteCharAt(indice);
				indice = sb.lastIndexOf(".") - 1;
			} else {
				indice--;
			}
		}
		return sb.toString();
	}
	
	
	
	public static String formataCusto(double custo) {
		if (custo <= 0.0) {
			return "0,00";
		}
		//Double d = new Double(custo);
		String custoFormatado;
		Currency c = Currency.getInstance(new Locale("pt", "BR"));
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setCurrency(c);
		custoFormatado = nf.format(custo);
		if (custoFormatado.indexOf(",") < 0) {
			custoFormatado = custoFormatado + ",00";
		}
		//return nf.format(custo);
		return custoFormatado;
	}

	public static String formataCusto(Double custo) {
		if(custo == null) return "";
		return formataCusto(custo.doubleValue());
	}

	

	public static String replace(String valor, String token1, String token2) {
		if (valor == null) return "";
		return valor.replaceAll(token1, token2);
	}
	
	public static String removeEnter(String nome){
		String temp ="";
		if(nome != null){
			temp = nome.replace("\n"," ");
			temp = temp.replace("\r"," ");
		}
		return temp;
	}
	public static Date adicionaDias(Date date, Integer dias) {  
		GregorianCalendar gc = new GregorianCalendar();  
		gc.setTime(date);  
		gc.set(Calendar.DATE, gc.get(Calendar.DATE) + dias);  
		return gc.getTime();  
	}

	public static String removeTagsHtml(String htmlString) {
		htmlString = htmlString.trim();
		
		//O primeiro parâmetro do replaceAll abaixo é uma expressão regular;
		//Equivale a \<.*?\> que é o caracter < seguido de qualquer número
		//de outros caracteres até o primeiro caracter >
		return htmlString.replaceAll("\\<.*?\\>", "");
	}
	
	public static Boolean contemHtml(String htmlString) {
		String noHTMLString = removeTagsHtml(htmlString);
		
		return !(htmlString.equals(noHTMLString));
	}
	
	public static boolean isValidDateFormat(String value)
	{
		if (value == null) return false;
		try{
			//String decomposta = decompoeMontaData(value);
			if (!((value.charAt(3) == '/') && (value.charAt(5) == '/')))
				return false;
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public static String decompoeMontaData(String data){
		if ((data != null) && (data.trim().length() > 0)){
			data = data.trim();
			String dia = data.substring(0, 2);
			String mes = data.substring(3, 5);
			String ano = data.substring(6, 10);
			String dataTransformada = ano + mes + dia;
			return dataTransformada;
		}
		else{
			return null;
		}
	}

	/*public static Date parseData(String data){
		if ((data == null) || (data.trim().length() == 0)) return null;
			data = data.trim();
			String dia = data.substring(0, 2);
			String mes = data.substring(3, 5);
			String ano = data.substring(6, 10);
			
			GregorianCalendar cal = new GregorianCalendar();
			cal.set(Integer.parseInt(ano), Integer.parseInt(mes)-1, Integer.parseInt(dia));
			return cal.getTime();			
	}*/
	
	public static Date parseData(String mdata) {
		try {
			//System.out.println("Data 1 = " + mdata);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			//TimeZone tz = TimeZone.getTimeZone("GMT -03:00 - Brasilia");
			//df.setTimeZone(tz);
			//System.out.println("Data 2 = " + df.parse(mdata).toString());
			return df.parse(mdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formataData(Date mdata) {
		try {
			//System.out.println("Data 3 = " + mdata.toString());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			//TimeZone tz = TimeZone.getTimeZone("GMT -03:00 - Brasilia");
			//df.setTimeZone(tz);
			//System.out.println("Data 4 = " + df.format(mdata));
			return df.format(mdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getStatusOuvidoria(String status) {
		if (status != null) {
			if (status.equals("0")) {
				return "Aberto";
			} else if (status.equals("1")) {
				return "Em Andamento";
			} else if (status.equals("2")) {
				return "Devolvido";
			} else if (status.equals("3")) {
				return "Finalizado";
			} else if (status.equals("4")) {
				return "Cancelado";
			} 
		}
		return "";
	}
	
	public static String retornaNomeMes(String mes) {
		String formatado = "";

		if (mes.equalsIgnoreCase("1") || mes.equalsIgnoreCase("01")) {
			formatado = "Janeiro";
		} else if (mes.equalsIgnoreCase("2") || mes.equalsIgnoreCase("02")) {
			formatado = "Fevereiro";
		} else if (mes.equalsIgnoreCase("3") || mes.equalsIgnoreCase("03")) {
			formatado = "Março";
		} else if (mes.equalsIgnoreCase("4") || mes.equalsIgnoreCase("04")) {
			formatado = "Abril";
		} else if (mes.equalsIgnoreCase("5") || mes.equalsIgnoreCase("05")) {	
			formatado = "Maio";
		} else if (mes.equalsIgnoreCase("6") || mes.equalsIgnoreCase("06")) {	
			formatado = "Junho";
		} else if (mes.equalsIgnoreCase("7") || mes.equalsIgnoreCase("07")) {	
			formatado = "Julho";
		} else if (mes.equalsIgnoreCase("8") || mes.equalsIgnoreCase("08")) {	
			formatado = "Agosto";
		} else if (mes.equalsIgnoreCase("9") || mes.equalsIgnoreCase("09")) {	
			formatado = "Setembro";
		} else if (mes.equalsIgnoreCase("10")) {	
			formatado = "Outubro";
		} else if (mes.equalsIgnoreCase("11")) {	
			formatado = "Novembro";
		} else if (mes.equalsIgnoreCase("12")) {
			formatado = "Dezembro";
		}
		return formatado;
	}
}
