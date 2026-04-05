package com.library.model;

import java.util.ArrayList;

public class user {

	//Attributes (Encapsulation)
	private int userId;
	private String name;
	private ArrayList<book> borrowedBooks;
	
	// Constructor
    public user(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<book> getBorrowedBooks() {
        return borrowedBooks;
    }
	
    // Method to borrow a book (Association)
    public void borrowBook(book book) {
        if (book.isSetavailability()) {
            borrowedBooks.add(book);
            book.issueBook();
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Method to return a book
    public void returnBook(book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }

    // Display user details
    public void displayUserDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Borrowed Books:");

        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (book book : borrowedBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }
}
