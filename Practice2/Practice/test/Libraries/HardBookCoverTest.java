package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HardBookCoverTest {
	
	@Test
	public void testCharacteristics() {
		LoanObjects elem = new Book("El Silmarillion", 15, "Septiembre", 1977, "Novel", 2, 3, "J.R.R. Tolkien", 365, "9788475968513");
		LoanObjectsPattern elemHardCover = new HardBookCover(elem, "hard cover");
		
		assertEquals("hard cover", elemHardCover.characteristic());
	}
}
