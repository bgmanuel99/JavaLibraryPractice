package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class SanctionsTest {
	
	@Test
	public void testDateOfWithdrawn1() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
	
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 24, 11, 2019);
		
		user.addSanction(sanction);
		
		int [] expectedResult = {7,12,2019};
		int [] realResult = user.getSanctions().get(0).dateOfWithdrawn();
		
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testDateOfWithdrawn2() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Sanctions sanction = new Sanctions("The Silmarillion", 3, 10, 11, 2019);
		
		user.addSanction(sanction);
		
		int [] expectedResult = {10,2,2020};
		int [] realResult = user.getSanctions().get(0).dateOfWithdrawn();
		
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testTimeToWithdrawn() {
        User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		user.addSanction(sanction);
		
		int [] expectedResult = {14,0,0};
		int [] realResult = user.getSanctions().get(0).timeToWithdrawn(user.getSanctions().get(0).dateOfWithdrawn());

		if(realResult[1] <= 0) realResult[1] = 0;
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetReturnDay() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), sanction.getReturnDay());
	}

	@Test
	public void testSetReturnDay() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), sanction.getReturnDay());
		
		sanction.setReturnDay(12);
		
		assertEquals(12, sanction.getReturnDay());
	}

	@Test
	public void testGetReturnMonth() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals(Calendar.getInstance().get(Calendar.MONTH) + 1, sanction.getReturnMonth());
	}

	@Test
	public void testSetReturnMonth() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals(Calendar.getInstance().get(Calendar.MONTH) + 1, sanction.getReturnMonth());
		
		sanction.setReturnMonth(11);
		
		assertEquals(11, sanction.getReturnMonth());
	}

	@Test
	public void testGetReturnYear() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), sanction.getReturnYear());
	}

	@Test
	public void testSetReturnYear() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), sanction.getReturnYear());
		
		sanction.setReturnYear(1999);
		
		assertEquals(1999, sanction.getReturnYear());
	}

	@Test
	public void testGetNameOfObject() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals("The Silmarillion", sanction.getNameOfObject());
	}

	@Test
	public void testSetNameOfObject() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals("The Silmarillion", sanction.getNameOfObject());
		
		sanction.setNameOfObject("The Hobbit");
		
		assertEquals("The Hobbit", sanction.getNameOfObject());
	}

	@Test
	public void testGetTimeOfSanction() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals(14, sanction.getTimeOfSanction());
	}

	@Test
	public void testSetTimeOfSanction() {
		Sanctions sanction = new Sanctions("The Silmarillion", 14, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.YEAR));
		
		assertEquals(14, sanction.getTimeOfSanction());
		
		sanction.setTimeOfSanction(28);
		
		assertEquals(28, sanction.getTimeOfSanction());
	}
}
