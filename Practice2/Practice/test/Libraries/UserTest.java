package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
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
		Sanctions sanction2 = new Sanctions("Time History", 14, 5, 4, 1999);
		Sanctions sanction3 = new Sanctions("Harry potter and the order of fenix", 8, 14, 1, 2005);
		Sanctions sanction4 = new Sanctions("Harry potter and the half blood prince", 5, 2, 7, 2006);
		
		user.addSanction(sanction);
		user.addSanction(sanction1);
		user.addSanction(sanction2);
		user.addSanction(sanction3);
		user.addSanction(sanction4);
		
		String expectedResult = "1 years, 2 months, 11 days.";
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
	
	@Test
	public void testTotalDaysRegistered() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		int [] expectedResult = {0,0,0,1};
		int [] realResult = user.totalDaysRegistered();
		
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testTimeToDays() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		int [] time = {5,2,1};
		
		int expectedResult = 432;
		int realResult = user.timeToDays(time);
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testBubbeSort() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		int [] example = {2,4,7,3,1};
		
		int [] expectedResult = {1,2,3,4,7};
		int [] realResult = user.bubbleSort(example);
		
		assertArrayEquals(expectedResult, realResult);
	}
	
	@Test
	public void testAddReward() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Rewards<Integer> reward = new Rewards<Integer>(1);
		Rewards<Integer> reward1 = new Rewards<Integer>(1);
		Rewards<String> reward2 = new Rewards<String>("h");
		
		user.addReward(reward);
		user.addReward(reward1);
		user.addReward(reward2);
		
		int expectedResult = 3;
		int realResult = user.getRewards().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testSeparateRewards1() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Rewards<Integer> reward = new Rewards<Integer>(1);
		Rewards<Integer> reward1 = new Rewards<Integer>(1);
		Rewards<String> reward2 = new Rewards<String>("h");
		
		user.addReward(reward);
		user.addReward(reward1);
		user.addReward(reward2);
		
		Vector<Vector<Rewards>> rewards = user.separateRewards();
		
		int expectedResult = 2;
		int realResult = rewards.elementAt(0).size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testSeparateRewards2() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Rewards<Integer> reward = new Rewards<Integer>(1);
		Rewards<Integer> reward1 = new Rewards<Integer>(1);
		Rewards<String> reward2 = new Rewards<String>("h");
		
		user.addReward(reward);
		user.addReward(reward1);
		user.addReward(reward2);
		
		Vector<Vector<Rewards>> rewards = user.separateRewards();
		
		int expectedResult = 1;
		int realResult = rewards.elementAt(1).size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetRewards() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		Vector<Rewards> rewards = new Vector<Rewards>();
		
		Rewards<Integer> reward = new Rewards<Integer>(1);
		Rewards<Integer> reward1 = new Rewards<Integer>(1);
		Rewards<String> reward2 = new Rewards<String>("h");
		
		user.addReward(reward);
		user.addReward(reward1);
		user.addReward(reward2);
		rewards.add(reward);
		rewards.add(reward1);
		rewards.add(reward2);
		
		assertEquals(rewards, user.getRewards());
	}

	@Test
	public void testSetRewards() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		Vector<Rewards> rewards = new Vector<Rewards>();
		Vector<Rewards> rewards1 = new Vector<Rewards>();
		
		Rewards<Integer> reward = new Rewards<Integer>(1);
		Rewards<Integer> reward1 = new Rewards<Integer>(1);
		Rewards<String> reward2 = new Rewards<String>("h");
		Rewards<Integer> reward3 = new Rewards<Integer>(2);
		Rewards<Integer> reward4 = new Rewards<Integer>(2);
		Rewards<String> reward5 = new Rewards<String>("r");
		
		user.addReward(reward);
		user.addReward(reward1);
		user.addReward(reward2);
		rewards.add(reward);
		rewards.add(reward1);
		rewards.add(reward2);
		
		assertEquals(rewards, user.getRewards());
		
		rewards1.add(reward3);
		rewards1.add(reward4);
		rewards1.add(reward5);
		
		user.setRewards(rewards1);
		
		assertEquals(rewards1, user.getRewards());
	}

	@Test
	public void testGetSanctions() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		Vector<Sanctions> sanctions = new Vector<Sanctions>();
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 17, 11, 1999);
		Sanctions sanction1 = new Sanctions("The Hobbit", 14, 11, 11, 1999);
		Sanctions sanction2 = new Sanctions("Harry potter and the order of fenix", 12, 14, 1, 2005);
		
		user.addSanction(sanction);
		user.addSanction(sanction1);
		user.addSanction(sanction2);
		sanctions.add(sanction);
		sanctions.add(sanction1);
		sanctions.add(sanction2);
		
		assertEquals(sanctions, user.getSanctions());
	}

	@Test
	public void testSetSanctions() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		Vector<Sanctions> sanctions = new Vector<Sanctions>();
		Vector<Sanctions> sanctions1 = new Vector<Sanctions>();
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 17, 11, 1999);
		Sanctions sanction1 = new Sanctions("The Hobbit", 14, 11, 11, 1999);
		Sanctions sanction2 = new Sanctions("Harry potter and the order of fenix", 12, 14, 1, 2005);
		Sanctions sanction3 = new Sanctions("The Silmarillion", 14, 17, 11, 1909);
		Sanctions sanction4 = new Sanctions("The Hobbit", 8, 24, 11, 1999);
		Sanctions sanction5 = new Sanctions("Harry potter and the prisioner of azkaban", 12, 14, 1, 2005);
		
		user.addSanction(sanction);
		user.addSanction(sanction1);
		user.addSanction(sanction2);
		sanctions.add(sanction);
		sanctions.add(sanction1);
		sanctions.add(sanction2);
		sanctions1.add(sanction3);
		sanctions1.add(sanction4);
		sanctions1.add(sanction5);
		
		assertEquals(sanctions, user.getSanctions());
		
		user.setSanctions(sanctions1);
		
		assertEquals(sanctions1, user.getSanctions());
	}

	@Test
	public void testGetExtendLoanTime() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		boolean [] extendLoanTime = new boolean[] {false, false};
		
		user.setExtendLoanTime(extendLoanTime);
		
		assertEquals(extendLoanTime, user.getExtendLoanTime());
	}

	@Test
	public void testSetExtendLoanTime() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		boolean [] extendLoanTime = new boolean[] {false, false};
		boolean [] extendLoanTime1 = new boolean [] {true, false};
		
		user.setExtendLoanTime(extendLoanTime);
		
		assertEquals(extendLoanTime, user.getExtendLoanTime());
		
		user.setExtendLoanTime(extendLoanTime1);
		
		assertEquals(extendLoanTime1, user.getExtendLoanTime());
	}

	@Test
	public void testGetObjectsOnLoan() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		Vector<ObjectsOnLoan> items = new Vector<ObjectsOnLoan>();
		
		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item1 = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item2 = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		user.addObjectOnLoan(item1);
		user.addObjectOnLoan(item2);
		items.add(item);
		items.add(item1);
		items.add(item2);
		
		assertEquals(items, user.getObjectsOnLoan());
	}

	@Test
	public void testSetObjectsOnLoan() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		Vector<ObjectsOnLoan> items = new Vector<ObjectsOnLoan>();
		Vector<ObjectsOnLoan> items1 = new Vector<ObjectsOnLoan>();
		
		ObjectsOnLoan item = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item1 = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item2 = new BooksOnLoan("The Silmarillion", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item3 = new BooksOnLoan("The Hobbit", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item4 = new BooksOnLoan("The Hobbit", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		ObjectsOnLoan item5 = new BooksOnLoan("The Hobbit", "J.R.R. Tolkien", 15, "February", 1999, "Fantasy", 455, "92837498373844");
		
		user.addObjectOnLoan(item);
		user.addObjectOnLoan(item1);
		user.addObjectOnLoan(item2);
		items.add(item);
		items.add(item1);
		items.add(item2);
		items1.add(item3);
		items1.add(item4);
		items1.add(item5);
		
		assertEquals(items, user.getObjectsOnLoan());
		
		user.setObjectsOnLoan(items1);
		
		assertEquals(items1, user.getObjectsOnLoan());
	}

	@Test
	public void testGetPassword() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("gameOfThrones", user.getPassword());
	}
	
	@Test
	public void testSetPassword() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("gameOfThrones", user.getPassword());
		
		user.setPassword("h");
		
		assertEquals("h", user.getPassword());
	}

	@Test
	public void testGetEmail() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("bgmanuel1999@gmail.com", user.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("bgmanuel1999@gmail.com", user.getEmail());
		
		user.setEmail("a");
		
		assertEquals("a", user.getEmail());
	}

	@Test
	public void testGetBirthDay() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(17, user.getBirthDay());
	}
	
	@Test
	public void testSetBirthDay() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(17, user.getBirthDay());
		
		user.setBirthDay(11);
		
		assertEquals(11, user.getBirthDay());
	}

	@Test
	public void testGetBirthMonth() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(11, user.getBirthMonth());
	}
	
	@Test
	public void testSetBirthMonth() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(11, user.getBirthMonth());
		
		user.setBirthMonth(8);
		
		assertEquals(8, user.getBirthMonth());
	}

	@Test
	public void testGetBirthYear() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(1999, user.getBirthYear());
	}
	
	@Test
	public void testSetBirthYear() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(1999, user.getBirthYear());
		
		user.setBirthYear(2002);
		
		assertEquals(2002, user.getBirthYear());
	}

	@Test
	public void testGetSex() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("Male", user.getSex());
	}
	
	@Test
	public void testSetSex() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("Male", user.getSex());
		
		user.setSex("Female");
		
		assertEquals("Female", user.getSex());
	}

	@Test
	public void testGetID() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("02755013G", user.getID());
	}
	
	@Test
	public void testSetID() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("02755013G", user.getID());
		
		user.setID("f");
		
		assertEquals("f", user.getID());
	}

	@Test
	public void testGetFirstName() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("Manuel", user.getFirstName());
	}
	
	@Test
	public void testSetFirstName() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("Manuel", user.getFirstName());
		
		user.setFirstName("m");
		
		assertEquals("m", user.getFirstName());
	}

	@Test
	public void testGetLastName() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("Barrenechea", user.getLastName());
	}
	
	@Test
	public void testSetLastName() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals("Barrenechea", user.getLastName());
		
		user.setLastName("Gonzalez");
		
		assertEquals("Gonzalez", user.getLastName());
	}

	@Test
	public void testGetRewardArray() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(user.getRewardArray(), user.getRewardArray());
	}
	
	@Test
	public void testGetDayOfRegister() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), user.getDayOfRegister());
	}

	@Test
	public void testSetDayOfRegister() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), user.getDayOfRegister());
		
		user.setDayOfRegister(0);
		
		assertEquals(0, user.getDayOfRegister());
	}

	@Test
	public void testGetMonthOfRegister() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(Calendar.getInstance().get(Calendar.MONTH) + 1, user.getMonthOfRegister());
	}

	@Test
	public void testSetMonthOfRegister() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(Calendar.getInstance().get(Calendar.MONTH) + 1, user.getMonthOfRegister());
		
		user.setMonthOfRegister(13);
		
		assertEquals(13, user.getMonthOfRegister());
	}

	@Test
	public void testGetYearOfRegister() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), user.getYearOfRegister());
	}

	@Test
	public void testSetYearOfRegister() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), user.getYearOfRegister());
		
		user.setYearOfRegister(20000);
		
		assertEquals(20000, user.getYearOfRegister());
	}
	
	@Test
	public void testRemoveReward() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Rewards<Integer> reward = new Rewards<Integer>(1);
		
		user.addReward(reward);
		
		assertEquals(1, user.getRewards().size());
		
		user.removeReward(reward);
		
		assertEquals(0, user.getRewards().size());
	}
	
	@Test
	public void testExtendRewardObjectsTime() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		ObjectsOnLoan item = new BooksOnLoan("El Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		user.addObjectOnLoan(item);
		
		user.extendRewardObjectsTime(item.getName());
		
		assertEquals(28, user.getObjectsOnLoan().get(0).getDayOfDeliver());
	}
	
	@Test
	public void testUseIntegerRewards() {
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Sanctions sanction = new Sanctions("The Silmarillion", 14, 17, 11, 1999);
		
		Rewards<Integer> reward = new Rewards<Integer>(1);
		
		user.addReward(reward);
		user.addSanction(sanction);
		
		assertEquals(1, user.getRewards().size());
		
		user.useIntegerRewards(user.getRewards());
		
		assertEquals(0, user.getRewards().size());
	}
}