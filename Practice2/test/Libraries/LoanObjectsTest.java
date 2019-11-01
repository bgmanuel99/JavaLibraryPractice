package Libraries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Libraries.LoanObjects;

class LoanObjectsTest {
	
	@Test
	public void testLoan() {
		LoanObjects loanObject = new Book(null, 0, null, 0, null, 0, 3, null, 0, null);
		
		int expectedResult = 2;
		loanObject.loan();
		int realResult = loanObject.getStock();
		
		assertEquals(expectedResult, realResult);
	}
}
