package com.library.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.model.book;
import com.library.model.user;

public class library{
	
	//Encapsulation
	private List<book> books;
    private List<user> users;
    private List<transaction> transactions;
    
    //Constructor
    public library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Add Book
    public void addBook(book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Remove Book
    public void removeBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
        System.out.println("Book removed successfully.");
    }

    // Search by Title
    public void searchByTitle(String title) {
        for (book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayDetails();
            }
        }
    }

    //Search by Author
    public void searchByAuthor(String author) {
        for (book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.displayDetails();
            }
        }
    }

    //Issue Book
    public void issueBook(int bookId, int userId) {
        book book = findBook(bookId);
        user user = findUser(userId);

        if (book != null && user != null && book.isSetavailability()) {
            book.updateAvailability(false);
            user.borrowBook(book);

            transaction t = new transaction(book, user, new Date());
            transactions.add(t);

            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book cannot be issued.");
        }
    }

    //Return Book
    public void returnBook(int bookId, int userId) {
        book book = findBook(bookId);
        user user = findUser(userId);

        if (book != null && user != null) {
            book.updateAvailability(true);
            user.returnBook(book);

            for (transaction t : transactions) {
                if (t.getBook().getBookId() == bookId && t.getUser().getUserId() == userId) {
                    t.setReturnDate(new Date());
                    double fine = t.calculateFine();
                    System.out.println("Book returned. Fine: " + fine);
                    return;
                }
            }
        }
    }

    //Helper: Find Book
    private book findBook(int bookId) {
        for (book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    //Helper: Find User
    private user findUser(int userId) {
        for (user user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    //Add User
    public void addUser(user user) {
        users.add(user);
    }
}

