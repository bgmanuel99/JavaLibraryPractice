package Libraries;

import java.util.Calendar;
import java.util.Properties;

public class BooksOnLoan extends ObjectsOnLoan{
	
	private String author, ISBN;
	private int numberOfPages;
	
	public BooksOnLoan(String name, String author, int publicationDay, String publicationMonth, int publicationYear, String genre, int numberOfPages, String ISBN) {
		super(name,publicationDay,publicationMonth,publicationYear,genre,
			  Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
			  Calendar.getInstance().get(Calendar.MONTH) + 1,
			  Calendar.getInstance().get(Calendar.YEAR),
			  Calendar.getInstance().get(Calendar.HOUR),
			  Calendar.getInstance().get(Calendar.MINUTE));
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
		System.out.println(prop.getProperty("Book_ISBN") + this.getISBN());
		System.out.println(prop.getProperty("ObjectsOnLoan_date") + super.getDayOfLoan() + "/" + super.getMonthOfLoan() + "/" + super.getYearOfLoan() + " " + super.getHourOfLoan() + ":" + super.getMinuteOfLoan());
	}
	
	public void printAllData(Properties prop) {
		System.out.println(prop.getProperty("Book_name") + super.getName() + ", " + prop.getProperty("Book_author1") + this.getAuthor() + ", " + prop.getProperty("ObjectsOnLoan_date") + super.getDayOfLoan() + "/" + super.getMonthOfLoan() + "/" + super.getYearOfLoan() + " " + super.getHourOfLoan() + ":" + super.getMinuteOfLoan());
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
}
