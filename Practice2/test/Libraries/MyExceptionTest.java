package Libraries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Libraries.MyException;

class MyExceptionTest {

	@Test
	public void testMyException1() {
		MyException exception = new MyException();
		
		int expectedResult = 31;
		int realResult = exception.getDays().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testMyException2() {
		MyException exception = new MyException();
		
		int expectedResult = 12;
		int realResult = exception.getMonths().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testMyException3() {
		MyException exception = new MyException();
		
		int expectedResult = 70;
		int realResult = exception.getYears().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetException1() {
		MyException exception = new MyException();
		
		String expectedResult = "There are no languages or countrys with the codes: ";
		String realResult = exception.getException("ErrorLanguageCountry");
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetException2() {
		MyException exception = new MyException();
		
		String expectedResult = "There are no options for your election.";
		String realResult = exception.getException("ErrorIntegerOutOfBounds");
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetException3() {
		MyException exception = new MyException();
		
		String expectedResult = "Wrong parameters for the birth dates.";
		String realResult = exception.getException("ErrorBirthDates");
		
		assertEquals(expectedResult, realResult);
	}
}
