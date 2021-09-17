package org.howard.edu.lsp.assignment2;


public class Book { 
	private boolean borrowed;
	private String title; 
/**
 * User can set the title in the constructor
 * @param title attribute gives the name of the book
 */
	// Creates a new Book 
	public Book(String title) {
		/*
		 * This constructor sets up the attributes, including the parameter
		 */
		this.title = title;
		this.borrowed = false;
	}
	/**
	 * Sets the borrowed boolean to true to determine that the book has been checked out
	 */
	public void borrowed() { // Implement this method } 
	// Marks the book as not rented
		this.borrowed = true;
	}
	
	/**
	 * Sets the borrowed boolean to false to determine that the book is returned back in the library
	 */
	
	public void returned() { // Implement this method } 
		this.borrowed = false;
	}
	
	/**
	 * Gets the boolean that determines if this book is in the catalogue
	 * @return whether or not it is already borrowed
	 */
	public boolean isBorrowed() {
		return this.borrowed; // Implement this method } 
	// Returns the title of the book public 
	}
	/**
	 * @return gets the title of the book
	 */
	public String getTitle() { // Implement this method
		return this.title;
	}
}
