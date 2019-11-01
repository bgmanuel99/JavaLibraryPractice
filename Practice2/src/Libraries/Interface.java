package Libraries;

import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

public class Interface {

	public static void main(String[] args) throws IOException{

		Scanner consoleEntrance = new Scanner(System.in), consoleEntrance1;
		MyException exception = new MyException();

		//===========================================================================
		//                        INTERNATIONALISATION
		//===========================================================================
		System.out.println("These are the available languages and countries: ");
		System.out.println("  Languages        Countries            Codes");
		System.out.println("  ---------        ---------            -----");
		System.out.println("- English          United Kingdom       en, UK");
		System.out.println("- Spanish          Spain                es, ES");
		System.out.println("- Japanese         Japan                ja, JP");
		String language = "", country = "";
		boolean error = true;
		while(error != false) {
			System.out.print("Introduce the language code: ");
			language = consoleEntrance.nextLine();
			System.out.print("Introduce the country code: ");
			country = consoleEntrance.nextLine();
			if((!language.equals("en") || !country.equals("UK")) && (!language.equals("es") || !country.equals("ES")) &&
			  (!language.equals("ja") || !country.equals("JP"))) {
				System.out.println(exception.getException("ErrorLanguageCountry") + language + " " + country);
			}else {
				error = false;
			}
		}
		error = true;

		Properties prop = new Properties();
		InputStream labels = null;

		try {
			if(language.equals("en") && country.equals("UK")) {
				labels = new FileInputStream("Labels.properties");
			}else if(language.equals("es") && country.equals("ES")) {
				labels = new FileInputStream("Labels_es_ES.properties");
			}else if(language.equals("ja") && country.equals("JP")) {
				labels = new FileInputStream("Labels_ja_JP.properties");
			}
			prop.load(labels);
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		//===========================================================================

		Library library = new Library();

		//===========================================================================
		//           INTRODUCTION OF BOOKS AND VIDEOGAMES FROM TEXT FILES
		//===========================================================================
		
		String idFile = "";
		if(language.equals("en") && country.equals("UK")) {
			idFile = "BooksAndVideogames.txt";
		}else if(language.equals("es") && country.equals("ES")) {
			idFile = "BooksAndVideogames_es_ES.txt";
		}else if(language.equals("ja") && country.equals("JP")) {
			idFile = "BooksAndVideogames_ja_JP.txt";
		}

		File entryFile = new File(idFile);

		if(entryFile.exists()) {
			Scanner fileData = new Scanner(entryFile);
			while(fileData.hasNext()) {
				String object = fileData.next();
				library.addBookAndVideogames(object);
			}
			fileData.close();
		}else {
			System.out.println(prop.getProperty("File_not_exists"));
		}
		//===========================================================================

		boolean loggedIn = false, logOut = false;
		Vector<User> users = library.getUsers();
		String actualUserEmail = "", actualUserPassword = "";

		while(logOut != true) {
			while(loggedIn != true && logOut != true) {
				String logInOrRegister = "";
				while(error != false) {
					System.out.print(prop.getProperty("Library_cover"));
					logInOrRegister = consoleEntrance.nextLine();
					
					if((!logInOrRegister.equals("1")) && (!logInOrRegister.equals("2")) && (!logInOrRegister.equals("3"))) {
						System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
					}else {
						error = false;
					}
				}
				int logInOrRegister1 = Integer.parseInt(logInOrRegister);
				error = true;

				if(logInOrRegister1 == 1) {
					System.out.print(prop.getProperty("Introduce_email"));
					consoleEntrance = new Scanner(System.in);
					actualUserEmail = consoleEntrance.nextLine();

					System.out.print(prop.getProperty("Introduce_password"));
					actualUserPassword = consoleEntrance.nextLine();

					if(library.correctLogIn(actualUserEmail, actualUserPassword)) {
						for(User elem : users) {
							if(elem.getEmail().equalsIgnoreCase(actualUserEmail)) {
								elem.setLoggedIn(true);
							}
						}
						System.out.println(prop.getProperty("Sucessfully_logged_in"));
						loggedIn = true;
					}else {
						System.out.println(prop.getProperty("Wrong_email_password"));
					}
				}else if(logInOrRegister1 == 2){
					System.out.print(prop.getProperty("Introduce_firstname"));
					consoleEntrance = new Scanner(System.in);
					String firstName = consoleEntrance.nextLine();

					System.out.print(prop.getProperty("Introduce_lastname"));
					String lastName = consoleEntrance.nextLine();

					System.out.print(prop.getProperty("Introduce_ID"));
					String ID = consoleEntrance.nextLine();

					System.out.print(prop.getProperty("Introduce_email"));
					String email = consoleEntrance.nextLine();

					System.out.print(prop.getProperty("Introduce_password"));
					String password = consoleEntrance.nextLine();

					String birthDay = "";
					while(error != false) {
						System.out.print(prop.getProperty("Introduce_birthday"));
						birthDay = consoleEntrance.nextLine();
						
						for(String elem : exception.getDays()) {
							if(elem.equals(birthDay)) {
								error = false;
								break;
							}
						}
						if(error == true) {
							System.out.println(exception.getException("ErrorBirthDates"));
						}
					}
					int birthDayInt = Integer.parseInt(birthDay);
					error = true;
					
					String birthMonth = "";
					while(error != false) {
						System.out.print(prop.getProperty("Introduce_birthmonth"));
						birthMonth = consoleEntrance.nextLine();
						
						for(String elem : exception.getMonths()) {
							if(elem.equals(birthMonth)) {
								error = false;
								break;
							}
						}
						if(error == true) {
							System.out.println(exception.getException("ErrorBirthDates"));
						}
					}
					int birthMonthInt = Integer.parseInt(birthMonth);
					error = true;

					String birthYear = "";
					while(error != false) {
						System.out.println(prop.getProperty("Years_to_choose") + (Calendar.getInstance().get(Calendar.YEAR) - 69) + " " + prop.getProperty("Years_to_choose1") + Calendar.getInstance().get(Calendar.YEAR));
						System.out.print(prop.getProperty("Introduce_birthyear"));
						birthYear = consoleEntrance.nextLine();
						
						for(String elem : exception.getYears()) {
							if(elem.equals(birthYear)) {
								error = false;
								break;
							}
						}
						if(error == true) {
							System.out.println(exception.getException("ErrorBirthDates"));
						}
					}
					int birthYearInt = Integer.parseInt(birthYear);
					error = true;

					String maleFemale = "";
					while(error != false) {
						System.out.print(prop.getProperty("Introduce_sex"));
						maleFemale = consoleEntrance.nextLine();
						
						if((!maleFemale.equals("1")) && (!maleFemale.equals("2"))) {
							System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
						}else {
							error = false;
						}
					}
					int maleFemaleInt = Integer.parseInt(maleFemale);
					error = true;
					
					String sex = "";
					if(maleFemaleInt == 1) {
						sex = prop.getProperty("Sex_male");
					}else if(maleFemaleInt == 2) {
						sex = prop.getProperty("Sex_female");
					}

					if(library.userIDAlreadyRegistered(ID)) {
						System.out.println(prop.getProperty("Id_already_registered"));
						if(library.userEmailAlreadyRegistered(email)) {
							System.out.println(prop.getProperty("Email_already_registered"));
						}else {}
					}else if(library.userEmailAlreadyRegistered(email)) {
						System.out.println(prop.getProperty("Email_already_registered"));
					}else {
						library.addUser(new User(firstName, lastName, ID, birthDayInt, birthMonthInt, birthYearInt, sex, email, password));
						System.out.println(prop.getProperty("Sucessfully_registered"));
					}
				}else if(logInOrRegister1 == 3) {
					logOut = true;
				}
			}

			if(logOut != true) {
				String option = "";
				while(!option.equals("4")) {
					consoleEntrance = new Scanner(System.in);
					while(error != false) {
						System.out.print(prop.getProperty("Main_menu"));
						option = consoleEntrance.nextLine();
						
						if((!option.equals("1")) && (!option.equals("2")) && (!option.equals("3")) && (!option.equals("4"))){
							System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
						}else {
							error = false;
						}
					}
					error = true;

					if(option.equals("1")) {
						String option2 = "";
						while(!option2.equals("4")) {

							while(error != false) {
								System.out.print(prop.getProperty("User's_menu"));
								option2 = consoleEntrance.nextLine();
								
								if((!option2.equals("1")) && (!option2.equals("2")) && (!option2.equals("3")) && (!option2.equals("4"))) {
									System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
								}else {
									error = false;
								}
							}
							int option2Int = Integer.parseInt(option2);
							error = true;

							switch(option2Int) {
							case 1:
								User user = library.searchUser(actualUserEmail, actualUserPassword);
								if(user != null) {
									consoleEntrance1 = new Scanner(System.in);
									String yesNo = "";
									while(error != false) {
										System.out.print(prop.getProperty("Ask_drop_out")+ ", " + user.getFirstName() + " " + user.getLastName() + prop.getProperty("Ask_drop_out_response"));
										yesNo = consoleEntrance1.nextLine();
										
										if((!yesNo.equals("1")) && (!yesNo.equals("2"))) {
											System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
										}else {
											error = false;
										}
									}
									int yesNoInt = Integer.parseInt(yesNo);
									error = true;

									if(yesNoInt == 1) {
										library.dropOutUser(actualUserEmail, actualUserPassword);
										System.out.println(prop.getProperty("Drop_out_user"));
										option2 = "4";
										option = "4";
									}else if(yesNoInt == 2) {}
								}else {
									System.out.println(prop.getProperty("User_data_wrong"));
								}
								break;
							case 2:
								User user1 = library.searchUser(actualUserEmail, actualUserPassword);
								if(user1 != null) {
									boolean changeFirstName = false, changeLastName = false, changeSex = false, changeEmail = false, changePassword = false;
									String newFirstName = "", newLastName = "", newSex = "", newEmail = "", newPassword = "";
									String response = "1";
									while(!response.equals("2")) {
										consoleEntrance = new Scanner(System.in);
										String response1 = "";
										while(error != false) {
											System.out.print("    " + prop.getProperty("Ask_user_edition"));
											response1 = consoleEntrance.nextLine();
											
											if((!response1.equals("1")) && (!response1.equals("2")) && (!response1.equals("3")) && (!response1.equals("4")) && (!response1.equals("5"))) {
												System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
											}else {
												error = false;
											}
										}
										int response1Int = Integer.parseInt(response1);
										error = true;

										String response2 = "";
										if(response1Int == 1) {
											System.out.print(prop.getProperty("Introduce_new_firstname"));
											consoleEntrance1 = new Scanner(System.in);
											newFirstName = consoleEntrance1.nextLine();

											while(error != false) {
												System.out.print(prop.getProperty("Confirm_change_firstname"));
												response2 = consoleEntrance1.nextLine();
												
												if((!response2.equals("1")) && (!response2.equals("2"))) {
													System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
												}else {
													error = false;
												}
											}
											int response2Int = Integer.parseInt(response2);
											error = true;

											if(response2Int == 1) {
												changeFirstName = true;
											}else if(response2Int == 2) {}
										}else if(response1Int == 2) {
											System.out.print(prop.getProperty("Introduce_new_lastname"));
											consoleEntrance1 = new Scanner(System.in);
											newLastName = consoleEntrance1.nextLine();

											while(error != false) {
												System.out.print(prop.getProperty("Confirm_change_lastname"));
												response2 = consoleEntrance1.nextLine();
												
												if((!response2.equals("1")) && (!response2.equals("2"))) {
													System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
												}else {
													error = false;
												}
											}
											int response2Int = Integer.parseInt(response2);
											error = true;

											if(response2Int == 1) {
												changeLastName = true;
											}else if(response2Int == 2) {}
										}else if(response1Int == 3) {
											consoleEntrance1 = new Scanner(System.in);
											String maleFemale1 = "";
											while(error != false) {
												System.out.print(prop.getProperty("Introduce_new_sex"));
												maleFemale1 = consoleEntrance1.nextLine();
												
												if((!maleFemale1.equals("1")) && (!maleFemale1.equals("2"))) {
													System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
												}else {
													error = false;
												}
											}
											int maleFemale1Int = Integer.parseInt(maleFemale1);
											error = true;

											if(maleFemale1Int == 1) {
												newSex = prop.getProperty("Sex_male");
											}else if(maleFemale1Int == 2) {
												newSex = prop.getProperty("Sex_female");
											}

											while(error != false) {
												System.out.print(prop.getProperty("Confirm_change_sex"));
												response2 = consoleEntrance1.nextLine();
												
												if((!response2.equals("1")) && (!response2.equals("2"))) {
													System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
												}else {
													error = false;
												}
											}
											int response2Int = Integer.parseInt(response2);
											error = true;

											if(response2Int == 1) {
												changeSex = true;
											}else if(response2Int == 2) {}
										}else if(response1Int == 4){
											System.out.print(prop.getProperty("Introduce_new_email"));
											consoleEntrance1 = new Scanner(System.in);
											newEmail = consoleEntrance1.nextLine();
											
											if(!library.userEmailAlreadyRegistered(newEmail)) {
												while(error != false) {
													System.out.print(prop.getProperty("Confirm_change_email"));
													response2 = consoleEntrance1.nextLine();
													
													if((!response2.equals("1")) && (!response2.equals("2"))) {
														System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
													}else {
														error = false;
													}
												}
												int response2Int = Integer.parseInt(response2);
												error = true;
												
												if(response2Int == 1) {
													changeEmail = true;
													actualUserEmail = newEmail;
												}else if(response2Int == 2) {}
											}else {
												System.out.println(prop.getProperty("Email_already_registered"));
											}
										}else if(response1Int == 5) {
											System.out.print(prop.getProperty("Introduce_new_password"));
											consoleEntrance1 = new Scanner(System.in);
											newPassword = consoleEntrance1.nextLine();
											
											while(error != false) {
												System.out.print(prop.getProperty("Confirm_change_password"));
												response2 = consoleEntrance1.nextLine();
												
												if((!response2.equals("1")) && (!response2.equals("2"))) {
													System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
												}else {
													error = false;
												}
											}
											int response2Int = Integer.parseInt(response2);
											error = true;
											
											if(response2Int == 1) {
												changePassword = true;
												actualUserPassword = newPassword;
											}else if(response2Int == 2) {}
										}

										while(error != false) {
											System.out.print(prop.getProperty("Ask_another_user_edition"));
											response = consoleEntrance.nextLine();
											
											if((!response.equals("1")) && (!response.equals("2"))) {
												System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
											}else {
												error = false;
											}
										}
										error = true;
									}
									library.userEdition(changeFirstName, changeLastName, changeSex, changeEmail, changePassword, newFirstName, newLastName, newSex, newEmail, newPassword, user1.getID());
								}else {
									System.out.println(prop.getProperty("User_data_wrong"));
								}
								break;
							case 3:
								option2 = "4";
								option = "";
								break;
							case 4:
								option2 = "4";
								option = "4";
								break;
							}
						}
					}else if(option.equals("2")) {
						String option3 = "";
						while(!option3.equals("6")) {

							while(error != false) {
								System.out.print(prop.getProperty("Library_menu"));
								option3 = consoleEntrance.nextLine();
								
								if((!option3.equals("1")) && (!option3.equals("2")) && (!option3.equals("3")) && (!option3.equals("4")) && (!option3.equals("5")) && (!option3.equals("6"))) {
									System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
								}else {
									error = false;
								}
							}
							int option3Int = Integer.parseInt(option3);
							error = true;

							switch(option3Int) {
							case 1:
								System.out.print(prop.getProperty("Introduce_book_name"));
								consoleEntrance = new Scanner(System.in);
								String bookName = consoleEntrance.nextLine();

								if(library.searchBookByName(bookName)) {
									Book book = library.getBook(bookName);
									book.printData(prop);
								}else {
									System.out.println(prop.getProperty("Book_not_stock") + bookName + " " + prop.getProperty("Book_not_stock1"));
								}
								break;
							case 2:
								System.out.print(prop.getProperty("Introduce_author_name"));
								consoleEntrance = new Scanner(System.in);
								String authorName = consoleEntrance.nextLine();

								if(library.searchBookByAuthor(authorName)) {
									System.out.println(prop.getProperty("Author_books") + authorName + " " + prop.getProperty("Author_books1"));
									library.printBooks(authorName);
									
									String searchOrNot = "";
									while(error != false) {
										System.out.print(prop.getProperty("Ask_to_search_book"));
										searchOrNot = consoleEntrance.nextLine();
										
										if((!searchOrNot.equals("1")) && (!searchOrNot.equals("2"))) {
											System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
										}else {
											error = false;
										}
									}
									int searchOrNotInt = Integer.parseInt(searchOrNot);
									error = true;
									
									if(searchOrNotInt == 1) {
										String option4 = "";
										while(!option4.equals("2")) {
											System.out.print(prop.getProperty("Choose_book"));
											consoleEntrance = new Scanner(System.in);
											String book = consoleEntrance.nextLine();
											
											if(library.searchBookByName(book)) {
												Book elem = library.getBook(book);
												elem.printData(prop);
												
												while(error != false) {
													System.out.print(prop.getProperty("Ask_to_choose_book"));
													option4 = consoleEntrance.nextLine();
													
													if((!option4.equals("1")) && (!option4.equals("2"))) {
														System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
													}else {
														error = false;
													}
												}
												error = true;
											}else {
												System.out.println(prop.getProperty("Book_not_stock") + book + " " + prop.getProperty("Book_not_stock1"));
												
												while(error != false) {
													System.out.print(prop.getProperty("Ask_to_choose_book"));
													option4 = consoleEntrance.nextLine();
													
													if((!option4.equals("1")) && (!option4.equals("2"))) {
														System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
													}else {
														error = false;
													}
												}
												error = true;
											}
										}
									}else if(searchOrNotInt == 2) {}
								}else {
									System.out.println(prop.getProperty("Not_author_books") + authorName);
								}
								break;
							case 3:
								String bookOrAuthor = "";
								while(error != false) {
									System.out.print(prop.getProperty("Search_book_author_name"));
									bookOrAuthor = consoleEntrance.nextLine();
									
									if((!bookOrAuthor.equals("1")) && (!bookOrAuthor.equals("2"))) {
										System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
									}else {
										error = false;
									}
								}
								int bookOrAuthorInt = Integer.parseInt(bookOrAuthor);
								error = true;

								if(bookOrAuthorInt == 1) {
									System.out.print(prop.getProperty("Introduce_book_name"));
									consoleEntrance1 = new Scanner(System.in);
									String book = consoleEntrance1.nextLine();

									if(library.searchBookByName(book)) {
										int stock = library.getNumberInStock(book);
										if(stock > 0) {
											Book elem = library.getBook(book);
											elem.printData(prop);
											String yesNo = "";
											while(error != false) {
												System.out.print(prop.getProperty("Make_loan"));
												yesNo = consoleEntrance1.nextLine();
												
												if((!yesNo.equals("1")) && (!yesNo.equals("2"))) {
													System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
												}else {
													error = false;
												}
											}
											int yesNoInt = Integer.parseInt(yesNo);
											error = true;

											if(yesNoInt == 1) {
												library.makeALoan(book);
											}else if(yesNoInt == 2) {}
										}else if(stock == 0) {
											System.out.println(prop.getProperty("Book_not_stock_now") + book + " " + prop.getProperty("Book_not_stock_now1"));
										}
									}else {
										System.out.println(prop.getProperty("Book_not_stock") + book + " " + prop.getProperty("Book_not_stock1"));
									}
								}else if(bookOrAuthorInt == 2) {
									System.out.print(prop.getProperty("Introduce_author_name"));
									consoleEntrance1 = new Scanner(System.in);
									String authorName1 = consoleEntrance1.nextLine();

									if(library.searchBookByAuthor(authorName1)) {
										System.out.println(prop.getProperty("Author_books") + authorName1 + " " + prop.getProperty("Author_books1"));
										library.printBooks(authorName1);

										System.out.print(prop.getProperty("Book_to_make_loan"));
										String book1 = consoleEntrance1.nextLine();

										if(library.searchBookByName(book1)) {
											int stock = library.getNumberInStock(book1);
											if(stock > 0) {
												Book elem = library.getBook(book1);
												elem.printData(prop);
												
												String yesNo1 = "";
												while(error != false) {
													System.out.print(prop.getProperty("Make_loan"));
													yesNo1 = consoleEntrance1.nextLine();
													
													if((!yesNo1.equals("1")) && (!yesNo1.equals("2"))) {
														System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
													}else {
														error = false;
													}
												}
												int yesNo1Int = Integer.parseInt(yesNo1);
												error = true;
												
												if(yesNo1Int == 1) {
													library.makeALoan(book1);
												}else if(yesNo1Int == 2) {}
											}else if(stock == 0){
												System.out.println(prop.getProperty("Book_not_stock_now") + book1 + " " + prop.getProperty("Book_not_stock_now1"));
											}
										}else {
											System.out.println(prop.getProperty("Book_not_stock") + book1 + " " + prop.getProperty("Book_not_stock1"));
										}
									}else {
										System.out.println(prop.getProperty("Not_author_books") + authorName1);
									}
								}
								break;
							case 4:
								library.printLoanObjects(prop, true, false);
								break;
							case 5:
								option3 = "6";
								option = "";
								break;
							case 6:
								option3 = "6";
								option = "4";
								break;
							}
						}
					}else if(option.equals("3")) {
						String option4 = "";
						while(!option4.equals("5")) {
							while(error != false) {
								System.out.print(prop.getProperty("Videogame_menu"));
								option4 = consoleEntrance.nextLine();
								
								if((!option4.equals("1")) && (!option4.equals("2")) && (!option4.equals("3")) && (!option4.equals("4")) && (!option4.equals("5"))) {
									System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
								}else {
									error = false;
								}
							}
							int option4Int = Integer.parseInt(option4);
							error = true;
							
							switch(option4Int) {
							case 1:
								consoleEntrance = new Scanner(System.in);
								System.out.print(prop.getProperty("Introduce_videogame_name"));
								String videogame = consoleEntrance.nextLine();
								
								if(library.searchVideogameByName(videogame)) {
									VideoGames videogame1 = library.getVideogame(videogame);
									videogame1.printData(prop);
								}else {
									System.out.println(prop.getProperty("Videogame_not_stock") + videogame + prop.getProperty("Videogame_not_stock1"));
								}
								break;
							case 2:
								consoleEntrance = new Scanner(System.in);
								System.out.print(prop.getProperty("Introduce_videogame_name"));
								String videogame1 = consoleEntrance.nextLine();
								
								if(library.searchVideogameByName(videogame1)) {
									int stock = library.getNumberInStock(videogame1);
									
									if(stock > 0) {
										VideoGames videogame2 = library.getVideogame(videogame1);
										videogame2.printData(prop);
										
										String yesNo = "";
										while(error != false) {
											System.out.print(prop.getProperty("Make_loan"));
											yesNo = consoleEntrance.nextLine();
											
											if((!yesNo.equals("1")) && (!yesNo.equals("2"))) {
												System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
											}else {
												error = false;
											}
										}
										int yesNoInt = Integer.parseInt(yesNo);
										error = true;
										
										if(yesNoInt == 1) {
											library.makeALoan(videogame1);
										}else if(yesNoInt == 2){}
									}else if(stock == 0){
										System.out.println(prop.getProperty("Videogame_not_stock_now") + videogame1 + prop.getProperty("Videogame_not_stock_now1"));
									}
								}else {
									System.out.println(prop.getProperty("Videogame_not_stock") + videogame1 + prop.getProperty("Videogame_not_stock1"));
								}
								break;
							case 3:
								library.printLoanObjects(prop, false, true);
								break;
							case 4:
								option4 = "5";
								option = "";
								break;
							case 5:
								option4 = "5";
								option = "4";
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
