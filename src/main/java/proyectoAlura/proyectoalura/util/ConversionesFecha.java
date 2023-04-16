
package proyectoAlura.proyectoalura.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversionesFecha {
	
	public static  String conversionDateToString(Date  fecha) {
		
		
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		return  d.format(fecha);
		
		
	}
	
	
	public static LocalDate conversionStringToLocalDate(String  fecha) {
		
		return LocalDate.parse(fecha ) ;
		
		
		
	}
	
	public static int calcularDiasEntreFechasLocalDate(LocalDate fechaInicial, LocalDate fechaFinal) {
		
		Period p = Period.between( fechaInicial,fechaFinal );
	return p.getDays();
		
	}
	
	public static  boolean  determinarFormatoFechaIngresadoBusqueda(String   fecha) {
		
		//Pattern  patron = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		
		Pattern  patron = Pattern.compile( "^((?:19|20)[0-9][0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
		Matcher igualador= patron.matcher(fecha);
		return igualador.matches();
		
	}
	
	
	public static  Integer calcularCostoDiasReservados(Integer  dias ,  Integer valorDiario) {
		
		
		
		
		return dias*valorDiario;
		
	}

}
