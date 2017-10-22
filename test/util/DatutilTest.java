package util;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DatutilTest {

	Date d = null, today = null;
	Datutil du = null;
	DateFormat df = null, df2 = null;
	String convert_today, convert_dateDuJour, convert_date, convert_next_date;
	
	@Before
	public void setUp() throws Exception {
		d = Datutil.dateDuJour();
		df = new SimpleDateFormat("dd-MM-yyyy");
		df2 = new SimpleDateFormat("dd/MM/yy"); //for dateToStringTest()
		today = Calendar.getInstance().getTime();
	}

	@Test
	public void dateDuJourTest() {
		assertNotNull(d);
		convert_today = df.format(today);
		convert_dateDuJour = df.format(d);
		assertEquals(convert_today,convert_dateDuJour);
	}

	@SuppressWarnings("static-access")
	@Test
	public void addDateTestFail() throws ParseException {
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(d); 
		convert_date = df.format(du.dateDuJour()); //today
		convert_next_date = df.format(du.addDate(today, 1)); //today+1
		
		cal.add(Calendar.DATE, 1); //tomorrow
		d = cal.getTime();
		String tomorrow = df.format(d);
	
		assertEquals(tomorrow,convert_next_date); 
	}
	
	@Test 
	public void dateToSqlValuesTest() {
		convert_date = df.format(du.dateDuJour()); //today
		String date_test = du.dateToSqlValues(d);
		assertEquals(convert_date,date_test);
	}
	
	@Test
	public void dateToStringTest() {
		convert_date = df2.format(du.dateDuJour()); //today
		String date_test = du.dateToString(du.dateDuJour());	
		assertEquals(convert_date,date_test);
	}
}
