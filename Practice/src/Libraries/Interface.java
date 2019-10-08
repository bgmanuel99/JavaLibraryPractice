package Libraries;
import java.util.Scanner;
import java.util.*;

public class Interface {

	public static void pageMenu() {
		System.out.println("--------------------------");
		System.out.println("| WELCOME TO THE LIBRARY |");
		System.out.println("--------------------------");
		System.out.println("1.Log in.");
		System.out.println("2.Register as a user.");
		System.out.println("3.Log out.");
		System.out.print("Choose what you want to do: ");
	}

	public static void principalMenu() {
		System.out.println("-----------------------");
		System.out.println("|      MAIN MENU      |");
		System.out.println("-----------------------");
		System.out.println("1.User's menu.");
		System.out.println("2.Library menu.");
		System.out.println("3.Log out.");
		System.out.print("Choose what you want to do: ");
	}

	public static void usersMenu() {
		System.out.println("---------------------------");
		System.out.println("|       USER'S MENU       |");
		System.out.println("---------------------------");
		System.out.println("1.Drop out.");
		System.out.println("2.User edition.");
		System.out.println("3.Return to main menu.");
		System.out.println("4.Log out.");
		System.out.print("Choose what you want to do: ");
	}

	public static void libraryMenu() {
		System.out.println("----------------------------");
		System.out.println("|       LIBRARY MENU       |");
		System.out.println("----------------------------");
		System.out.println("1.Search for books by name.");
		System.out.println("2.Search for books by author.");
		System.out.println("3.Make a loan.");
		System.out.println("4.Show all the books of the library.");
		System.out.println("5.Return to main menu.");
		System.out.println("6.Log out");
		System.out.print("Choose what you want to do: ");
	}

