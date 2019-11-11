package Libraries;
import java.util.Properties;
import java.util.Vector;

public class Library {

	private Vector<LoanObjects> loanObjects; 
	private Vector<User> users;

	public Library() {
		this.loanObjects = new Vector<LoanObjects>();
		this.users = new Vector<User>();
	}

	public void addBookAndVideogames(String object) {
		int coma = 0, semicolon = 0, pastSemicolon = 0;
		String bookOrVideogame = "";
		String name = "", publicationDay = "", publicationMonth = "", publicationYear = "", genre = "", loanTime = "", stock = "", author = "", numberOfPages = "", ISBN = "", gameModes = "", lastVersion = "", composer = "", developer = "", platform = "";
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();

		for(int i=0; i < object.length(); i++) {
			if(object.charAt(i) == ',') {
				coma++;
				semicolon = 0;
				pastSemicolon = 0;
				continue;
			}
			if(object.charAt(i) == ';') semicolon++;

			if(coma == 0) bookOrVideogame += object.charAt(i);

			if(bookOrVideogame.equals("Book")) {
				if(coma == 1) {
					if(object.charAt(i) == '|') {
						name += " ";
						continue;
					}
					name += object.charAt(i);
				}
				else if(coma == 2) publicationDay += object.charAt(i);
				else if(coma == 3) publicationMonth += object.charAt(i);
				else if(coma == 4) publicationYear += object.charAt(i);
				else if(coma == 5) {
					if(object.charAt(i) == '|') {
						genre += " ";
						continue;
					}
					genre += object.charAt(i);
				}
				else if(coma == 6) loanTime += object.charAt(i);
				else if(coma == 7) stock += object.charAt(i);
				else if(coma == 8) {
					if(object.charAt(i) == '|') {
						author += " ";
						continue;
					}
					author += object.charAt(i);
				}
				else if(coma == 9) numberOfPages += object.charAt(i);
				else if(coma == 10) ISBN += object.charAt(i);
			}else if(bookOrVideogame.equals("Videogame")) {
				if(coma == 1) {
					if(object.charAt(i) == '|') {
						name += " ";
						continue;
					}
					name += object.charAt(i);
				}
				else if(coma == 2) publicationDay += object.charAt(i);
				else if(coma == 3) publicationMonth += object.charAt(i);
				else if(coma == 4) publicationYear += object.charAt(i);
				else if(coma == 5) {
					if(object.charAt(i) == '|') {
						genre += " ";
						continue;
					}
					genre += object.charAt(i);
				}
				else if(coma == 6) loanTime += object.charAt(i);
				else if(coma == 7) stock += object.charAt(i);
				else if(coma == 8) {
					if(object.charAt(i) == '|') {
						gameModes += " ";
						continue;
					}
					gameModes += object.charAt(i);
				}
				else if(coma == 9) lastVersion += object.charAt(i);
				else if(coma == 10) {
					if(semicolon == pastSemicolon) {
						if(object.charAt(i) == '|') {
							composer += " ";
							continue;
						}
						composer += object.charAt(i);
					}else {
						composers.add(composer);
						composer = "";
						pastSemicolon = semicolon;
					}
				}
				else if(coma == 11) {
					if(semicolon == pastSemicolon) {
						if(object.charAt(i) == '|') {
							developer += " ";
							continue;
						}
						developer += object.charAt(i);
					}else {
						developers.add(developer);
						developer = "";
						pastSemicolon = semicolon;
					}
				}
				else if(coma == 12) {
					if(semicolon == pastSemicolon) {
						if(object.charAt(i) == '|') {
							platform += " ";
							continue;
						}
						platform += object.charAt(i);
					}else {
						platforms.add(platform);
						platform = "";
						pastSemicolon = semicolon;
					}
				}
			}
		}

		int publicationDayInt = Integer.parseInt(publicationDay);
		int publicationYearInt = Integer.parseInt(publicationYear);
		int loanTimeInt = Integer.parseInt(loanTime);
		int stockInt = Integer.parseInt(stock);
		int numberOfPagesInt = 0;
		if(bookOrVideogame.equals("Book")) {
			numberOfPagesInt = Integer.parseInt(numberOfPages);
		}

		if(bookOrVideogame.equals("Book")) {
			addBook(new Book(name, publicationDayInt, publicationMonth, publicationYearInt, genre, loanTimeInt, stockInt, author, numberOfPagesInt, ISBN));
		}else if(bookOrVideogame.equals("Videogame")) {
			addVideoGame(new VideoGames(name, publicationDayInt, publicationMonth, publicationYearInt, genre, loanTimeInt, stockInt, gameModes, composers, developers, lastVersion, platforms));
		}
	}
	
