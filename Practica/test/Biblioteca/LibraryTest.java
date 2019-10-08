package Biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class LibraryTest {
	
	@Test
	public void testGetNumberInStock() {
		Library test = new Library();
		test.addBook(new Book("El Silmarillion", "JRR Martin", 14, 3));
		
		int realResult = test.getNumberInStock("El Silmarillion");
		int expectedResult = 3;
		
		assertEquals(expectedResult, realResult, 0.01);
	}

	@Test
	public void testSearchBookByName() {
		Library test = new Library();
		test.addBook(new Book("El Silmarillion", "JRR Martin", 14, 3));
		
		assertTrue(test.searchBookByName("El Silmarillion"));
	}
	
	@Test
	public void testSearchBookByAuthor() {
		Library test = new Library();
		test.addBook(new Book("El Silmarillion", "JRR Martin", 14, 3));
		
		assertTrue(test.searchBookByAuthor("JRR Martin"));
	}
	
	@Test
	public void testMakeALoan() {
		Library test = new Library();
		test.addBook(new Book("El Silmarillion", "JRR Martin", 14, 3));
		
		Vector<Book> books = test.getBooks();
		String book = "El Silmarillion";
		int realResult = 0;
		
		test.makeALoan(book);
		
		for(Book elem : books) {
			if(elem.getBookName().equalsIgnoreCase(book)) {
				realResult = elem.getStock();
			}
		}
		int expectedResult = 2;
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testSearchUser() {
		Library test = new Library();
		test.addUser(new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones"));
		
		String email = "bgmanuel1999@gmail.com";
		String password = "gameOfThrones";
		Vector<User> users = test.getUsers();
		User expectedResult = new User("", "", "", 0, 0, 0, "", "", "");
		
		User realResult = test.searchUser(email, password);
		
		for(User elem : users) {
			if(elem.getEmail().equalsIgnoreCase(email) && elem.getPassword().equalsIgnoreCase(password)) {
				expectedResult = elem;
			}
		}
		
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
		
		test.userEdition(true, false, false, "Manu", null, null, "02755013G");
		
		String realResult = user.getFirstName();
		String expectedResult = "Manu";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition2() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, true, false, null, "Gonzalez", null, "02755013G");
		
		String realResult = user.getLastName();
		String expectedResult = "Gonzalez";
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testUserEdition3() {
		Library test = new Library();
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		test.addUser(user);
		
		test.userEdition(false, false, true, null, null, "Female", "02755013G");
		
		String realResult = user.getSex();
		String expectedResult = "Female";
		
		assertEquals(expectedResult, realResult);
	}
}
