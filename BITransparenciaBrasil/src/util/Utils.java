package util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.msoft.util.security.Cipher;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
@SuppressWarnings("all")
public class Utils {
	//private static String cnpj = null;

	public Utils() {
	}

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

	public static String formataData(Date data) {
		Calendar tmp = Calendar.getInstance();

		if (data == null) {
			return "";
		}

		tmp.setTime(data);

		String ano = (String.valueOf(tmp.get(Calendar.YEAR))),
		mes = (String.valueOf(tmp.get(Calendar.MONTH) + 1)),
		dia = (String.valueOf(tmp.get(Calendar.DAY_OF_MONTH)));

		if (mes.length() == 1) {
			mes = "0" + mes;
		}

		if (dia.length() == 1) {
			dia = "0" + dia;
		}

		return ano + mes + dia;
	}
	
	public static String formataDataDDMMYYYY(Date data) {
		Calendar tmp = Calendar.getInstance();

		if (data == null) {
			return "";
		}

		tmp.setTime(data);

		String ano = (String.valueOf(tmp.get(Calendar.YEAR))),
		mes = (String.valueOf(tmp.get(Calendar.MONTH) + 1)),
		dia = (String.valueOf(tmp.get(Calendar.DAY_OF_MONTH)));

		if (mes.length() == 1) {
			mes = "0" + mes;
		}

		if (dia.length() == 1) {
			dia = "0" + dia;
		}

		return dia + "/" + mes + "/" + ano;
	}
	
	private static String retornaChaveParaCriptografia(String key){	
		StringBuffer chave = new StringBuffer();
		int i = 0;
		for (char ch : key.toCharArray()){
			chave.append(Integer.toHexString(ch));
			i++;
		}
		//if(i < 65){
		for(;i<=65;i++){
			chave.append("0");	
		}
		//}
		return chave.toString().substring(0,64);
	}
	
	public static String getEncryptedWithKey(String evento,String key) {
		try {
			String chave = retornaChaveParaCriptografia(key);
			
			if (evento != null && evento.trim().length() > 0) {
				Cipher objEnc = new Cipher(Cipher.ALGORITHM_RIJNDAEL,
						chave,
						Cipher.MODE_ECB);

				return objEnc.encipher(evento);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static String getDecryptedWithKey(String texto,String key) {
		try {
			String chave = retornaChaveParaCriptografia(key);
			if (texto != null && texto.trim().length() > 0) {
				Cipher objEnc = new Cipher(Cipher.ALGORITHM_RIJNDAEL,
						chave,
						Cipher.MODE_ECB);

				return objEnc.decipher(texto);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static String getEncrypted(String texto) {
		try {
			if (texto != null && texto.trim().length() > 0) {
				Cipher objEnc = new Cipher(Cipher.ALGORITHM_RIJNDAEL,
						Constants.RIJNDAEL_KEY,
						Cipher.MODE_ECB);

				return objEnc.encipher(texto);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String getDecrypted(String texto) {
		try {
			if (texto != null && texto.trim().length() > 0) {
				Cipher objEnc = new Cipher(Cipher.ALGORITHM_RIJNDAEL,
						Constants.RIJNDAEL_KEY,
						Cipher.MODE_ECB);

				return objEnc.decipher(texto);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String exceptionToString(Exception ex) {
		if (ex != null) {
			StringWriter x = new StringWriter();
			PrintWriter s = new PrintWriter(x);

			ex.printStackTrace(s);

			return x.toString();
		}

		return null;
	}

	public static String formataDataHora(Date data, boolean longDate,
			boolean useSystem) {

		String DATE_FORMAT;
		if (longDate) {
			if (useSystem) {
				DATE_FORMAT = "EEEE, dd 'de' MMMM 'de' yyyy, 'às' HH:mm:ss";
			} else {
				return formataDataHoraManual(data);
			}
		} else {
			DATE_FORMAT = "dd/MM/yyyy 'às' HH:mm:ss";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());

		return sdf.format(data);

	}

	public static String formataDataHora(Date data, boolean longDate) {
		return formataDataHora(data, longDate, true);
	}

	public static String formataDataHora(Date data) {
		return formataDataHora(data, false, true);
	}

	private static String formataDataHoraManual(Date data) {
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(data);

		SimpleDateFormat sdf = new SimpleDateFormat(" 'de' yyyy, 'às' HH:mm:ss");
		sdf.setTimeZone(TimeZone.getDefault());
		String compl = sdf.format(data);

		String formatado = UsefulMethods.retornaDiaDaSemana(data) + ", " + cal.get(Calendar.DAY_OF_MONTH) + " de " + UsefulMethods.retornaNomeMes(data) + compl;

		return formatado;
	}

	
	public static Date getCurrentDateTime() {

		Calendar cal = Calendar.getInstance(TimeZone.getDefault());

		return cal.getTime();
	}

	/**
	 * Implementa uma "clone machine" para objetos baseados em get/set
	 * @param obj Object Objeto a ser clonado
	 * @return Object Clone do objeto
	 */
	public static Object genericBeanCloneMachine(Object obj) {
		if (obj != null) {
			try {
				Object objNew = obj.getClass().newInstance();
				Method[] tmp = objNew.getClass().getMethods();

				for (int i = 0; i < tmp.length; i++) {
					if (tmp[i].getName().startsWith("set")) {
						Method objGet = null;
						try {
							objGet = obj.getClass().getMethod(tmp[i].getName().
									replaceFirst("set", "get"), null);
						} catch (Exception ex) {}

						if (objGet != null) {
							Object[] arguments = new Object[1];
							arguments[0] = objGet.invoke(obj, null);
							tmp[i].invoke(objNew, arguments);
						}
					}
				}
				return objNew;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	public static boolean isValidInteger( String str ){
		try{
			Integer.parseInt(str);
			return true;
		}catch( Exception ex){

		}
		return false;
	}

	public static String formataNumero( double num ){
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.');

		DecimalFormat formato = new DecimalFormat("#,##0.00;(#,##0.00)", simbolos);

		return formato.format(num);
	}

	public static double formataNumero( String num ){
		if( num == null )
			return 0;

		num = num.replaceAll("\\.", "");
		num = num.replaceAll(",", ".");

		return Double.parseDouble(num);
	}
	
	public static String toMd5(String senha) {
		String sen = ""; 
        MessageDigest md = null; 
		try { 
		    md = MessageDigest.getInstance("MD5"); 
		} catch (NoSuchAlgorithmException e) { 
		    e.printStackTrace(); 
		} 
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes())); 
		sen = hash.toString(16);             
		return sen; 
    }


}