	public boolean searchLoanObjectsByName(String nameObject) {
		for(LoanObjects elem : loanObjects) {
			if(elem.getName().equals(nameObject)){
				return true;
			}
		}
		return false;
	}

	public void addBook(Book book) {
		loanObjects.addElement(book);
	}

	public boolean searchBookByAuthor(String author) {
		for(LoanObjects elem : loanObjects) {
			if(elem.getClass().getSimpleName().equals("Book")) {
				Book bookElem = (Book) elem;
				if(bookElem.getAuthor().equalsIgnoreCase(author)) {
					return true;
				}
			}
		}
		return false;
	}

	public void printBooks(String author) {
		for(LoanObjects elem : loanObjects) {
			if(elem.getClass().getSimpleName().equals("Book")) {
				Book bookElem = (Book) elem;
				if(bookElem.getAuthor().equalsIgnoreCase(author)) {
					System.out.println("- " + elem.getName());
				}
			}
		}
	}

	public void printLoanObjects(Properties prop, boolean book, boolean videogame) {
		for(LoanObjects elem : loanObjects) {
			if(book == true) {
				if(elem.getClass().getSimpleName().equals("Book")) {
					elem.printAllData(prop);
				}
			}else if(videogame == true) {
				if(elem.getClass().getSimpleName().equals("VideoGames")) {
					elem.printAllData(prop);
				}
			}
		}
	}

	public Book getBook(String bookName) {
		for(LoanObjects elem : loanObjects) {
			if(elem.getName().equals(bookName)) {
				if(elem.getClass().getSimpleName().equals("Book")) {
					Book bookElem = (Book) elem;
					return bookElem;
				}
			}
		}
		return null;
	}

	public void makeALoan(String objectName) {
		for(LoanObjects elem : loanObjects) {
			if(elem.getName().equalsIgnoreCase(objectName)) {
				elem.loan();
			}
		}
	}

	public void returnLoanObject(Book book) {
		for(LoanObjects elem : loanObjects) {
			if(elem.equals(book)) {
				elem.returnLoan();
			}
		}
	}

	public void returnLoanObject(VideoGames videogame) {
		for(LoanObjects elem : loanObjects) {
			if(elem.equals(videogame)) {
				elem.returnLoan();
			}
		}
	}

	public int getNumberInStock(String objectName) {
		int stock = 0;
		for(LoanObjects elem : loanObjects) {
			if(elem.getName().equalsIgnoreCase(objectName)) {
				stock = elem.getStock();
			}
		}
		return stock;
	}

	public void addVideoGame(VideoGames videogame) {
		loanObjects.addElement(videogame);
	}

	public VideoGames getVideogame(String videogame) {
		for(LoanObjects elem : loanObjects) {
			if(elem.getName().equals(videogame)) {
				if(elem.getClass().getSimpleName().equals("VideoGames")) {
					VideoGames videogameElem = (VideoGames) elem;
					return videogameElem;
				}
			}
		}
		return null;
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

	public void dropOutUser(User user) {
		users.remove(user);
	}

	public void userEdition(boolean changeFirstName, boolean changeLastName, boolean changeSex, boolean changeEmail,
			boolean changePassword, boolean changeBirthDay, boolean changeBirthMonth, boolean changeBirthYear,
			String newFirstName, String newLastName, String newSex, String newEmail,
			String newPassword, int newBirthDay, int newBirthMonth, int newBirthYear, User user) {
		for(User elem : users) {
			if(elem.equals(user)) {
				if(changeFirstName) elem.setFirstName(newFirstName);
				if(changeLastName) elem.setLastName(newLastName);
				if(changeSex) elem.setSex(newSex);
				if(changeEmail) elem.setEmail(newEmail);
				if(changePassword) elem.setPassword(newPassword);
				if(changeBirthDay) elem.setBirthDay(newBirthDay);
				if(changeBirthMonth) elem.setBirthMonth(newBirthMonth);
				if(changeBirthYear) elem.setBirthYear(newBirthYear);
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

	public Vector<LoanObjects> getBooks() {
		return loanObjects;
	}
	public void setBooks(Vector<LoanObjects> books) {
		this.loanObjects = books;
	}
	public Vector<User> getUsers() {
		return users;
	}
	public void setUsers(Vector<User> users) {
		this.users = users;
	}
}
