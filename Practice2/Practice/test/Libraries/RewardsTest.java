package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RewardsTest {
	
	@Test
	public void testGetValue() {
		Rewards<Integer> reward = new Rewards<Integer>(1);
		
		assertEquals(1, reward.getValue());
	}

	@Test
	public void testSetValue() {
		Rewards<Integer> reward = new Rewards<Integer>(1);
		
		assertEquals(1, reward.getValue());
		
		reward.setValue(2);
		
		assertEquals(2, reward.getValue());
	}
}
