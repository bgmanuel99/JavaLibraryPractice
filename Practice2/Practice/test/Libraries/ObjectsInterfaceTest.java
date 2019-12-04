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
		
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 14;
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int totalDays = 0, totalMonths = 0, totalYears = 0;
		
		if(day > 31) {
			totalDays = day - 31;
			totalMonths += 1;
		}else {
			totalDays = day;
		}
		
		if((month + totalMonths) > 12) {
			totalYears += 1;
			totalMonths = 1;
		}else {
			totalMonths += month;
		}
		
		year += totalYears;
		
		int [] expectedResult = {totalDays,totalMonths,year};
		
		assertArrayEquals(expectedResult, instance.dateOfDeliver());
	}
	
	@Test
	public final void testTimeToDeliver1() {
		ObjectsInterface instance = createInstance();
		int [] expectedResult = {14,0,0};
		int [] realResult = instance.timeToDeliver(instance.dateOfDeliver());
		
		if(realResult[1] <= 0) realResult[1] = 0;
		
		assertArrayEquals(expectedResult, realResult);
	}
}