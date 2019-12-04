package Libraries;

import java.util.ListIterator;
import java.util.Properties;
import java.util.Vector;

public class ShoppingBascket implements Runnable{
	
	private Vector<String> shoppingBasket;
	private Vector<Integer> prices;
	private static ShoppingBascket instance = null;
	private final int wait;
	private Library library;
	private Properties prop;
	
	public ShoppingBascket() {
		this.shoppingBasket = new Vector<String>();
		this.prices = new Vector<Integer>();
		this.wait = 500;
	}
	
	public void initilizeLibrary(Library library) {
		this.library = library;
	}
	
	public void initializeProperties(Properties prop) {
		this.prop = prop;
	}
	
	public void run() {
		try {
			int totalPrice = 0, product = 1;
			for(int i = 0; i < this.shoppingBasket.size(); i++) {
				totalPrice += this.prices.elementAt(i);
				System.out.println(this.prop.getProperty("Shopping_product") + product + ": " + this.shoppingBasket.elementAt(i) + ", " + this.prices.elementAt(i) + "€" + " ---> " + totalPrice + "€");
				product++;
				for(LoanObjects elem : this.library.getLoanObjects()) {
					if(elem.getName().equals(this.shoppingBasket.elementAt(i))) {
						elem.loan();
					}
				}
				Thread.sleep(this.wait);
			}
			
			System.out.println(this.prop.getProperty("Final_price") + totalPrice + "€");
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void printShoppingBasket(Properties prop) {
		ListIterator<String> iterator = this.shoppingBasket.listIterator();
		ListIterator<Integer> pricesIterator = this.prices.listIterator();
		int i = 1;
		
		while(iterator.hasNext()) {
			System.out.println(prop.getProperty("Shopping_product") + i + ": " + iterator.next() + ", " + prop.getProperty("Price") + pricesIterator.next());
			i++;
		}
	}
	
	public static synchronized ShoppingBascket getInstance() {
		if(instance == null) {
			instance = new ShoppingBascket();
		}
		
		return instance;
	}
	
	public void instanceToNull() {
		instance = null;
	}
	
	public void addProduct(String nameObject) {
		this.shoppingBasket.add(nameObject);
	}
	
	public void addPrice(int price) {
		this.prices.add(price);
	}

	public Vector<String> getShoppingBasket() {
		return shoppingBasket;
	}

	public void setShoppingBasket(Vector<String> shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	public Vector<Integer> getPrices() {
		return prices;
	}

	public void setPrices(Vector<Integer> prices) {
		this.prices = prices;
	}

	public int getWait() {
		return wait;
	}

	public Library getLibrary() {
		return library;
	}
	
	public ShoppingBascket getInstanceAtribute() {
		return this.instance;
	}

	public static void setInstance(ShoppingBascket instance) {
		ShoppingBascket.instance = instance;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
}
