# JavaLibraryPractice
This repository is the home of my Java library proyect, in which i make available a grafic interface for libraries where they can be borrow books and videogames.

# Classes of the proyect
- Book: The Book class is a daughter class which contains all its attributes and also the attributes of the superclass from which it inherit, and the methods that will manage them. Their can be initialize book type objects that will be from which users would request a loan.

- Videogames: The Videogame class is a daughter class which contains all its attributes and also the attributes of the superclass from which it inherit, and the methods that will manage them. Their can be initialize videogame type objects that will be from which users, as with the book type objects, would request a loan.

- LoanObjects: I created the class LoanObjects as an abstract superclass from which it is not possible to initialize objects. The book and videogame classes are the daughter classes of the superclass LoanObjects, which inherit all their attributes and methods. And the super class LoanObjects also houses an abstract method named printAllData, so that each daughter class can use it to show its own data.

- BooksOnLoan: The BooksOnLoan class is a daughter class which contains all its attributes and also the attributes of the superclass from which it inherit, and the methods that will manage them. Their can be initialize BooksOnLoan type objects that will be created after the user makes any loan of a book. This objects will represent the borrowed books by the user, and they have unlike the books objects, attributes for the moment of the loan, which will be used to calculate the time of loan and the time until the delivery.

- VideoGamesOnLoan: The VideoGamesOnLoan class is a daughter class which contains all its attributes and also the attributes of the superclass from which it inherit, and the methods that will manage them. Their can be initialize VideoGamesOnLoan type objects that will be created after the user makes any loan of a videogame. This objects will represent the borrowed videogames by the user, and they have as the BooksOnLoanObjects, attributes for the moment of the loan, which will be used to calculate the time of the loan and the time until the delivery.

- ObjectsOnLoan: The class ObjectsOnLoan is an abstract superclass from which it is not possible to initialize objects, the BooksOnLoan and VideoGamesOnLoan classes are the daughter classes of this superclass which inherit all their attributes and methods. This superclass houses some methods which are used to calculate all the time a book or a videogame has been on loan, also if the time has overpassed the maximum time of loan, the sanctions for that overpassed time and also a method to calculate the time until the day od deliver.

- Sanctions: This class is not a class with heritage, i used this class for a vector of sanctions inside the users class, so when any object have excided the time of loan an object of the type Sanctions is initialize and introduced insisde it. Inside the library the user can see which are his sanctions, the time until the sanctions is withdrawn and the total amount of sanctions in time.

- User: As the Book class, the User class contains all the attributes of the user type objects, in which will be all the data of the new users of the library when registered.

- Library: Library is a class in which i use encapsulation; i created two vectors, one of LoanObjects and another of users, as attributes of the class, then i used methods to manipulate the two of those, so that i can let users for example be able to unsubscribe or borrow books or videogames from the library.

- ObjectsInterface: This is an interface which contains methods that will be used in the ObjectsOnLoan class to calculate times of the objects on loan.

- MyException: MyException is a class which controls all the type of errors the users could give since the application is initialize. It contains a hashtable as an atributte with all the errors that could be given as keys, and their values are shown to the user so he can fix them. It also contains some vectors for the errors of the birth date data.

- Interface: The interface class is the one where the menu is declared, it use control sentences to move between the different points of the menu and thus offer users the different services of the interface.

# Interface changes
I implemented a new interface for the ObjectsOnLoan class, this class will implement all the public methods that are in the interface. The methods of the interface will be used to calculate the loan time of an object and the time to deliver it among other things.

I also implemented another two classes, daughters of the superclass ObjectsOnLoan, that will be used as the books and videogames borrowed by the user in the library.
With all this i implemented lot more options in the user's menu, somo of them are watch the profile with all the data of the user, repay the loans or extend the time of the loan, also i give the option to repay all the loans at the same time.
As i gived the user the option to make a loan, i had to enable the user to have penaltys for any delay in the return of the loan. For this penaltys i created the Sanctions class, so when a user repay a loan, the program looks if its being returned late, and in case it is true, then a sanction is added to the user.
For the user's options in what the sanctions refered at, i give the user the option to see the sanctions he has and also the day it is withdrawn and the time it has to be passed until the withdrawn day. For this last option i give also the total amount of time for all the sanctions the user has.
As i give the options to see the characteristics of the books and the videogames in the other menus, i gived the user the option to see all the loans he has and to see the characteristics of them.

# Internationalization
The main language for the application is english from the United Kingdom(en,UK), but this are other languages that can be used in the aplication:
- Spanish from Spain(es,ES)
- Japanish(ja,JP)

# Files
There are three files from which i get the books and videogames for the aplication. The data of the books and videogames are also internationalized so there is one file for each language. All the data of the files is transformed into objects inside the library class with an algorithm.

# Tests
For the libraries i used a source folder called src, so to avoid problems with the classes in that folder i created another source folder called test, in which i have the tests of the classes of the other folder.
I created tests for some classes as the LoanObjects, Library or user classes among others. For this test i created some examples to verify that all the methods worked correctly, in addition to creating for other methods several examples to verify that they could fail and that the exceptions were well collected.
I also created tests for the interface of the objects on loan and for the internationalization.

# Authors
- Manuel Barrenechea Gonzalez - All the work.

# Licence
As the repository is not open code, it is not need any licence.
