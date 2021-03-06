import java.util.GregorianCalendar;
import java.util.Locale;

public class Launcher {
	public static void main(String[] args) {
		GregorianCalendar revolution = new GregorianCalendar(1789,2,14);
		
		int year = revolution.get(GregorianCalendar.YEAR);
		int month = revolution.get(GregorianCalendar.MONTH);
		int day = revolution.get(GregorianCalendar.DAY_OF_MONTH);
		
		System.out.println("Year : " + year);
		System.out.println("Month : " + month);
		System.out.println("Day : " + day);
		
		String monthStr = revolution.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE);
		System.out.println(monthStr);
	}
}
