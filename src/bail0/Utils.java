package bail0;

import java.util.Calendar;
import java.util.Date;

import bail0.Student;

public class Utils {
	

	public static int getYearOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
	
//	public String generateCodeStudent() {
//		int id = Student.id;
//		
//		return "";
//	}
	
}
