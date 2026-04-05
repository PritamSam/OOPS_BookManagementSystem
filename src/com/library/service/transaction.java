package com.library.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.library.model.book;
import com.library.model.user;

public class transaction {
	
	private book book;
    private user user;
    private Date issueDate;
    private Date returnDate;
    
    private static final int ALLOWED_DAYS = 7; 
    private static final double FINE_PER_DAY = 5.0;

    // Constructor
    public transaction(book book, user user, Date issueDate) {
        this.book = book;
        this.user = user;
        this.issueDate = issueDate;
        this.returnDate = null;
    }

    // Getters
    public book getBook() {
        return book;
    }

    public user getUser() {
        return user;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    // Setter for return date
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    //Fine Calculation
    public double calculateFine() {
        if (returnDate == null) {
            return 0.0;
        }

        long diffInMillis = returnDate.getTime() - issueDate.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(diffInMillis);

        if (days <= ALLOWED_DAYS) {
            return 0.0;
        }

        return (days - ALLOWED_DAYS) * FINE_PER_DAY;
    }

    // Display Transaction Details
    public void displayTransaction() {
        System.out.println("----- Transaction Details -----");
        System.out.println("User: " + user.getName());
        System.out.println("Book: " + book.getTitle());
        System.out.println("Issue Date: " + issueDate);

        if (returnDate != null) {
            System.out.println("Return Date: " + returnDate);
            System.out.println("Fine: " + calculateFine());
        } else {
            System.out.println("Status: Not Returned Yet");
        }
    }

}
