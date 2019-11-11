package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class ObjectsOnLoanTest extends ObjectsInterfaceTest{
	
	public ObjectsInterface createInstance() {
		return new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
	}
	
	@Test
	public void testGetTimeOnLoan() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		user.addObjectOnLoan(new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844"));
		
		int [] expectedResult = {0,0,0,1};
		int [] realResult = user.getObjectsOnLoan().get(0).getTimeOnLoan();
		
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testOverpassedTime() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		user.addObjectOnLoan(new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844"));
		
		boolean[] overpassedTime = user.getObjectsOnLoan().get(0).overPassedTime(user.getObjectsOnLoan().get(0).getTimeOnLoan());
		
		assertFalse(overpassedTime[0]);
	}
	
	@Test
	public void testSanctions() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		user.addObjectOnLoan(new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844"));
		
		int [] time = {0,7,0};
		
		int expectedResult = 8;
		int realResult = user.getObjectsOnLoan().get(0).sanctions(time);
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testDateOfDeliver() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		user.addObjectOnLoan(new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844"));
		
		int [] expectedResult = {Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 14,11,2019};
		int [] realResult = user.getObjectsOnLoan().get(0).dateOfDeliver();
		
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testTimeToDeliver() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		user.addObjectOnLoan(new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844"));
		
		int [] expectedResult = {14,0,0};
		int [] realResult = user.getObjectsOnLoan().get(0).timeToDeliver(user.getObjectsOnLoan().get(0).dateOfDeliver());
		
		assertArrayEquals(expectedResult, realResult);
	}
}
