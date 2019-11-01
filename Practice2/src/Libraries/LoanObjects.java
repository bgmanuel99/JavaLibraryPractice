package Libraries;

import java.util.Properties;

public abstract class LoanObjects {
	
	private String name, genre, publicationMonth;
	private int publicationDay, publicationYear, loanTime, stock;
	
	public LoanObjects(String name, int publicationDay, String publicationMonth, int publicationYear, String genre, int loanTime, int stock) {
		this.name = name;
		this.publicationDay = publicationDay;
		this.publicationMonth = publicationMonth;
		this.publicationYear = publicationYear;
		this.genre = genre;
		this.loanTime = loanTime;
		this.stock = stock;
	}
	
	abstract public void printAllData(Properties prop);
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getLoanTime() {
		return loanTime;
	}
	public void setLoanTime(int loanTime) {
		this.loanTime = loanTime;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPublicationDay() {
		return publicationDay;
	}
	public void setPublicationDay(int publicationDay) {
		this.publicationDay = publicationDay;
	}

	public String getPublicationMonth() {
		return publicationMonth;
	}
	public void setPublicationMonth(String publicationMonth) {
		this.publicationMonth = publicationMonth;
	}

	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public void loan() {
		stock -= 1;
	}
}
