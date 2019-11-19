package Libraries;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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

						for(String elem : exception.getMultidimensionalDatesArray()[0]) {
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

						for(String elem : exception.getMultidimensionalDatesArray()[1]) {
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

						for(String elem : exception.getMultidimensionalDatesArray()[2]) {
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
				User user = library.searchUser(actualUserEmail, actualUserPassword);

				String attemp = "";
				while(error != false) {
					consoleEntrance = new Scanner(System.in);
					System.out.print(prop.getProperty("User_ask_tryPrize"));
					attemp = consoleEntrance.nextLine();

					if((!attemp.equals("1")) && (!attemp.equals("2"))) {
						System.out.println(exception.getException("ErrorIntegerOutOfBouds"));
					}else {
						error = false;
					}
				}
				int attempInt = Integer.parseInt(attemp);
				error = true;

				if(attempInt == 1) {
					if(user.haveReward(user.timeToDays(user.totalDaysRegistered()))) {
						if(user.wonAPrize()) {
							System.out.print(prop.getProperty("User_wonPrize"));
							int numRandom = (int) Math.floor(Math.random()*2);

							if(numRandom == 0) {
								Rewards<Integer> reward = new Rewards<Integer>(1);
								user.addReward(reward);
							}else if(numRandom == 1) {
								Vector<LoanObjects> loanObjects = library.getLoanObjects();
								Vector<String> randomObjects = new Vector<String>();
								for(LoanObjects elem : loanObjects) {
									randomObjects.add(elem.getName());
								}

								int numRandom1 = (int) Math.floor(Math.random()*(randomObjects.size()));
								String randomString = randomObjects.elementAt(numRandom1);

								Rewards<String> reward = new Rewards<String>(randomString);
								user.addReward(reward);
							}
						}else {
							System.out.println(prop.getProperty("User_not_wonPrize"));
						}
					}else {
						System.out.println(prop.getProperty("User_not_wonPrize"));
					}
				}else if(attempInt == 2){
					System.out.println(prop.getProperty("User_enterLibrary"));
				}
				System.out.println("");

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
						while(!option2.equals("11")) {
							while(error != false) {
								System.out.print(prop.getProperty("User's_menu"));
								option2 = consoleEntrance.nextLine();

								if((!option2.equals("1")) && (!option2.equals("2")) && (!option2.equals("3")) && (!option2.equals("4")) && (!option2.equals("5")) && (!option2.equals("6")) && (!option2.equals("7")) && (!option2.equals("8")) && (!option2.equals("9")) && (!option2.equals("10")) && (!option2.equals("11"))) {
									System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
								}else {
									error = false;
								}
							}
							int option2Int = Integer.parseInt(option2);
							error = true;

							switch(option2Int) {
							case 1:
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
									library.dropOutUser(user);
									Vector<ObjectsOnLoan> allObjectsOnLoan = user.getObjectsOnLoan();
									for(ObjectsOnLoan elem : allObjectsOnLoan) {
										if(elem.getClass().getSimpleName().equals("BooksOnLoan")) {
											Book book = library.getBook(elem.getName());
											library.returnLoanObject(book);
										}else if(elem.getClass().getSimpleName().equals("VideoGamesOnLoan")) {
											VideoGames videogame = library.getVideogame(elem.getName());
											library.returnLoanObject(videogame);
										}
									}
									System.out.println(prop.getProperty("Drop_out_user"));
									option2 = "11";
									option = "4";
								}else if(yesNoInt == 2) {}
								break;
							case 2:
								boolean changeFirstName = false, changeLastName = false, changeSex = false, changeEmail = false, changePassword = false, changeBirthDay = false, changeBirthMonth = false, changeBirthYear = false;
								String newFirstName = "", newLastName = "", newSex = "", newEmail = "", newPassword = "", newBirthDay = "", newBirthMonth = "", newBirthYear = "";
								int newBirthDayInt = 0, newBirthMonthInt = 0, newBirthYearInt = 0;
								String response = "1";
								while(!response.equals("2")) {
									consoleEntrance = new Scanner(System.in);
									String response1 = "";
									while(error != false) {
										System.out.print("    " + prop.getProperty("Ask_user_edition"));
										response1 = consoleEntrance.nextLine();

										if((!response1.equals("1")) && (!response1.equals("2")) && (!response1.equals("3")) && (!response1.equals("4")) && (!response1.equals("5")) && (!response1.equals("6")) && (!response1.equals("7")) && (!response1.equals("8"))) {
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
									}else if(response1Int == 6) {
										consoleEntrance1 = new Scanner(System.in);
										while(error != false) {
											System.out.print(prop.getProperty("Introduce_new_birthDay"));
											newBirthDay = consoleEntrance1.nextLine();

											for(String elem : exception.getMultidimensionalDatesArray()[0]) {
												if(elem.equals(newBirthDay)) {
													error = false;
													break;
												}
											}

											if(error == true) {
												System.out.println(exception.getException("ErrorBirthDates"));
											}
										}
										newBirthDayInt = Integer.parseInt(newBirthDay);
										error = true;

										while(error != false) {
											System.out.print(prop.getProperty("Confirm_change_birthDay"));
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
											changeBirthDay = true;
										}else if(response2Int == 2) {}
									}else if(response1Int == 7) {
										consoleEntrance1 = new Scanner(System.in);
										while(error != false) {
											System.out.print(prop.getProperty("Introduce_new_birthMonth"));
											newBirthMonth = consoleEntrance1.nextLine();

											for(String elem : exception.getMultidimensionalDatesArray()[1]) {
												if(elem.equals(newBirthMonth)) {
													error = false;
													break;
												}
											}

											if(error == true) {
												System.out.println(exception.getException("ErrorBirthDates"));
											}
										}
										newBirthMonthInt = Integer.parseInt(newBirthMonth);
										error = true;

										while(error != false) {
											System.out.print(prop.getProperty("Confirm_change_birthMonth"));
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
											changeBirthMonth = true;
										}else if(response2Int == 2) {}
									}else if(response1Int == 8) {
										consoleEntrance1 = new Scanner(System.in);
										while(error != false) {
											System.out.print(prop.getProperty("Introduce_new_birthYear"));
											newBirthYear = consoleEntrance1.nextLine();

											for(String elem : exception.getMultidimensionalDatesArray()[2]) {
												if(elem.equals(newBirthYear)) {
													error = false;
													break;
												}
											}

											if(error == true) {
												System.out.println(exception.getException("ErrorBirthDates"));
											}
										}
										newBirthYearInt = Integer.parseInt(newBirthYear);
										error = true;

										while(error != false) {
											System.out.print(prop.getProperty("Confirm_change_birthYear"));
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
											changeBirthYear = true;
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
								library.userEdition(changeFirstName, changeLastName, changeSex, changeEmail, changePassword, changeBirthDay, changeBirthMonth, changeBirthYear, newFirstName, newLastName, newSex, newEmail, newPassword, newBirthDayInt, newBirthMonthInt, newBirthYearInt, user);
								break;
							case 3:
								user.printData(prop);
								break;
							case 4:
								if(user.getObjectsOnLoan().size() > 0) {
									consoleEntrance = new Scanner(System.in);

									String choose = "";
									while(error != false) {
										System.out.print(prop.getProperty("User_repayOrExtend"));
										choose = consoleEntrance.nextLine();

										if((!choose.equals("1")) && (!choose.equals("2"))) {
											System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
										}else {
											error = false;
										}
									}
									int chooseInt = Integer.parseInt(choose);
									error = true;

									if(chooseInt == 1) {
										System.out.println(prop.getProperty("User_yourObjectsOnLoan"));
										user.printObjectsOnLoan(prop);

										String item = "";
										while(error != false) {
											System.out.print(prop.getProperty("User_objectToRepay"));
											item = consoleEntrance.nextLine();

											if(user.foundElem(item)) {
												error = false;
											}else {
												System.out.println(exception.getException("ErrorObjectNotFound"));
											}
										}
										error = true;

										ObjectsOnLoan object = user.getObjectOnLoan(item);
										boolean[] overPassedTime = object.overPassedTime(object.getTimeOnLoan());

										boolean toMuchTime = false;
										if(overPassedTime[1] != true) {
											if(overPassedTime[0] == true) {
												int sanction = object.sanctions(object.getTimeOnLoan());

												if(sanction == 0) {
													System.out.print(exception.getException("ErrorToMuchTime"));
													toMuchTime = true;
													option2 = "11";
													option = "4";
												}else if(sanction == 14) {
													user.removeObjectOnLoan(object);
													if(object.getClass().getSimpleName().equals("BooksOnLoan")) {
														Book book = library.getBook(item);
														library.returnLoanObject(book);
													}else if(object.getClass().getSimpleName().equals("VideoGamesOnLoan")){
														VideoGames videogame = library.getVideogame(item);
														library.returnLoanObject(videogame);
													}
													System.out.println(exception.getException("ErrorOverpassedTime"));
													System.out.print(prop.getProperty("User_timeOfSanction") + sanction + " days.");
													user.addSanction(new Sanctions(object.getName(), sanction, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR)));
												}else {
													user.removeObjectOnLoan(object);
													if(object.getClass().getSimpleName().equals("BooksOnLoan")) {
														Book book = library.getBook(item);
														library.returnLoanObject(book);
													}else if(object.getClass().getSimpleName().equals("VideoGamesOnLoan")){
														VideoGames videogame = library.getVideogame(item);
														library.returnLoanObject(videogame);
													}
													System.out.println(exception.getException("ErrorOverPassedTime"));
													System.out.print(prop.getProperty("User_timeOfSanction") + sanction + " months.");
													user.addSanction(new Sanctions(object.getName(), sanction, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR)));
												}
												if(toMuchTime == true) {
													Vector<ObjectsOnLoan> allObjectsOnLoan = user.getObjectsOnLoan();

													for(ObjectsOnLoan elem : allObjectsOnLoan) {
														if(elem.getClass().getSimpleName().equals("BooksOnLoan")) {
															Book book = library.getBook(elem.getName());
															library.returnLoanObject(book);
														}else if(elem.getClass().getSimpleName().equals("VideoGamesOnLoan")) {
															VideoGames videogame = library.getVideogame(elem.getName());
															library.returnLoanObject(videogame);
														}
													}
													System.out.println(prop.getProperty("User_dropOut"));
													library.dropOutUser(user);
												}
											}else if(overPassedTime[0] == false){
												user.removeObjectOnLoan(object);
												if(object.getClass().getSimpleName().equals("BooksOnLoan")) {
													Book book = library.getBook(item);
													library.returnLoanObject(book);
												}else if(object.getClass().getSimpleName().equals("VideoGamesOnLoan")){
													VideoGames videogame = library.getVideogame(item);
													library.returnLoanObject(videogame);
												}
												System.out.println(prop.getProperty("User_itemReturn"));
											}
										}else {
											System.out.println(exception.getException("ErrorWrongYearData"));
										}
									}else if(chooseInt == 2) {
										if(user.getObjectsOnLoan().size() > 0) {
											System.out.println(prop.getProperty("User_yourObjectsOnLoan"));
											user.printObjectsOnLoan(prop);

											String item = "";
											while(error != false) {
												System.out.print(prop.getProperty("User_objectToExtendTimeOfLoan"));
												item = consoleEntrance.nextLine();

												if(user.foundElem(item)) {
													error = false;
												}else {
													System.out.println(exception.getException("ErrorObjectNotFound"));
												}
											}
											error = true;

											ObjectsOnLoan object = user.getObjectOnLoan(item);
											boolean[] overPassedTime = object.overPassedTime(object.getTimeOnLoan());

											boolean toMuchTime = false;
											if(overPassedTime[1] != true) {
												if(overPassedTime[0] == true) {
													int sanction = object.sanctions(object.getTimeOnLoan());

													if(sanction == 0) {
														System.out.print(exception.getException("ErrorToMuchTime"));
														toMuchTime = true;
														option2 = "11";
														option = "4";
													}else if(sanction == 14) {
														user.removeObjectOnLoan(object);
														if(object.getClass().getSimpleName().equals("BooksOnLoan")) {
															Book book = library.getBook(item);
															library.returnLoanObject(book);
														}else if(object.getClass().getSimpleName().equals("VideoGamesOnLoan")){
															VideoGames videogame = library.getVideogame(item);
															library.returnLoanObject(videogame);
														}
														System.out.println(exception.getException("ErrorOverpassedTime"));
														System.out.print(prop.getProperty("User_timeOfSanction") + sanction + " days.");
														user.addSanction(new Sanctions(object.getName(), sanction, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR)));
													}else {
														user.removeObjectOnLoan(object);
														if(object.getClass().getSimpleName().equals("BooksOnLoan")) {
															Book book = library.getBook(item);
															library.returnLoanObject(book);
														}else if(object.getClass().getSimpleName().equals("VideoGamesOnLoan")){
															VideoGames videogame = library.getVideogame(item);
															library.returnLoanObject(videogame);
														}
														System.out.println(exception.getException("ErrorOverpassedTime"));
														System.out.print(prop.getProperty("User_timeOfSanction") + sanction + " months.");
														user.addSanction(new Sanctions(object.getName(), sanction, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR)));
													}
													if(toMuchTime == true) {
														Vector<ObjectsOnLoan> allObjectsOnLoan = user.getObjectsOnLoan();

														for(ObjectsOnLoan elem : allObjectsOnLoan) {
															if(elem.getClass().getSimpleName().equals("BooksOnLoan")) {
																Book book = library.getBook(elem.getName());
																library.returnLoanObject(book);
															}else if(elem.getClass().getSimpleName().equals("VideoGamesOnLoan")) {
																VideoGames videogame = library.getVideogame(elem.getName());
																library.returnLoanObject(videogame);
															}
														}
														System.out.println(prop.getProperty("User_dropOut"));
														library.dropOutUser(user);
													}
												}else if(overPassedTime[0] == false){
													if(!user.extendTwoTimes()) {
														user.extendLoanTime(object);
													}else {
														user.removeObjectOnLoan(object);
														if(object.getClass().getSimpleName().equals("BooksOnLoan")) {
															Book book = library.getBook(item);
															library.returnLoanObject(book);
														}else if(object.getClass().getSimpleName().equals("VideoGamesOnLoan")){
															VideoGames videogame = library.getVideogame(item);
															library.returnLoanObject(videogame);
														}
														System.out.println(exception.getException("ErrorTwoTimesLoan"));
													}
												}
											}else {
												System.out.println(exception.getException("ErrorWrongYearData"));
											}
										}
									}
								}else {
									System.out.println(prop.getProperty("User_noObjectsOnLoan"));
								}
								break;
							case 5:
								if(user.getObjectsOnLoan().size() > 0) {
									System.out.println(prop.getProperty("User_yourObjectsOnLoan"));
									user.printObjectsOnLoan(prop);

									Vector<Vector<ObjectsOnLoan>> allObjectsOnLoan = user.lateLoan();

									Vector<ObjectsOnLoan> lateLoanObjects = allObjectsOnLoan.elementAt(0);
									Vector<ObjectsOnLoan> earlyLoanObjects = allObjectsOnLoan.elementAt(1);
									int i = 1;

									System.out.println(prop.getProperty("User_delayedReturns"));
									System.out.println(prop.getProperty("User_delayedReturns1"));
									if(lateLoanObjects.size() > 0) {
										for(ObjectsOnLoan elem : lateLoanObjects) {
											int sanction = elem.sanctions(elem.getTimeOnLoan());
											if(sanction != 1000) {
												System.out.print(i + "." + elem.getName() + ", " + prop.getProperty("User_sanction"));
												if(sanction == 0) {
													System.out.println(exception.getException("ErrorToMuchTime"));
												}else if(sanction == 14) {
													System.out.println(sanction + " days.");
												}else {
													System.out.println(sanction + " months");
												}
											}else {
												System.out.println(i + "." + elem.getName() + ", " + prop.getProperty("User_WrongYearData"));
											}
											i++;
										}
										System.out.println("");
									}else {
										System.out.println(prop.getProperty("User_none"));
									}

									i = 1;
									System.out.println(prop.getProperty("User_returns"));
									System.out.println(prop.getProperty("User_returns1"));
									if(earlyLoanObjects.size() > 0) {
										for(ObjectsOnLoan elem : earlyLoanObjects) {
											System.out.print(i + "." + elem.getName());
											i++;
										}
										System.out.println("");
									}else {
										System.out.println(prop.getProperty("User_none"));
									}

									if(lateLoanObjects.size() > 0) {
										boolean toMuchTime = false;
										for(ObjectsOnLoan elem : lateLoanObjects) {
											int sanction = elem.sanctions(elem.getTimeOnLoan());
											if(sanction == 0) {
												if(elem.getClass().getSimpleName().equals("BooksOnLoan")) {
													Book book = library.getBook(elem.getName());
													library.returnLoanObject(book);
												}else if(elem.getClass().getSimpleName().equals("VideoGamesOnLoan")){
													VideoGames videogame = library.getVideogame(elem.getName());
													library.returnLoanObject(videogame);
												}
												toMuchTime = true;
											}else {
												user.removeObjectOnLoan(elem);
												if(elem.getClass().getSimpleName().equals("BooksOnLoan")) {
													Book book = library.getBook(elem.getName());
													library.returnLoanObject(book);
												}else if(elem.getClass().getSimpleName().equals("VideoGamesOnLoan")){
													VideoGames videogame = library.getVideogame(elem.getName());
													library.returnLoanObject(videogame);
												}
												user.addSanction(new Sanctions(elem.getName(), sanction, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR)));
											}
										}

										if(toMuchTime == true) {
											System.out.println(exception.getException("ErrorToMuchTime"));
											for(ObjectsOnLoan elem : earlyLoanObjects) {
												if(elem.getClass().getSimpleName().equals("BooksOnLoan")) {
													Book book = library.getBook(elem.getName());
													library.returnLoanObject(book);
												}else if(elem.getClass().getSimpleName().equals("VideoGamesOnLoan")) {
													VideoGames videogame = library.getVideogame(elem.getName());
													library.returnLoanObject(videogame);
												}
											}
											System.out.println(prop.getProperty("User_dropOut"));
											library.dropOutUser(user);
											option2 = "11";
											option = "4";
										}

										if(!toMuchTime) {
											if(lateLoanObjects.size() != 0) {
												System.out.println(prop.getProperty("User_removeObjectsOnLoan"));
												System.out.println("");
											}

											String option3 = "";
											while(error != false) {
												System.out.print(prop.getProperty("User_askRepayAllObjects"));
												option3 = consoleEntrance.nextLine();

												if((!option3.equals("1")) && (!option3.equals("2"))) {
													System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
												}else {
													error = false;
												}
											}
											int option3Int = Integer.parseInt(option3);
											error = true;

											if(option3Int == 1) {
												for(ObjectsOnLoan elem : earlyLoanObjects) {
													user.removeObjectOnLoan(elem);
													if(elem.getClass().getSimpleName().equals("BooksOnLoan")) {
														Book book = library.getBook(elem.getName());
														library.returnLoanObject(book);
													}else if(elem.getClass().getSimpleName().equals("VideoGamesOnLoan")) {
														VideoGames videogame = library.getVideogame(elem.getName());
														library.returnLoanObject(videogame);
													}
												}
											}else if(option3Int == 2) {}
										}
									}
								}else {
									System.out.println(prop.getProperty("User_noObjectsOnLoan"));
								}
								break;
							case 6:
								user.printSanctions(prop);

								if(user.getSanctions().size() > 0) {
									System.out.println(user.totalAmountOfSanctions());
								}
								break;
							case 7:
								user.printTimeToDeliver(prop);
								break;
							case 8:
								if(user.getObjectsOnLoan().size() > 0) {
									consoleEntrance = new Scanner(System.in);
									System.out.println(prop.getProperty("User_yourObjectsOnLoan"));
									user.printAllData(prop);

									String searchOrNot = "";
									while(!searchOrNot.equals("2")) {
										String object = "";
										while(error != false){
											System.out.print(prop.getProperty("User_chooseObject"));
											object = consoleEntrance.nextLine();

											if(user.foundElem(object)) {
												error = false;
											}else {
												System.out.println(exception.getException("ErrorObjectNotFound"));
											}
										}
										error = true;

										ObjectsOnLoan item = user.getObjectOnLoan(object);
										item.printData(prop);

										while(error != false) {
											System.out.print(prop.getProperty("User_searchOrNot"));
											searchOrNot = consoleEntrance.nextLine();

											if((!searchOrNot.equals("1")) && (!searchOrNot.equals("2"))) {
												System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
											}else {
												error = false;
											}
										}
										error = true;
									}
								}else {
									System.out.println(prop.getProperty("User_noObjectsOnLoan"));
								}
								break;
							case 9:
								consoleEntrance = new Scanner(System.in);
								if(user.getRewards().size() > 0) {
									Vector<Vector<Rewards>> rewards = user.separateRewards();

									System.out.println(prop.getProperty("User_integerPrizes"));
									System.out.println(prop.getProperty("User_integerPrizes1"));
									if(rewards.elementAt(0).size() > 0) {
										if(rewards.elementAt(0).size() == 1) {
											System.out.println(prop.getProperty("User_havePrizes") + rewards.elementAt(0).size() + prop.getProperty("User_onePrize"));
										}else {
											System.out.println(prop.getProperty("User_havePrizes") + rewards.elementAt(0).size() + prop.getProperty("User_havePrizes1"));
										}
										System.out.println("");

										String answer = "";
										while(error != false) {
											System.out.print(prop.getProperty("User_ask_usePrizes"));
											answer = consoleEntrance.nextLine();

											if((!answer.equals("1")) && (!answer.equals("2"))) {
												System.out.println(exception.getException("ErrorIntegerOutOfBounds"));
											}else {
												error = false;
											}
										}
										int answerInt = Integer.parseInt(answer);
										error = true;

										if(answerInt == 1) {
											if(user.getSanctions().size() > 0) {
												user.useIntegerRewards(rewards.elementAt(0));
											}else {
												System.out.println(prop.getProperty("User_noSanctions"));
											}
										}else if(answerInt == 2) {}
									}else {
										System.out.println(prop.getProperty("User_noIntegerPrizes"));
									}

									System.out.println(prop.getProperty("User_stringPrizes"));
									System.out.println(prop.getProperty("User_stringPrizes1"));
									if(rewards.elementAt(1).size() > 0) {
										if(rewards.elementAt(1).size() == 1) {
											System.out.println(prop.getProperty("User_havePrizes") + rewards.elementAt(1).size() + prop.getProperty("User_onePrize"));
										}else {
											System.out.println(prop.getProperty("User_havePrizes") + rewards.elementAt(1).size() + prop.getProperty("User_havePrizes1"));
										}
										System.out.println("");

										String answer = "";
										while(error != false) {
											System.out.print(prop.getProperty("User_ask_usePrizes"));
											answer = consoleEntrance.nextLine();

											if((!answer.equals("1")) && (!answer.equals("2"))) {
												System.out.println(exception.getException("ErrorIntegerOutOfBouns"));
											}else {
												error = false;
											}
										}
										int answerInt = Integer.parseInt(answer);
										error = true;

										if(answerInt == 1) {
											Vector<LoanObjects> loanObjects= library.getLoanObjects();
											Vector<Rewards> stringRewards = rewards.elementAt(1);

											for(int i = 0; i < stringRewards.size(); i++) {
												for(LoanObjects elem : loanObjects) {
													if(elem.getName().equals(stringRewards.elementAt(i).getValue())) {
														if(elem.getClass().getSimpleName().equals("Book")) {
															Book bookElem = (Book) elem;
															user.addObjectOnLoan(new BooksOnLoan(bookElem.getName(), bookElem.getAuthor(), bookElem.getPublicationDay(), bookElem.getPublicationMonth(), bookElem.getPublicationYear(), bookElem.getGenre(), bookElem.getNumberOfPages(), bookElem.getISBN()));
															user.extendRewardObjectsTime(bookElem.getName());
														}else if(elem.getClass().getSimpleName().equals("VideoGames")) {
															VideoGames videogame = (VideoGames) elem;
															user.addObjectOnLoan(new VideoGamesOnLoan(videogame.getName(), videogame.getPublicationDay(), videogame.getPublicationMonth(), videogame.getPublicationYear(), videogame.getGenre(), videogame.getGameModes(), videogame.getLastVersion(), videogame.getComposers(), videogame.getDevelopers(), videogame.getPlatforms()));
															user.extendRewardObjectsTime(videogame.getName());
														}
														break;
													}
												}
												user.removeRewards(stringRewards.elementAt(i));
											}
										}else if(answerInt == 2) {}
									}else {
										System.out.println(prop.getProperty("User_noStringPrizes"));
									}
								}else {
									System.out.println(prop.getProperty("User_notPrizes"));
								}
								break;
							case 10:
								option2 = "11";
								option = "";
								break;
							case 11:
								option2 = "11";
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

								if(library.searchLoanObjectsByName(bookName)) {
									Book book = library.getBook(bookName);
									if(book != null) {
										book.printData(prop);
									}else {
										System.out.println(prop.getProperty("LoanObjects_wrongBook"));
									}
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

											if(library.searchLoanObjectsByName(book)) {
												Book elem = library.getBook(book);
												if(elem != null) {
													elem.printData(prop);
												}else {
													System.out.println(prop.getProperty("LoanObjects_wrongBook"));
												}

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
								if(user.getSanctions().size() == 0) {
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

										if(library.searchLoanObjectsByName(book)) {
											Book elem = library.getBook(book);
											if(elem != null) {
												int stock = library.getNumberInStock(book);
												if(stock > 0) {
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
														user.addObjectOnLoan(new BooksOnLoan(elem.getName(), elem.getAuthor(), elem.getPublicationDay(), elem.getPublicationMonth(), elem.getPublicationYear(), elem.getGenre(), elem.getNumberOfPages(), elem.getISBN()));
													}else if(yesNoInt == 2) {}
												}else if(stock == 0) {
													System.out.println(prop.getProperty("Book_not_stock_now") + book + " " + prop.getProperty("Book_not_stock_now1"));
												}
											}else {
												System.out.println(prop.getProperty("LoanObjects_wrongBook"));
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

											if(library.searchLoanObjectsByName(book1)) {
												Book elem = library.getBook(book1);
												if(elem != null) {
													int stock = library.getNumberInStock(book1);
													if(stock > 0) {
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
															user.addObjectOnLoan(new BooksOnLoan(elem.getName(), elem.getAuthor(), elem.getPublicationDay(), elem.getPublicationMonth(), elem.getPublicationYear(), elem.getGenre(), elem.getNumberOfPages(), elem.getISBN()));
														}else if(yesNo1Int == 2) {}
													}else if(stock == 0){
														System.out.println(prop.getProperty("Book_not_stock_now") + book1 + " " + prop.getProperty("Book_not_stock_now1"));
													}
												}else {
													System.out.println(prop.getProperty("LoanObjects_wrongBook"));
												}
											}else {
												System.out.println(prop.getProperty("Book_not_stock") + book1 + " " + prop.getProperty("Book_not_stock1"));
											}
										}else {
											System.out.println(prop.getProperty("Not_author_books") + authorName1);
										}
									}
								}else {
									System.out.println(exception.getException("ErrorHaveSanctions"));
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

								if(library.searchLoanObjectsByName(videogame)) {
									VideoGames videogame1 = library.getVideogame(videogame);
									if(videogame1 != null) {
										videogame1.printData(prop);
									}else {
										System.out.println(prop.getProperty("LoanObjects_wrongVideogame"));
									}
								}else {
									System.out.println(prop.getProperty("Videogame_not_stock") + videogame + prop.getProperty("Videogame_not_stock1"));
								}
								break;
							case 2:
								if(user.getSanctions().size() == 0) {
									consoleEntrance = new Scanner(System.in);
									System.out.print(prop.getProperty("Introduce_videogame_name"));
									String videogame1 = consoleEntrance.nextLine();

									if(library.searchLoanObjectsByName(videogame1)) {
										VideoGames elem = library.getVideogame(videogame1);
										if(elem != null) {
											int stock = library.getNumberInStock(videogame1);
											if(stock > 0) {
												elem.printData(prop);

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
													user.addObjectOnLoan(new VideoGamesOnLoan(elem.getName(), elem.getPublicationDay(), elem.getPublicationMonth(), elem.getPublicationYear(), elem.getGenre(), elem.getGameModes(), elem.getLastVersion(), elem.getComposers(), elem.getDevelopers(), elem.getPlatforms()));
												}else if(yesNoInt == 2){}
											}else if(stock == 0){
												System.out.println(prop.getProperty("Videogame_not_stock_now") + videogame1 + " " + prop.getProperty("Videogame_not_stock_now1"));
											}
										}else {
											System.out.println(prop.getProperty("LoanObjects_wrongVideogame"));
										}
									}else {
										System.out.println(prop.getProperty("Videogame_not_stock") + videogame1 + " "  + prop.getProperty("Videogame_not_stock1"));
									}
								}else {
									System.out.println(exception.getException("ErrorHaveSanctions"));
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
