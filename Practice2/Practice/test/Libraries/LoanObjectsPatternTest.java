package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class LoanObjectsPatternTest {
	
	//This tests are for the decorator pattern
	@Test
	public void testSoftBookCover() {
		LoanObjects elem = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		LoanObjects elemSoftCover = new SoftBookCover(elem, "soft cover");
		
		String expectedResult = "SoftBookCover";
		String realResult = elemSoftCover.getClass().getSimpleName();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testHardBookCover() {
		LoanObjects elem = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		LoanObjects elemHardCover = new HardBookCover(elem, "hard cover");
		
		String expectedResult = "HardBookCover";
		String realResult = elemHardCover.getClass().getSimpleName();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testPC() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		LoanObjects elem = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		LoanObjects elemPC = new PC(elem, "PC");
		
		String expectedResult = "PC";
		String realResult = elemPC.getClass().getSimpleName();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testXbox() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		LoanObjects elem = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		LoanObjects elemXbox = new Xbox(elem, "Xbox");
		
		String expectedResult = "Xbox";
		String realResult = elemXbox.getClass().getSimpleName();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetLoanObject() {
		LoanObjects elem = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		LoanObjectsPattern elemSoftCover = new SoftBookCover(elem, "soft cover");
		
		assertEquals(elem, elemSoftCover.getLoanObject());
	}

	@Test
	public void testSetLoanObject() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		LoanObjects elem1 = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		LoanObjects elem = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		LoanObjectsPattern elemSoftCover = new SoftBookCover(elem, "soft cover");
		
		assertEquals(elem, elemSoftCover.getLoanObject());
		
		elemSoftCover.setLoanObject(elem1);
		
		assertEquals(elem1, elemSoftCover.getLoanObject());
	}

	@Test
	public void testGetType() {
		LoanObjects elem = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		LoanObjectsPattern elemSoftCover = new SoftBookCover(elem, "soft cover");
		
		assertEquals("soft cover", elemSoftCover.getType());
	}

	@Test
	public void testSetType() {
		LoanObjects elem = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		LoanObjectsPattern elemSoftCover = new SoftBookCover(elem, "soft cover");
		
		assertEquals("soft cover", elemSoftCover.getType());
		
		elemSoftCover.setType("hard cover");
		
		assertEquals("hard cover", elemSoftCover.getType());
	}
}
