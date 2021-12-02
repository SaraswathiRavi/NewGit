package amasonMethods;

import java.util.Date;
import java.util.Scanner;
import java.time.Month;
import java.time.LocalDate;
class mainClass {
	public static void
	getDayMonthYear(String date)
    {
		LocalDate currentDate= LocalDate.parse(date);
		int day = currentDate.getDayOfMonth();
		Month month = currentDate.getMonth();
		int year = currentDate.getYear();
	System.out.println(	currentDate.getDayOfWeek());
		
	}
	public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		String date = sc.next();
		getDayMonthYear(date);
	}
}