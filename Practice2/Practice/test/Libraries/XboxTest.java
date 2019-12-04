package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class XboxTest {

	@Test
	public void testCharacteristics() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		LoanObjects elem = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		LoanObjectsPattern elemXbox = new Xbox(elem, "Xbox");
		
		assertEquals("Xbox", elemXbox.characteristic());
	}
}
