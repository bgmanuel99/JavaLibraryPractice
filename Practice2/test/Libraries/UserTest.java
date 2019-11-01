package Libraries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Libraries.User;

class UserTest {
	
	@Test
	public void testUserAge() {		
		User user = new User("Manuel", "Barrenechea", "02755013G", 17, 11, 1999, "Male", "bgmanuel1999@gmail.com", "gameOfThrones");
		
		int expectedResult = 19;
		int realResult = user.userAge();
		
		assertEquals(expectedResult, realResult);
	}
}
