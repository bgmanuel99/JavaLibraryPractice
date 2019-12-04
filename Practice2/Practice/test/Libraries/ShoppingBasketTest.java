package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class ShoppingBasketTest implements Runnable{

	//This first test is for the singleton pattern

	@Test
	public void testGetInstance() {
		ShoppingBascket basket1, basket2;
		basket1 = ShoppingBascket.getInstance();
		basket1.getShoppingBasket().removeAllElements();
		
		basket1.addProduct("1");
		basket1.addProduct("2");

		assertEquals(2, basket1.getShoppingBasket().size());

		basket2 = ShoppingBascket.getInstance();

		basket2.addProduct("1");
		basket2.addProduct("2");

		assertEquals(4, basket2.getShoppingBasket().size());
		assertEquals(4, basket1.getShoppingBasket().size());
	}

	//This test is for the part of threads
	
	@Test
	public void run() {
		int count = 0;
		try {
			for(int i = 0; i < 5; i++) {
				count += 500;
				Thread.sleep(500);
			}
		}catch(InterruptedException e) {}
		
		assertEquals(2500, count);
	}
	
	//This last test is for the iterator pattern
	
	@Test
	public void testPrintShoppingBasket() {
		
		String [] lettersArray = {"a","b","c","d","e","f","g"};
		int [] numbersArray = {1,2,3,4,5,6,7,8,9,10};
		Vector<String> letters = new Vector<String>();
		Vector<Integer> numbers = new Vector<Integer>();
		for(String elem : lettersArray) {
			letters.add(elem);
		}
		for(int elem : numbersArray) {
			numbers.add(elem);
		}
		
		ListIterator<String> iteratorStrings = letters.listIterator();
		ListIterator<Integer> iteratorIntegers = numbers.listIterator();
		
		String iteratorStringForwards = "";
		String iteratorIntegerForwards = "";
		String iteratorStringBackwards = "";
		String iteratorIntegerBackwards = "";
		
		while(iteratorStrings.hasNext()) {
			iteratorStringForwards += iteratorStrings.next();
		}
		while(iteratorIntegers.hasNext()) {
			iteratorIntegerForwards += iteratorIntegers.next();
		}
		while(iteratorStrings.hasPrevious()) {
			iteratorStringBackwards += iteratorStrings.previous();
		}
		while(iteratorIntegers.hasPrevious()) {
			iteratorIntegerBackwards += iteratorIntegers.previous();
		}
		
		assertEquals("abcdefg", iteratorStringForwards);
		assertEquals("12345678910", iteratorIntegerForwards);
		assertEquals("gfedcba", iteratorStringBackwards);
		assertEquals("10987654321", iteratorIntegerBackwards);
	}
	
	@Test
	public void testInstanceToNull() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		assertTrue(basket.getInstanceAtribute() != null);
	}
	
	@Test
	public void testAddProduct() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		basket.addProduct("h");
		
		assertEquals(1, basket.getShoppingBasket().size());
	}
	
	@Test
	public void testAddPrice() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		basket.addPrice(2);
		
		assertEquals(1, basket.getPrices().size());
	}

	@Test
	public void testGetShoppingBasket() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		Vector<String> example = new Vector<String>();
		
		example.add("a");
		
		basket.setShoppingBasket(example);
		
		assertEquals(example, basket.getShoppingBasket());
	}

	@Test
	public void testSetShoppingBasket() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		Vector<String> example = new Vector<String>();
		Vector<String> example1 = new Vector<String>();
		
		example.add("a");
		example.add("b");
		
		basket.setShoppingBasket(example);
		
		assertEquals(example, basket.getShoppingBasket());
		
		basket.setShoppingBasket(example1);
		
		assertEquals(example1, basket.getShoppingBasket());
	}

	@Test
	public void testGetPrices() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		Vector<Integer> integers = new Vector<Integer>();
		
		integers.add(1);
		
		basket.setPrices(integers);
		
		assertEquals(integers, basket.getPrices());
	}

	@Test
	public void testSetPrices() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		Vector<Integer> integers = new Vector<Integer>();
		Vector<Integer> integers1 = new Vector<Integer>();
		
		integers.add(1);
		integers1.add(2);
		
		basket.setPrices(integers);
		
		assertEquals(integers, basket.getPrices());
		
		basket.setPrices(integers1);
		
		assertEquals(integers1, basket.getPrices());
	}

	@Test
	public void testGetWait() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		assertEquals(500, basket.getWait());
	}

	@Test
	public void testGetLibrary() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		Library test = new Library();
		
		basket.initilizeLibrary(test);
		
		assertEquals(test, basket.getLibrary());
	}

	@Test
	public void setInstance() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		assertTrue(basket.getInstanceAtribute() != null);
		
		basket.setInstance(null);
		
		assertTrue(basket.getInstanceAtribute() == null);
	}

	@Test
	public void testGetProp() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		Properties prop = new Properties();
		
		try {
			InputStream file = new FileInputStream("Labels.properties");
			prop.load(file);
		}catch(IOException e) {}
		
		basket.setProp(prop);
		
		assertEquals(prop, basket.getProp());
	}

	@Test
	public void testSetProp() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		Properties prop = new Properties();
		Properties prop1 = new Properties();
		
		try {
			InputStream file = new FileInputStream("Labels.properties");
			prop.load(file);
			
			InputStream file1 = new FileInputStream("Labels_es_ES.properties");
			prop1.load(file1);
		}catch(IOException e) {}
		
		basket.setProp(prop);
		
		assertEquals(prop, basket.getProp());
		
		basket.setProp(prop1);
		
		assertEquals(prop1, basket.getProp());
	}
	
	@Test
	public void testInitilizeLibrary() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		Library test = new Library();
		
		basket.initilizeLibrary(test);
		
		assertEquals(test, basket.getLibrary());
	}
	
	@Test
	public void testInitializeProperties() {
		ShoppingBascket basket = ShoppingBascket.getInstance();
		
		Properties prop = new Properties();
		
		try {
			InputStream file = new FileInputStream("Labels.properties");
			prop.load(file);
		}catch(IOException e) {}
		
		basket.initializeProperties(prop);
		
		assertEquals(prop, basket.getProp());
	}
}
