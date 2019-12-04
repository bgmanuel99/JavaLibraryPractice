package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {
	
	@Test
	public void testGetAuthor() {
		Book book = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		
		assertEquals("J.R.R. Tolkien", book.getAuthor());
	}
	
	@Test
	public void testSetAuthor() {
		Book book = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		
		assertEquals("J.R.R. Tolkien", book.getAuthor());
		
		book.setAuthor("J.R. Rowling");
		
		assertEquals("J.R. Rowling", book.getAuthor());
	}
	
	@Test
	public void testGetNumberOfPages() {
		Book book = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		
		assertEquals(365, book.getNumberOfPages());
	}
	
	@Test
	public void testSetNumberOfPages() {
		Book book = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		
		assertEquals(365, book.getNumberOfPages());
		
		book.setNumberOfPages(400);
		
		assertEquals(400, book.getNumberOfPages());
	}

	@Test
	public void testGetISBN() {
		Book book = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		
		assertEquals("9788475968513", book.getISBN());
	}
	
	@Test
	public void testSetISBN() {
		Book book = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		
		assertEquals("9788475968513", book.getISBN());
		
		book.setISBN("4566434465678");
		
		assertEquals("4566434465678", book.getISBN());
	}
}
