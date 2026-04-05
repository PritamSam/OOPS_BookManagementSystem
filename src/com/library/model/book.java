package com.library.model;

public class book {

	//Encapsulation
	private int bookId;
	private String title;
	private String author;
	private String genere;
	private boolean setavailability;
	
	
	//Parameterized Constructor
	public book(int bookId,String title,String author,String genere)
	{
		this.bookId=bookId;
		this.title=title;
		this.author=author;
		this.genere=genere;
		this.setavailability=true;
	}
	
	
    //Getters
	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenere() {
		return genere;
	}

	public boolean isSetavailability() {
		return setavailability;
	}

	//Setters
	public void updateAvailability(boolean setavailability) {
		this.setavailability = setavailability;
	}


	//Method to display book details
	public void displayDetails() {
		System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genere);
        System.out.println("Available: " + (setavailability ? "Yes" : "No"));
	}
	
	//Mtehod to issue book
	public void issueBook() {
        if (setavailability) {
        	setavailability = false;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Method to return book
    public void returnBook() {
        setavailability = true;
        System.out.println("Book returned successfully.");
    }


	


	
}
