package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Hashtable;

import org.junit.jupiter.api.Test;
import Libraries.MyException;

class MyExceptionTest {

	@Test
	public void testMyException1() {
		MyException exception = new MyException();
		
		int expectedResult = 31;
		int realResult = exception.getMultidimensionalDatesArray()[0].length;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testMyException2() {
		MyException exception = new MyException();
		
		int expectedResult = 12;
		int realResult = exception.getMultidimensionalDatesArray()[1].length;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testMyException3() {
		MyException exception = new MyException();
		
		int expectedResult = 70;
		int realResult = exception.getMultidimensionalDatesArray()[2].length;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetException1() {
		MyException exception = new MyException();

		assertEquals("There are no languages or countrys with the codes: ", exception.getException("ErrorLanguageCountry"));
	}
	
	@Test
	public void testGetException2() {
		MyException exception = new MyException();

		assertEquals("There are no options for your election.", exception.getException("ErrorIntegerOutOfBounds"));
	}
	
	@Test
	public void testGetException3() {
		MyException exception = new MyException();
		
		assertEquals("Wrong parameters for the birth dates.", exception.getException("ErrorBirthDates"));
	}
	
	@Test
	public void testGetException4() {
		MyException exception = new MyException();
		
		assertEquals("You dont have any item with that data.", exception.getException("ErrorObjectNotFound"));
	}
	
	@Test
	public void testGetException5() {
		MyException exception = new MyException();
		
		assertEquals("You have taken too long to return the item, you can no longer make loans in this library", exception.getException("ErrorToMuchTime"));
	}
	
	@Test
	public void testGetException6() {
		MyException exception = new MyException();
		
		assertEquals("You overpassed the time of the loan, the item is removed", exception.getException("ErrorOverpassedTime"));
	}
	
	@Test
	public void testGetException7() {
		MyException exception = new MyException();

		assertEquals("You already extend the loan time of the item two times, you cant extend it more.", exception.getException("ErrorTwoTimesLoan"));
	}
	
	@Test
	public void testGetException8() {
		MyException exception = new MyException();

		assertEquals("The years data are wrong, the operation can not be resolved.", exception.getException("ErrorWrongYearData"));
	}
	
	@Test
	public void testGetException9() {
		MyException exception = new MyException();
		
		assertEquals("You cant borrow any object while having sanctions.", exception.getException("ErrorHaveSanctions"));
	}
	
	@Test
	public void testGetException10() {
		MyException exception = new MyException();
		
		assertEquals("You dont have products on your shopping basket.", exception.getException("ErrorHaveNoProducts"));
	}
	
	@Test
	public void testGetErrors() {
		MyException exception = new MyException();
		Hashtable<String, String> table = new Hashtable<String, String>();
		table.put("Error1", "1");
		exception.setErrors(table);
		
		assertEquals(table, exception.getErrors());
	}

	@Test
	public void testSetErrors() {
		MyException exception = new MyException();
		Hashtable<String, String> table = new Hashtable<String, String>();
		Hashtable<String, String> table1 = new Hashtable<String, String>();
		table.put("Error1", "1");
		table1.put("Error2", "2");
		exception.setErrors(table);
		
		assertEquals(table, exception.getErrors());
		
		exception.setErrors(table1);
		
		assertEquals(table1, exception.getErrors());
	}

	@Test
	public void testGetMultidimensionalDatesArray() {
		MyException exception = new MyException();
		String [][] multidimensionalArray;
		String [] days = new String[31];
		String [] months = new String[12];
		String [] years = new String[70];
		int j = 0;
		for(int i = 0; i < 31; i++) {
			days[i] = (String.valueOf(i+1));
		}
		for(int i = 0; i < 12; i++) {
			months[i] = (String.valueOf(i+1));
		}
		for(int i = (Calendar.getInstance().get(Calendar.YEAR) - 69); i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
			years[j] = (String.valueOf(i));
			j++;
		}
		multidimensionalArray = new String[][] {days,months,years};
		
		assertArrayEquals(multidimensionalArray, exception.getMultidimensionalDatesArray());
	}

	@Test
	public void testSetMultidimensionalDatesArray() {
		MyException exception = new MyException();
		String [][] multidimensionalArray;
		String [][] multidimensionalArray1;
		String [] days = new String[31];
		String [] days1 = new String[32];
		String [] months = new String[12];
		String [] years = new String[70];
		int j = 0;
		for(int i = 0; i < 31; i++) {
			days[i] = (String.valueOf(i+1));
		}
		for(int i = 0; i < 32; i++) {
			days1[i] = (String.valueOf(i+1));
		}
		for(int i = 0; i < 12; i++) {
			months[i] = (String.valueOf(i+1));
		}
		for(int i = (Calendar.getInstance().get(Calendar.YEAR) - 69); i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
			years[j] = (String.valueOf(i));
			j++;
		}
		multidimensionalArray = new String[][] {days,months,years};
		multidimensionalArray1 = new String[][] {days1,months,years};
		
		assertArrayEquals(multidimensionalArray, exception.getMultidimensionalDatesArray());
		
		exception.setMultidimensionalDatesArray(multidimensionalArray1);
		
		assertArrayEquals(multidimensionalArray1, exception.getMultidimensionalDatesArray());
	}
}
