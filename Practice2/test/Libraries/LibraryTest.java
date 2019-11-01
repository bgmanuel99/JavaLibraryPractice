package Libraries;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;
import org.junit.jupiter.api.Test;
import Libraries.Book;
import Libraries.Library;
import Libraries.User;

class LibraryTest {
	
	@Test
	public void testGetNumberInStock() {
		Library test = new Library();
		test.addBook(new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513"));
		
		int realResult = test.getNumberInStock("El Silmarillion");
		int expectedResult = 3;
		
		assertEquals(expectedResult, realResult, 0.01);
	}

	@Test
	public void testSearchBookByName() {
		Library test = new Library();
		test.addBook(new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513"));
		
		assertTrue(test.searchBookByName("El Silmarillion"));
	}
	
	@Test
	public void testSearchBookByAuthor() {
		Library test = new Library();
		test.addBook(new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513"));
		
		assertTrue(test.searchBookByAuthor("J.R.R. Tolkien"));
	}
	
	@Test
	public void testMakeALoan() {
		Library test = new Library();
		test.addBook(new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513"));
		
		Vector<LoanObjects> books = test.getBooks();
		String book = "El Silmarillion";
		int realResult = 0;
		
		test.makeALoan(book);
		
		for(LoanObjects elem : books) {
			if(elem.getName().equalsIgnoreCase(book)) {
				realResult = elem.getStock();
			}
		}
		
		int expectedResult = 2;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testSearchUser() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		String email = "bgmanuel1999@gmail.com";
		String password = "gameOfThrones";
		User expectedResult = user;
		
		User realResult = test.searchUser(email, password);
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserIDAlreadyRegistered() {
		Library test = new Library();
		test.addUser(new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones"));
		
		String ID = "02755013G";
		
		assertTrue(test.userIDAlreadyRegistered(ID));
	}
	
	@Test
	public void testUserEmailAlreadyRegistered() {
		Library test = new Library();
		test.addUser(new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones"));
		
		String email = "bgmanuel1999@gmail.com";
		
		assertTrue(test.userEmailAlreadyRegistered(email));
	}
	
	@Test
	public void testCorrectLogIn() {
		Library test = new Library();
		test.addUser(new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones"));
		
		String email = "bgmanuel1999@gmail.com";
		String password = "gameOfThrones";
		
		assertTrue(test.correctLogIn(email, password));
	}
	
	@Test
	public void testUserEdition1() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(true, false, false, false, false, "Manu", null, null, null, null, "02755013G");
		
		String realResult = user.getFirstName();
		String expectedResult = "Manu";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition2() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, true, false, false, false, null, "Gonzalez", null, null, null, "02755013G");
		
		String realResult = user.getLastName();
		String expectedResult = "Gonzalez";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition3() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, true, false, false, null, null, "Female", null, null, "02755013G");
		
		String realResult = user.getSex();
		String expectedResult = "Female";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition4() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, false, true, false, null, null, null, "bgmanuel99@gmail.com", null, "02755013G");
		
		String realResult = user.getEmail();
		String expectedResult = "bgmanuel99@gmail.com";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition5() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, false, false, true, null, null, null, null, "TheWitcher3", "02755013G");
		
		String realResult = user.getPassword();
		String expectedResult = "TheWitcher3";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testAddBookAndVideogames() {
		Library test = new Library();
		String object = "Book,The|Silmarillion,15,September,1977,novel,14,5,J.R.R.|Tolkien,365,9788475968513";
		test.addBookAndVideogames(object);
		Book book = test.getBook("The Silmarillion");
		
		Book realResult = test.getBook("The Silmarillion");
		Book expectedResult = book;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testAddBook() {
		Library test = new Library();
		test.addBook(new Book("The Silmarillion", 15, "September", 1997, "novel", 14, 5, "J.R.R. Tolkien", 365, "9788475968513"));
		
		int expectedResult = 1;
		int realResult = test.getBooks().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetBooks() {
		Library test = new Library();
		Book book = new Book("The Silmarillion", 15, "September", 1997, "novel", 14, 5, "J.R.R. Tolkien", 365, "9788475968513");
		test.addBook(book);
		
		Book expectedResult = book;
		Book realResult = test.getBook("The Silmarillion");
		
		assertEquals(expectedResult, realResult);
	}

	@Test
	public void testAddVideogame() {
		Library test = new Library();
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		test.addVideoGame(new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms));
		
		int expectedResult = 1;
		int realResult = test.getBooks().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testSearchVideogameByName() {
		Library test = new Library();
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		test.addVideoGame(new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms));
		
		assertTrue(test.searchVideogameByName("World of Warcraft"));
	}
	
	@Test
	public void testGetVideogame() {
		Library test = new Library();
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		test.addVideoGame(videogame);
		
		VideoGames expectedResult = videogame;
		VideoGames realResult = test.getVideogame("World of Warcraft");
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testAddUser() {
		Library test = new Library();
		test.addUser(new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones"));
		
		int expectedResult = 1;
		int realResult = test.getUsers().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testDropOutUser() {
		Library test = new Library();
		test.addUser(new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones"));
		
		test.dropOutUser("bgmanuel1999@gmail.com", "gameOfThrones");
		int expectedResult = 0;
		int realResult = test.getUsers().size();
		
		assertEquals(expectedResult, realResult);
	}
}
