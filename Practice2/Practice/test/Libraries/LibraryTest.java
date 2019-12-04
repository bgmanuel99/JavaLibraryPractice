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
		
		assertTrue(test.searchLoanObjectsByName("El Silmarillion"));
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
		
		Vector<LoanObjects> books = test.getLoanObjects();
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
		
		test.userEdition(true, false, false, false, false, false, false, false, "Manu", null, null, null, null, 0, 0, 0, user);
		
		String realResult = user.getFirstName();
		String expectedResult = "Manu";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition2() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, true, false, false, false, false, false, false, null, "Gonzalez", null, null, null, 0, 0, 0, user);
		
		String realResult = user.getLastName();
		String expectedResult = "Gonzalez";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition3() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, true, false, false, false, false, false, null, null, "Female", null, null, 0, 0, 0, user);
		
		String realResult = user.getSex();
		String expectedResult = "Female";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition4() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, false, true, false, false, false, false, null, null, null, "bgmanuel99@gmail.com", null, 0, 0, 0, user);
		
		String realResult = user.getEmail();
		String expectedResult = "bgmanuel99@gmail.com";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition5() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, false, false, true, false, false, false, null, null, null, null, "TheWitcher3", 0, 0, 0, user);
		
		String realResult = user.getPassword();
		String expectedResult = "TheWitcher3";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition6() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, false, false, false, true, false, false, null, null, null, null, null, 1, 0, 0, user);
		
		int realResult = user.getBirthDay();
		int expectedResult = 1;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition7() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, false, false, false, false, true, false, null, null, null, null, null, 0, 4, 0, user);
		
		int realResult = user.getBirthMonth();
		int expectedResult = 4;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition8() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, false, false, false, false, false, true, null, null, null, null, null, 0, 0, 2000, user);
		
		int realResult = user.getBirthYear();
		int expectedResult = 2000;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testAddBookAndVideogames1() {
		Library test = new Library();
		String object = "Book,The|Silmarillion,15,September,1977,novel,14,5,J.R.R.|Tolkien,365,9788475968513";
		test.addBookAndVideogames(object);
		
		assertTrue(test.searchLoanObjectsByName("The Silmarillion"));
	}
	
	@Test
	public void testAddBookAndVideogames2() {
		Library test = new Library();
		String object = "Videogame,World|of|Warcraft,23,November,2004,Rol,14,5,Massively|multiplayer|online,8.2.4,Tracy|W.|Bush;,Blizzard|Entertainment;,Windows;Mac|OS|X;";
		test.addBookAndVideogames(object);
		
		assertTrue(test.searchLoanObjectsByName("World of Warcraft"));
	}
	
	@Test
	public void testAddBook() {
		Library test = new Library();
		test.addBook(new Book("The Silmarillion", 15, "September", 1997, "novel", 14, 5, "J.R.R. Tolkien", 365, "9788475968513"));
		
		int expectedResult = 1;
		int realResult = test.getLoanObjects().size();
		
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
		int realResult = test.getLoanObjects().size();
		
		assertEquals(expectedResult, realResult);
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
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.dropOutUser(user);
		int expectedResult = 0;
		int realResult = test.getUsers().size();
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testGetLoanObjects() {
		Library test = new Library();
		Book book = new Book("The Silmarillion", 15, "September", 1997, "novel", 14, 5, "J.R.R. Tolkien", 365, "9788475968513");
		
		Vector<LoanObjects> loanObjects = new Vector<LoanObjects>();
		
		loanObjects.add(book);
		
		test.addBook(book);
		
		assertEquals(loanObjects, test.getLoanObjects());
	}
	
	@Test
	public void testSetLoanOBjects() {
		Library test = new Library();
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		Book book = new Book("The Silmarillion", 15, "September", 1997, "novel", 14, 5, "J.R.R. Tolkien", 365, "9788475968513");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		Vector<LoanObjects> loanObjects = new Vector<LoanObjects>();
		Vector<LoanObjects> loanObjects1 = new Vector<LoanObjects>();
		
		loanObjects.add(book);
		loanObjects1.add(videogame);
		loanObjects1.add(book);
		
		test.addBook(book);
		
		assertEquals(loanObjects, test.getLoanObjects());
		
		test.setLoanOBjects(loanObjects1);
		
		assertEquals(loanObjects1, test.getLoanObjects());
	}
	
	@Test
	public void testGetUsers() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Vector<User> users = new Vector<User>();
		users.add(user);
		
		test.addUser(user);
		
		assertEquals(users, test.getUsers());
	}
	
	@Test
	public void testSetUsers() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		User user1 = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		Vector<User> users = new Vector<User>();
		Vector<User> users1 = new Vector<User>();
		
		users.add(user);
		test.addUser(user);
		
		users1.add(user);
		users1.add(user1);
		
		assertEquals(users, test.getUsers());
		
		test.setUsers(users1);
		
		assertEquals(users1, test.getUsers());
	}
	
	@Test
	public void testReturnLoanObject1() {
		Library test = new Library();
		Book book = new Book("The Silmarillion", 15, "September", 1997, "novel", 14, 5, "J.R.R. Tolkien", 365, "9788475968513");

		test.addBook(book);
		test.returnLoanObject(book);
		
		assertEquals(6, test.getLoanObjects().get(0).getStock());
	}
	
	@Test
	public void testReturnLoanObjects2() {
		Library test = new Library();
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);

		test.addVideoGame(videogame);
		test.returnLoanObject(videogame);
		
		assertEquals(6, test.getLoanObjects().get(0).getStock());
	}
	
	@Test
	public void testReturnLoanObjects3() {
		Library test = new Library();
		Book book = new Book("The Silmarillion", 15, "September", 1997, "novel", 14, 5, "J.R.R. Tolkien", 365, "9788475968513");
		LoanObjects book1 = book;

		test.addBook(book);
		test.returnLoanObject(book1);
		
		assertEquals(6, test.getLoanObjects().get(0).getStock());
	}
	
	@Test
	public void testGetLoanObject() {
		Library test = new Library();
		Book book = new Book("The Silmarillion", 15, "September", 1997, "novel", 14, 5, "J.R.R. Tolkien", 365, "9788475968513");
		
		test.addBook(book);
		
		assertEquals(book, test.getLoanObject("The Silmarillion"));
	}
}
