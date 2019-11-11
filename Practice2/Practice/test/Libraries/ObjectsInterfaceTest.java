package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

public abstract class ObjectsInterfaceTest {
	
	public abstract ObjectsInterface createInstance();
	
	@Test
	public final void testGetTimeOnLoan1() {
		ObjectsInterface instance = createInstance();
		int [] time = {0,0,0,1};
		assertArrayEquals(time, instance.getTimeOnLoan());
	}
	
	@Test
	public final void testOverpassedTime1() {
		ObjectsInterface instance = createInstance();
		boolean [] overpassedTime = instance.overPassedTime(instance.getTimeOnLoan());
		assertFalse(overpassedTime[0]);
	}
	
	@Test
	public final void testSanctions1() {
		ObjectsInterface instance = createInstance();
		int [] time = {0,7,0};
		assertEquals(8, instance.sanctions(time));
	}
	
	@Test
	public final void testDateOfDeliver1() {
		ObjectsInterface instance = createInstance();
		int [] expectedResult = {Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 14,11,2019};
		assertArrayEquals(expectedResult, instance.dateOfDeliver());
	}
	
	@Test
	public final void testTimeToDeliver1() {
		ObjectsInterface instance = createInstance();
		int [] expectedResult = {14,0,0};
		assertArrayEquals(expectedResult, instance.timeToDeliver(instance.dateOfDeliver()));
	}
}