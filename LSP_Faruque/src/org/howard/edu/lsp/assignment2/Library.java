package org.howard.edu.lsp.assignment2;

import java.util.ArrayList;

public class Library {
	private String hours;
	private String address;
	private ArrayList<Book> books = new ArrayList<Book>();

	// Add the missing implementation (methods and data definitions) to this class 
	// Constructor – look it up
	/**
	 * User can set the address in the constructor
	 * @param address : sets the location of the library
	 */	
	public Library(String address) {
		this.address = address;
		hours = "9 am to 5 pm";
		}
	/**
	 * @return Prints the hours that the library is open;
	 * all libraries have a defined opening time in the constructor that cannot be modified
	 */
	void printOpeningHours() 
	{
		System.out.println(hours);
	}
	/**
	 * @return the address of the library
	 */
	void printAddress() {
		System.out.println(address);
	}
	/**
	 * User can add a book object in the arraylist books within the library
	 * @param book creates the book object;
	 * the user provides the title attribute themselves
	 */	
	void addBook(Book book) 
	{
			books.add(book);
	}
	/**
	 * Prints all the available books in the library list.
	 * If the size of the books arraylist is empty,
	 * or if the number of false booleans in isBorrowed is same as arraylist,
	 * then it prints that no books are available.
	 * 
	 * Otherwise it prints all the book titles in the list.
	 */	
	void printAvailableBooks() {
        if (books.size() == 0) {
            System.out.println("There are no books available");
        } else {
        	for (int i = 0; i < books.size(); i++) {
        		int c = 0;
        		if (!books.get(i).isBorrowed()) {
        			System.out.println(books.get(i).getTitle());
        		}
        		else {
        			c++;
        		}
        		if (c==books.size()) {
        			System.out.println("There are no books available");
        }
        }
    }
	}
	
	/**
	 * 
	 * This method traverses the book arraylist to see if such book is available by checking the titles.
	 * If no such book is available in the list, then it informs the user that there is no book in the catalogue.
	 * 
	 * If book title does match, then it checks the boolean if it is already borrowed.
	 * If so, then it switches to true.
	 * Otherwise, the search continues until a book is found or there are no more elements in the arraylist.
	 * @param title is the name of the book the user wants to borrow from the library.
	 */
	

	void borrowBook(String title)
	{
        System.out.println("Borrowing the " + title);
        int foundIndex = Integer.MIN_VALUE;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex >= 0) {
            if (!books.get(foundIndex).isBorrowed()) {
                books.get(foundIndex).borrowed();
                System.out.print("You successfully borrowed "); System.out.println(books.get(foundIndex).getTitle());
            } else {
                System.out.println("Sorry, this book is already borrowed.");
            }
        } else {
            System.out.println("Sorry, this book is not in our catalog.");
        }

    }
	
	/**
	 * 
	 * This method traverses the book arraylist to see if such book was already in the catalog.
	 * If no such book is available in the list, then it informs the user that there was no book in the catalog.
	 * 
	 * If book title does match, then it checks the borrowed boolean to see if it is already available.
	 * If so, then it switches to false.
	 * Otherwise, the user is informed that a copy of the book already exists, and the search continues until a book has a true boolean or there are no more elements in the arraylist.
	 * @param title is the name of the book the user wants to return to the library.
	 */
	
	void returnBook(String title) {
        int foundIndex = Integer.MIN_VALUE;
        System.out.println("Returning the book " + title);
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                foundIndex = i;
            }
        }
        if (foundIndex >= 0) {
            if (books.get(foundIndex).isBorrowed()) {
                books.get(foundIndex).returned();
                System.out.println("Book returned.");
            } else {
                System.out.println("A copy of this book already exists.");
            }
        } else {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }


	public static void main(String[] args) {
		// Create two libraries 
		Library firstLibrary = new Library("10 Main St."); 
		Library secondLibrary = new Library("228 Liberty St."); 

		// Add four books to the first library 
		firstLibrary.addBook(new Book("The Da Vinci Code")); firstLibrary.addBook(new Book("Le Petit Prince")); 
		firstLibrary.addBook(new Book("A Tale of Two Cities")); firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Print opening hours and the addresses 
		System.out.println("Library hours:");
		firstLibrary.printOpeningHours(); 
		System.out.println("Library addresses:"); 
		firstLibrary.printAddress(); 
		System.out.println(); 
		System.out.println("Library hours:");
		secondLibrary.printOpeningHours(); 
		System.out.println("Library addresses:"); 
		secondLibrary.printAddress(); 
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries System.out.println("Borrowing The Lord of the Rings:"); firstLibrary.borrowBook("The Lord of the Rings"); 
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings"); 
		System.out.println(); 

		// Print the titles of all available books from both libraries System.out.println("Books available in the first library:"); firstLibrary.printAvailableBooks(); 
		System.out.println(); 
		System.out.println("Books available in the first library:"); firstLibrary.printAvailableBooks(); 
		System.out.println(); 
		System.out.println("Books available in the second library:"); secondLibrary.printAvailableBooks(); 
		System.out.println(); 

		// Return The Lords of the Rings to the first library 
		System.out.println("Returning The Lord of the Rings:"); firstLibrary.returnBook("The Lord of the Rings"); 
		System.out.println();
		System.out.println("Books available in the first library: "); firstLibrary.printAvailableBooks();


	}




}
