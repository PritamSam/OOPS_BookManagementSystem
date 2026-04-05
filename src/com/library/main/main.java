package com.library.main;

import java.util.Scanner;

import com.library.model.book;
import com.library.model.user;
import com.library.service.library;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        library lib = new library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Add Book
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();

                    book b = new book(bookId, title, author, genre);
                    lib.addBook(b);
                    break;

                case 2:
                    // Add User
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    user u = new user(userId, name);
                    lib.addUser(u);
                    break;

                case 3:
                    // Issue Book
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();

                    lib.issueBook(bId, uId);
                    break;

                case 4:
                    // Return Book
                    System.out.print("Enter Book ID: ");
                    int rbId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int ruId = sc.nextInt();

                    lib.returnBook(rbId, ruId);
                    break;

                case 5:
                    // Search Book
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String searchTitle = sc.nextLine();

                    lib.searchByTitle(searchTitle);
                    break;

                case 6:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
	}

}
