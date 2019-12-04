package Libraries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Libraries.LoanObjects;

class LoanObjectsTest {
	
	@Test
	public void testLoan() {
		LoanObjects loanObject = new Book(null, 0, null, 0, null, 0, 3, null, 0, null);
		
		loanObject.loan();
		
		assertEquals(2, loanObject.getStock());
	}
	
	@Test
	public void testReturnLoan() {
		LoanObjects loanObject = new Book(null, 0, null, 0, null, 0, 2, null, 0, null);
		
		loanObject.returnLoan();
		
		assertEquals(3, loanObject.getStock());
	}
	
	@Test
	public void testGetGenre() {
		LoanObjects loanObject = new Book(null, 0, null, 0, "novel", 0, 3, null, 0, null);
		
		assertEquals("novel", loanObject.getGenre());
	}
	
	@Test
	public void testSetGenre() {
		LoanObjects loanObject = new Book(null, 0, null, 0, "Fantastic literature", 0, 3, null, 0, null);
		
		assertEquals("Fantastic literature", loanObject.getGenre());
		
		loanObject.setGenre("novel");
		
		assertEquals("novel", loanObject.getGenre());
	}

	@Test
	public void testGetLoanTime() {
		LoanObjects loanObject = new Book(null, 0, null, 0, null, 2, 3, null, 0, null);
		
		assertEquals(2, loanObject.getLoanTime());
	}
	
	@Test
	public void testSetLoanTime() {
		LoanObjects loanObject = new Book(null, 0, null, 0, null, 0, 3, null, 0, null);
		
		assertEquals(0, loanObject.getLoanTime());
		
		loanObject.setLoanTime(2);
		
		assertEquals(2, loanObject.getLoanTime());
	}

	@Test
	public void testGetStock() {
		LoanObjects loanObject = new Book(null, 0, null, 0, null, 0, 3, null, 0, null);
		
		assertEquals(3, loanObject.getStock());
	}
	
	@Test
	public void testSetStock() {
		LoanObjects loanObject = new Book(null, 0, null, 0, null, 0, 3, null, 0, null);
		
		assertEquals(3, loanObject.getStock());
		
		loanObject.setStock(4);
		
		assertEquals(4, loanObject.getStock());
	}

	@Test
	public void testGetName() {
		LoanObjects loanObject = new Book("The Silmarillion", 0, null, 0, null, 0, 3, null, 0, null);
		
		assertEquals("The Silmarillion", loanObject.getName());
	}
	
	@Test
	public void testSetName() {
		LoanObjects loanObject = new Book("The Silmarillion", 0, null, 0, null, 0, 3, null, 0, null);
		
		assertEquals("The Silmarillion", loanObject.getName());
		
		loanObject.setName("The Hobbit");
		
		assertEquals("The Hobbit", loanObject.getName());
	}

	@Test
	public void testGetPublicationDay() {
		LoanObjects loanObject = new Book(null, 13, null, 0, null, 0, 3, null, 0, null);
		
		assertEquals(13, loanObject.getPublicationDay());
	}
	
	@Test
	public void testSetPublicationDay() {
		LoanObjects loanObject = new Book(null, 13, null, 0, null, 0, 3, null, 0, null);
		
		assertEquals(13, loanObject.getPublicationDay());
		
		loanObject.setPublicationDay(14);
		
		assertEquals(14, loanObject.getPublicationDay());
	}

	@Test
	public void testGetPublicationMonth() {
		LoanObjects loanObject = new Book(null, 0, "September", 0, null, 0, 3, null, 0, null);
		
		assertEquals("September", loanObject.getPublicationMonth());
	}
	
	@Test
	public void testSetPublicationMonth() {
		LoanObjects loanObject = new Book(null, 0, "September", 0, null, 0, 3, null, 0, null);
		
		assertEquals("September", loanObject.getPublicationMonth());
		
		loanObject.setPublicationMonth("November");
		
		assertEquals("November", loanObject.getPublicationMonth());
	}

	@Test
	public void testGetPublicationYear() {
		LoanObjects loanObject = new Book(null, 0, null, 1999, null, 0, 3, null, 0, null);
		
		assertEquals(1999, loanObject.getPublicationYear());
	}
	
	@Test
	public void testSetPublicationYear() {
		LoanObjects loanObject = new Book(null, 0, null, 1999, null, 0, 3, null, 0, null);
		
		assertEquals(1999, loanObject.getPublicationYear());
		
		loanObject.setPublicationYear(2002);
		
		assertEquals(2002, loanObject.getPublicationYear());
	}
}