	public static void main(String[] args) {

		/*
		 * I call the addBook function of the class library to insert a new book into the books vector that is
		 * an atribute of the library class.
		 */

		Library bookShop = new Library();
		bookShop.addBook(new Book("El Silmarillion", "JRR Martin", 14, 3));
		bookShop.addBook(new Book("El Hobbit", "JRR Martin", 14, 3));

		boolean loggedIn = false, logOut = false;
		Scanner consoleEntrance = new Scanner(System.in), consoleEntrance1;
		Vector<User> users = bookShop.getUsers();
		String actualUserEmail = "", actualUserPassword = "";

		while(logOut != true) {
			while(loggedIn != true && logOut != true) {
				pageMenu();
				int logInOrRegister = consoleEntrance.nextInt();

				if(logInOrRegister == 1) {
					System.out.print("Introduce your Email: ");
					consoleEntrance = new Scanner(System.in);
					actualUserEmail = consoleEntrance.nextLine();

					System.out.print("Introduce your password: ");
					actualUserPassword = consoleEntrance.nextLine();

					if(bookShop.correctLogIn(actualUserEmail, actualUserPassword)) {
						for(User elem : users) {
							if(elem.getEmail().equalsIgnoreCase(actualUserEmail)) {
								elem.setLoggedIn(true);
							}
						}
						System.out.println("You've been sucessfully logged in");
						loggedIn = true;
					}else {
						System.out.println("Wrong email or password!!");
					}
				}else if(logInOrRegister == 2){
					System.out.print("Introduce your firstname: ");
					consoleEntrance = new Scanner(System.in);
					String firstName = consoleEntrance.nextLine();

					System.out.print("Introduce your lastname: ");
					String lastName = consoleEntrance.nextLine();

					System.out.print("Introduce your ID: ");
					String ID = consoleEntrance.nextLine();

					System.out.print("Introduce your email: ");
					String email = consoleEntrance.nextLine();

					System.out.print("Introduce your password: ");
					String password = consoleEntrance.nextLine();

					System.out.print("Introduce your birthDay: ");
					int birthDay = consoleEntrance.nextInt();

					System.out.print("Introduce your birthMonth: ");
					int birthMonth = consoleEntrance.nextInt();

					System.out.print("Introduce your birthYear: ");
					int birthYear = consoleEntrance.nextInt();

					System.out.print("Introduce your sex: male(1), female(2): ");
					int maleFemale = consoleEntrance.nextInt();

					String sex = "";
					if(maleFemale == 1) {
						sex = "Male";
					}else if(maleFemale == 2) {
						sex = "Female";
					}

					if(bookShop.userIDAlreadyRegistered(ID)) {
						System.out.println("There is already a user registered with that ID.");
						if(bookShop.userEmailAlreadyRegistered(email)) {
							System.out.println("And there is also a user registered with that email.");
						}else {}
					}else if(bookShop.userEmailAlreadyRegistered(email)) {
						System.out.println("There is already a user registered with that email.");
					}else {
						bookShop.addUser(new User(firstName, lastName, ID, birthDay, birthMonth, birthYear, sex, email, password));
						System.out.println("You've been sucessfully registered!!");
					}
				}else if(logInOrRegister == 3) {
					logOut = true;
				}
			}

			if(logOut != true) {
				int option = 0;
				while(option != 3) {
					consoleEntrance = new Scanner(System.in);
					principalMenu();
					option = consoleEntrance.nextInt();

					if(option == 1) {
						int option2 = 0;
						while(option2 != 4) {

							usersMenu();
							option2 = consoleEntrance.nextInt();

							switch(option2) {
							case 1:
								User user = bookShop.searchUser(actualUserEmail, actualUserPassword);
								if(user != null) {
									System.out.print("Do you realy want to drop out?, " + user.getFirstName() + " " + user.getLastName() + ": NO(0)/yes(1): ");
									consoleEntrance1 = new Scanner(System.in);
									int yesNo = consoleEntrance1.nextInt();

									if(yesNo == 1) {
										bookShop.dropOutUser(actualUserEmail, actualUserPassword);
										System.out.println("You've been sucessfully drop out!!");
										option2 = 4;
										option = 3;
									}else {}
								}else {
									System.out.println("There is no user with that data");
								}
								break;
							case 2:
								User user1 = bookShop.searchUser(actualUserEmail, actualUserPassword);
								if(user1 != null) {
									boolean changeFirstName = false, changeLastName = false, changeSex = false;
									String newFirstName = "", newLastName = "", newSex = "";
									int response = 1;
									while(response != 0) {
										System.out.print("What do you want to edit?: firstname(1), lastname(2), sex(3): ");
										consoleEntrance = new Scanner(System.in);
										int response1 = consoleEntrance.nextInt();

										int response2 = 0;
										if(response1 == 1) {
											System.out.print("Introduce the new firstname: ");
											consoleEntrance1 = new Scanner(System.in);
											newFirstName = consoleEntrance1.nextLine();

											System.out.print("Want to confirm the change of your firstname?: yes(1)/no(2): ");
											response2 = consoleEntrance1.nextInt();

											if(response2 == 1) {
												changeFirstName = true;
											}else {}
										}else if(response1 == 2) {
											System.out.print("Introduce the new lastname: ");
											consoleEntrance1 = new Scanner(System.in);
											newLastName = consoleEntrance1.nextLine();

											System.out.print("Want to confirm the change of your lastname?: yes(1)/no(2): ");
											response2 = consoleEntrance1.nextInt();

											if(response2 == 1) {
												changeLastName = true;
											}else {}
										}else if(response1 == 3) {
											System.out.print("Choose the new sex: male(1)/female(2): ");
											consoleEntrance1 = new Scanner(System.in);
											int maleFemale1 = consoleEntrance1.nextInt();

											if(maleFemale1 == 1) {
												newSex = "Male";
											}else if(maleFemale1 == 2) {
												newSex = "Female";
											}

											System.out.print("Want to confirm the change of your sex?: yes(1)/no(2): ");
											response2 = consoleEntrance1.nextInt();

											if(response2 == 1) {
												changeSex = true;
											}else {}
										}else {}

										System.out.print("Do you want to edit other part of your profile?: yes(1)/no(0)");
										response = consoleEntrance.nextInt();
									}
									bookShop.userEdition(changeFirstName, changeLastName, changeSex, newFirstName, newLastName, newSex, user1.getID());
								}else {
									System.out.println("There is no user with that data.");
								}
								break;
							case 3:
								option2 = 4;
								option = 0;
								break;
							case 4:
								option2 = 4;
								option = 3;
								break;
							}
						}
					}else if(option == 2) {
						int option3 = 0;
						while(option3 != 6) {

							libraryMenu();
							option3 = consoleEntrance.nextInt();

							switch(option3) {
							case 1:
								System.out.print("Introduce the name of the book: ");
								consoleEntrance = new Scanner(System.in);
								String bookName = consoleEntrance.nextLine();

								if(bookShop.searchBookByName(bookName)) {
									System.out.println("There are " + bookShop.getNumberInStock(bookName) + " copies of this book in stock.");
								}else {
									System.out.println("The book: " + bookName + " is not in stock.");
								}
								break;
							case 2:
								System.out.print("Introduce the name of the author: ");
								consoleEntrance = new Scanner(System.in);
								String authorName = consoleEntrance.nextLine();

								if(bookShop.searchBookByAuthor(authorName)) {
									System.out.println("The books written by the author " + authorName + " are: ");
									bookShop.printBooks(authorName);
								}else {
									System.out.println("We dont have books by the author: " + authorName);
								}
								break;
							case 3:
								User user2 = bookShop.searchUser(actualUserEmail, actualUserPassword);
								if(user2 != null) {
									System.out.print("Do you want to search from books name or from authors name: books name(1), authors name(2): ");
									int bookOrAuthor = consoleEntrance.nextInt();

									if(bookOrAuthor == 1) {
										System.out.print("Introduce the name of the book: ");
										consoleEntrance1 = new Scanner(System.in);
										String book = consoleEntrance1.nextLine();

										if(bookShop.searchBookByName(book)) {
											System.out.println("There are " + bookShop.getNumberInStock(book) + " copies of this book in stock.");
											System.out.print("Do you want to make a loan?: yes(1)/no(0): ");
											int yesNo = consoleEntrance1.nextInt();

											if(yesNo == 1) {
												bookShop.makeALoan(book);
											}else {}
										}else {
											System.out.println("The book: " + book + " is not in stock.");
										}
									}else if(bookOrAuthor == 2) {
										System.out.print("Introduce the name of the author: ");
										consoleEntrance1 = new Scanner(System.in);
										String authorName1 = consoleEntrance1.nextLine();

										if(bookShop.searchBookByAuthor(authorName1)) {
											System.out.println("The books written by the author " + authorName1 + " are: ");
											bookShop.printBooks(authorName1);

											System.out.print("Choose the book you want to make a loan for: ");
											String book1 = consoleEntrance1.nextLine();

											if(bookShop.searchBookByName(book1)) {
												System.out.print("Do you want to make a loan?: yes(1)/no(0): ");
												int yesNo1 = consoleEntrance1.nextInt();

												if(yesNo1 == 1) {
													bookShop.makeALoan(book1);
													System.out.println("Your loan has been made successfully!!");
												}else {}
											}else {
												System.out.println("The book: " + book1 + " is not in stock.");
											}
										}else {
											System.out.println("We dont have books by the author: " + authorName1);
										}
									}
								}else {
									System.out.println("There is no user with that data.");
								}
								break;
							case 4:
								bookShop.printBooks();
								break;
							case 5:
								option3 = 6;
								option = 0;
								break;
							case 6:
								option3 = 6;
								option = 3;
								break;
							}
						}
					}
				}
			}
			loggedIn = false;
		}
		consoleEntrance.close();
	}
}
