package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;
import Libraries.User;

class UserTest {

	@Test
	public void testUserAge() {		
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		int expectedResult = 19;
		int realResult = user.userAge();

		assertEquals(expectedResult, realResult);
	}

	@Test
	public void testFoundElem() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		user.addObjectOnLoan(new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844"));
		String item = "The Silmarillion";

		assertTrue(user.foundElem(item));
	}

	@Test
	public void testGetObjectOnLoan() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		String nameOfObject = "The Silmarillion";

		user.addObjectOnLoan(item);

		ObjectsOnLoan expectedResult = item;
		ObjectsOnLoan realResult = user.getObjectOnLoan(nameOfObject);

		assertEquals(expectedResult, realResult);
	}

	@Test
	public void testExtendLoanTime() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		
		user.extendLoanTime(item);
		
		int expectedResult = 28;
		int realResult = user.getObjectsOnLoan().get(0).getDayOfDeliver();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testExtendTwoTimes1() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		
		user.extendLoanTime(item);
		
		assertFalse(user.extendTwoTimes());
	}
	
	@Test
	public void testExtendTwoTimes2() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		
		user.extendLoanTime(item);
		user.extendLoanTime(item);
		
		assertTrue(user.extendTwoTimes());
	}
	
	@Test
	public void testLateLoan() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item1 = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item2 = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		user.addObjectOnLoan(item1);
		user.addObjectOnLoan(item2);
		
		Vector<Vector<ObjectsOnLoan>> allObjectsOnLoan = user.lateLoan();
		
		int expectedResult = 3;
		int realResult = allObjectsOnLoan.get(1).size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testAddSanction() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 17, 11, 1999);
		
		user.addSanction(sanction);
		
		int expectedResult = 1;
		int realResult = user.getSanctions().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testRemoveSanction() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 17, 11, 1999);
		Sanctions sanction1 = new Sanctions("The Hobbit", 14, 11, 11, 1999);
		
		user.addSanction(sanction);
		user.addSanction(sanction1);
		
		user.removeSanction(sanction1);
		
		int expectedResult = 1;
		int realResult = user.getSanctions().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testTotalAmountOfSanctions1() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 17, 11, 1999);
		Sanctions sanction1 = new Sanctions("The Hobbit", 14, 11, 11, 1999);
		Sanctions sanction2 = new Sanctions("Harry potter and the order of fenix", 8, 14, 1, 2005);
		
		user.addSanction(sanction);
		user.addSanction(sanction1);
		user.addSanction(sanction2);
		
		String expectedResult = "8 months and 28 days.";
		String realResult = user.totalAmountOfSanctions();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testTotalAmountOfSanctions2() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 17, 11, 1999);
		Sanctions sanction1 = new Sanctions("The Hobbit", 14, 11, 11, 1999);
		Sanctions sanction2 = new Sanctions("Harry potter and the order of fenix", 12, 14, 1, 2005);
		
		user.addSanction(sanction);
		user.addSanction(sanction1);
		user.addSanction(sanction2);
		
		String expectedResult = "1 years, 0 months, 28 days.";
		String realResult = user.totalAmountOfSanctions();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testRemoveAllObjectsOnLoan() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item1 = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item2 = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		user.addObjectOnLoan(item1);
		user.addObjectOnLoan(item2);
		
		user.removeAllObjectsOnLoan();
		
		int expectedResult = 0;
		int realResult = user.getObjectsOnLoan().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testAddObjectOnLoan() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		
		int expectedResult = 1;
		int realResult = user.getObjectsOnLoan().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testRemoveObjectOnLoan() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");

		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		
		user.removeObjectOnLoan(item);
		
		int expectedResult = 0;
		int realResult = user.getObjectsOnLoan().size();
		
		assertEquals(expectedResult, realResult);
	}
}
