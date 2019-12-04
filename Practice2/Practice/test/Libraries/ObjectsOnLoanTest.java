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
		
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 14;
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int totalDays = 0, totalMonths = 0, totalYears = 0;
		
		if(day > 31) {
			totalDays = day - 31;
			totalMonths += 1;
		}else {
			totalDays = day;
		}
		
		if((month + totalMonths) > 12) {
			totalYears += 1;
			totalMonths = 1;
		}else {
			totalMonths += month;
		}
		
		year += totalYears;
		
		int [] expectedResult = {totalDays,totalMonths,year};
		int [] realResult = user.getObjectsOnLoan().get(0).dateOfDeliver();
		
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testTimeToDeliver() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		user.addObjectOnLoan(new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844"));
		
		int [] expectedResult = {14,0,0};
		int [] realResult = user.getObjectsOnLoan().get(0).timeToDeliver(user.getObjectsOnLoan().get(0).dateOfDeliver());
		
		if(realResult[1] <= 0) realResult[1] = 0;
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testExtendLoanTime() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(14, elem.getDayOfDeliver());
		
		elem.extendLoanTime();
		
		assertEquals(28, elem.getDayOfDeliver());
	}

	@Test
	public void testGetDayOfDeliver() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(14, elem.getDayOfDeliver());
	}

	@Test
	public void testSetDayOfDeliver() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(14, elem.getDayOfDeliver());
		
		elem.setDayOfDeliver(28);
		
		assertEquals(28, elem.getDayOfDeliver());
	}

	@Test
	public void testGetHourOfDeliver() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(23, elem.getHourOfDeliver());
	}

	@Test
	public void testGetMinuteOfDeliver() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(59, elem.getMinuteOfDeliver());
	}

	@Test
	public void testGetName() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("The Silmarillion", elem.getName());
	}

	@Test
	public void testSetName() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("The Silmarillion", elem.getName());
		
		elem.setName("The Hobbit");
		
		assertEquals("The Hobbit", elem.getName());
	}

	@Test
	public void testGetGenre() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("Novel", elem.getGenre());
	}

	@Test
	public void testSetGenre() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("Novel", elem.getGenre());
		
		elem.setGenre("Fantastic literature");
		
		assertEquals("Fantastic literature", elem.getGenre());
	}

	@Test
	public void testGetPublicationMonth() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("Septiembre", elem.getPublicationMonth());
	}

	@Test
	public void testSetPublicationMonth() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("Septiembre", elem.getPublicationMonth());
		
		elem.setPublicationMonth("November");
		
		assertEquals("November", elem.getPublicationMonth());
	}

	@Test
	public void testGetPublicationDay() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(15, elem.getPublicationDay());
	}

	@Test
	public void testSetPublicationDay() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(15, elem.getPublicationDay());
		
		elem.setPublicationDay(17);
		
		assertEquals(17, elem.getPublicationDay());
	}

	@Test
	public void testGetPublicationYear() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(1977, elem.getPublicationYear());
	}

	@Test
	public void testSetPublicationYear() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(1977, elem.getPublicationYear());
		
		elem.setPublicationYear(1999);
		
		assertEquals(1999, elem.getPublicationYear());
	}

	@Test
	public void testGetDayOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), elem.getDayOfLoan());
	}

	@Test
	public void testSetDayOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), elem.getDayOfLoan());
		
		elem.setDayOfLoan(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);
		
		assertEquals(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1, elem.getDayOfLoan());
	}

	@Test
	public void testGetMonthOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.MONTH) + 1, elem.getMonthOfLoan());
	}

	@Test
	public void testSetMonthOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.MONTH) + 1, elem.getMonthOfLoan());
		
		elem.setMonthOfLoan(Calendar.getInstance().get(Calendar.MONTH) + 2);
		
		assertEquals(Calendar.getInstance().get(Calendar.MONTH) + 2, elem.getMonthOfLoan());
	}

	@Test
	public void testGetYearOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), elem.getYearOfLoan());
	}

	@Test
	public void testSetYearOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), elem.getYearOfLoan());
		
		elem.setYearOfLoan(Calendar.getInstance().get(Calendar.YEAR) + 1);
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR) + 1, elem.getYearOfLoan());
	}

	@Test
	public void testGetHourOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.HOUR), elem.getHourOfLoan());
	}

	@Test
	public void testSetHourOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.HOUR), elem.getHourOfLoan());
		
		elem.setHourOfLoan(Calendar.getInstance().get(Calendar.HOUR) + 1);
		
		assertEquals(Calendar.getInstance().get(Calendar.HOUR) + 1, elem.getHourOfLoan());
	}

	@Test
	public void testGetMinuteOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.MINUTE), elem.getMinuteOfLoan());
	}

	@Test
	public void testSetMinuteOfLoan() {
		ObjectsOnLoan elem = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(Calendar.getInstance().get(Calendar.MINUTE), elem.getMinuteOfLoan());
		
		elem.setMinuteOfLoan(Calendar.getInstance().get(Calendar.MINUTE) + 1);
		
		assertEquals(Calendar.getInstance().get(Calendar.MINUTE) + 1, elem.getMinuteOfLoan());
	}
}
