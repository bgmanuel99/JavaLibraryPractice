package Biblioteca;
import java.util.Vector;

public class Library {

	private Vector<Book> books = new Vector<Book>();
	private Vector<User> users = new Vector<User>();
	
	public void addBook(Book book) {
		books.addElement(book);
	}
	
	public boolean searchBookByName(String name) {
		for(Book elem : books) {
			if(elem.getBookName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean searchBookByAuthor(String author) {
		for(Book elem : books) {
			if(elem.getAuthor().equalsIgnoreCase(author)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * The method printBooks is an overcharged method, the first method prints all the books written by an
	 * author, which is passed as parameter, the next one prints all the books contained in the vector books.
	 */
	public void printBooks(String author) {
		for(Book elem : books) {
			if(elem.getAuthor().equalsIgnoreCase(author)) {
				System.out.println("- " + elem.getBookName());
			}
		}
	}
	
	public void printBooks() {
		for(Book elem : books) {
			System.out.println("-Book: " + elem.getBookName() + ", Author: " + elem.getAuthor() + ", in stock: " + elem.getStock());
		}
	}
	
	public void makeALoan(String book) {
		for(Book elem : books) {
			if(elem.getBookName().equalsIgnoreCase(book)) {
				elem.loan();
			}
		}
	}
	
	public int getNumberInStock(String bookName) {
		int stock = 0;
		for(Book elem : books) {
			if(elem.getBookName().equalsIgnoreCase(bookName)) {
				stock = elem.getStock();
			}
		}
		return stock;
	}
	
	public void addUser(User user) {
		users.addElement(user);
	}
	
	public User searchUser(String email, String password) {
		for(User elem : users) {
			if(elem.getEmail().equalsIgnoreCase(email) && elem.getPassword().equalsIgnoreCase(password)) {
				return elem;
			}
		}
		return null;
	}
	
	public boolean userIDAlreadyRegistered(String ID) {
		for(User elem : users) {
			if(elem.getID().equalsIgnoreCase(ID)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean userEmailAlreadyRegistered(String email) {
		for(User elem : users) {
			if(elem.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}
	
	public void dropOutUser(String email, String password) {
		for(int i=0; i < users.size(); i++) {
			if(users.elementAt(i).getEmail().equalsIgnoreCase(email) && users.elementAt(i).getPassword().equalsIgnoreCase(password)) {
				users.removeElementAt(i);
			}
		}
	}
	
	public void userEdition(boolean changeFirstName, boolean changeLastName, boolean changeSex, String newFirstName, String newLastName, String newSex, String ID) {
		for(User elem : users) {
			if(elem.getID().equalsIgnoreCase(ID)) {
				if(changeFirstName) elem.setFirstName(newFirstName);
				if(changeLastName) elem.setLastName(newLastName);
				if(changeSex) elem.setSex(newSex);
			}
		}
	}
	
	public boolean correctLogIn(String email, String password) {
		for(User elem : users) {
			if(elem.getEmail().equalsIgnoreCase(email) && elem.getPassword().equalsIgnoreCase(password)) {
				return true;
			}
		}
		return false;
	}
	
	public Vector<Book> getBooks() {
		return books;
	}
	public void setBooks(Vector<Book> books) {
		this.books = books;
	}
	public Vector<User> getUsers() {
		return users;
	}
	public void setUsers(Vector<User> users) {
		this.users = users;
	}
}
