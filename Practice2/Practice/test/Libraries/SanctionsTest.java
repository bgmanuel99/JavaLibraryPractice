package Libraries;

import static org.junit.jupiter.api.Assertions.*;

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
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 10, 11, 2019);
		
		user.addSanction(sanction);
		
		int [] expectedResult = {14,0,0};
		int [] realResult = user.getSanctions().get(0).timeToWithdrawn(user.getSanctions().get(0).dateOfWithdrawn());
		
		assertArrayEquals(expectedResult, realResult);
	}
}
