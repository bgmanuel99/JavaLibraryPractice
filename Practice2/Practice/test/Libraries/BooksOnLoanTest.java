package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BooksOnLoanTest {
	
	@Test
	public void testGetAuthor() {
		BooksOnLoan book = new BooksOnLoan("El Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("J.R.R. Tolkien", book.getAuthor());
	}
	
	@Test
	public void testSetAuthor() {
		BooksOnLoan book = new BooksOnLoan("El Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("J.R.R. Tolkien", book.getAuthor());
		
		book.setAuthor("J.R. Rowling");
		
		assertEquals("J.R. Rowling", book.getAuthor());
	}
	
	@Test
	public void testGetNumberOfPages() {
		BooksOnLoan book = new BooksOnLoan("El Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(365, book.getNumberOfPages());
	}
	
	@Test
	public void testSetNumberOfPages() {
		BooksOnLoan book = new BooksOnLoan("El Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals(365, book.getNumberOfPages());
		
		book.setNumberOfPages(400);
		
		assertEquals(400, book.getNumberOfPages());
	}

	@Test
	public void testGetISBN() {
		BooksOnLoan book = new BooksOnLoan("El Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("9788475968513", book.getISBN());
	}
	
	@Test
	public void testSetISBN() {
		BooksOnLoan book = new BooksOnLoan("El Silmarillion", "J.R.R. Tolkien", 15, "Septiembre", 1977, "Novel", 365, "9788475968513");
		
		assertEquals("9788475968513", book.getISBN());
		
		book.setISBN("4566434465678");
		
		assertEquals("4566434465678", book.getISBN());
	}
}
