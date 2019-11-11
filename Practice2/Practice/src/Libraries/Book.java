package Libraries;

import java.util.Properties;

public class Book extends LoanObjects{

	private String author, ISBN;
	private int numberOfPages;

	public Book(String name, int publicationDay, String publicationMonth, int publicationYear, String genre,
			    int loanTime, int stock, String author, int numberOfPages, String ISBN) {
		super(name, publicationDay, publicationMonth, publicationYear, genre, loanTime, stock);
		this.author = author;
		this.numberOfPages = numberOfPages;
		this.ISBN = ISBN;
	}
	
	public void printData(Properties prop) {
		System.out.println(prop.getProperty("Book_name") + super.getName());
		System.out.println(prop.getProperty("Book_author") + this.getAuthor());
		System.out.println(prop.getProperty("Book_publicationdate") + super.getPublicationDay() + " " + prop.getProperty("Book_publicationdate1") + super.getPublicationMonth() + " " + prop.getProperty("Book_publicationdate1") + super.getPublicationYear());
		System.out.println(prop.getProperty("Book_genre") + super.getGenre());
		System.out.println(prop.getProperty("Book_numberofpages") + this.getNumberOfPages());
		System.out.println(prop.getProperty("Book_loantime") + super.getLoanTime() + " " + prop.getProperty("Book_loantime1"));
		System.out.println(prop.getProperty("Book_stock") + super.getStock());
		System.out.println(prop.getProperty("Book_ISBN") + this.getISBN());
	}
	
	public void printAllData(Properties prop) {
		System.out.println(prop.getProperty("Book_name") + super.getName() + ", " + prop.getProperty("Book_author1") + this.getAuthor() + ", " + prop.getProperty("Book_stock1") + super.getStock());
	}
	
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String _author) {
		this.author = _author;
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
}
