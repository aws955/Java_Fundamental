package java_20190731;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1; //달은 0부터 센다.
		int day = c.get(Calendar.DATE);
		
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		System.out.printf("%d년%d월%d일%d시%d분%d초%n",year,month,day,hour,minute,second);
		
		c.set(2019, 6, 1);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		JavaCalendar c2 =new JavaCalendar();
		//c2.print(2019, 7, 31);
		
		//c2.print(2019, 7);
		
		c2.print(1600);
		
		GregorianCalendar g = new GregorianCalendar();
		boolean j = g.isLeapYear(4);
		System.out.println(j);
	}
}
