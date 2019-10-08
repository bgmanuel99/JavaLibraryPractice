package Biblioteca;

public class Book {

	private String bookName, author;
	private int loanTime, stock;
	
	public Book(String bookName, String author, int loanTime, int stock) {
		this.bookName = bookName;
		this.author = author;
		this.loanTime = loanTime;
		this.stock = stock;
	}
	
	public String getBookName() {
		return this.bookName;
	}
	public void setBookName(String _bookName) {
		this.bookName = _bookName;
	}
	
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String _author) {
		this.author = _author;
	}
	
	public int getLoanTime() {
		return this.loanTime;
	}
	public void setLoanTime(int _loanTime) {
		this.loanTime = _loanTime;
	}

	public int getStock() {
		return this.stock;
	}
	public void setStock(int _stock) {
		this.stock = _stock;
	}
	
	public void loan() {
		stock = stock - 1;
	}
}
