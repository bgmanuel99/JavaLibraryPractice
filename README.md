# JavaLibraryPractice
This repository is the home of my Java library proyect, in which i make available a grafic interface for libraries where they can be borrow books.

# Classes of the proyect
- Book: The Book class is a daughter class which contains all its attributes and also the attributes of the superclass from which it inherit, and the methods that will manage them. Their can be initialize book type objects that will be from which users would request a loan.

- Videogames: The Videogame class is a daughter class which contains all its attributes and also the attributes of the superclass from which it inherit, and the methods that will manage them. Their can be initialize videogame type objects that will be from which users, as with the book type objects, would request a loan.

- LoanObjects: I created the class LoanObjects as an abstract superclass from which it is not possible to initialize objects. The book and videogame classes are the daughter classes of the superclass LoanObjects, which inherit all their attributes and methods. And the super class LoanObjects also houses an abstract method named printAllData, so that each daughter class can use it to show its own data.

- User: As the Book class, the User class contains all the attributes of the user type objects, in which will be all the data of the new users of the library when registered.

- Library: Library is a class in which i use encapsulation; i created two vectors, one of LoanObjects and another of users, as attributes of the class, then i used methods to manipulate the two of those, so that i can let users for example be able to unsubscribe or borrow books or videogames from the library.

- MyException: MyException is a class which controls all the type of errors the users could give since the application is initialize. It contains a hashtable as an atributte with all the errors that could be given as keys, and their values are shown to the user so he can fix them. It also contains some vectors for the errors of the birth date data.

- Interface: The interface class is the one where the menu is declared, it use control sentences to move between the different points of the menu and thus offer users the different services of the interface.

# Tests
For the libraries i used a source folder called src, so to avoid problems with the classes in that folder i created another source folder called test, in which i have the tests of the classes of the other folder.

# Authors
- Manuel Barrenechea Gonzalez - All the work.

# Licence
As the repository is not open code, it is not need any licence.
