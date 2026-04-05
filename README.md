This repository consist of Java Project which is build of core oops principles.
Summary -
## OOPS Principles in Your Project

| Class           | OOPS Principles Used |   Key Methods / Examples                                                                    |
|--------------   |--------------------- |---------------------------------------------------------------------------------------------|
| **Book**        | Encapsulation        | Private attributes (`bookId`, `title`, `author`, `genre`, `availability`) + Getters/Setters |
|                 | Abstraction          | `displayDetails()`, `issueBook()`, `returnBook()` – hides implementation                    |
| **User**        | Encapsulation        | Private attributes (`userId`, `name`, `borrowedBooks`) + Getters                            |
|                 | Abstraction          | `borrowBook()`, `returnBook()` – complex logic hidden                                       |
|                 | Association          | Maintains `ArrayList` of borrowed books (HAS-A relationship)                                |
| **Transaction** | Encapsulation        | Private attributes (`book`, `user`, `issueDate`, `returnDate`) + Getters/Setters            |
|                 | Abstraction          | `calculateFine()` – formula hidden, only result returned                                    |
|                 | Composition          | HAS-A `book` and `user` objects                                                             |
| **Library**     | Encapsulation        | Private lists (`books`, `users`, `transactions`)                                            |
|                 | Abstraction          | Methods like `addBook()`, `issueBook()`, `returnBook()` hide internal complexity            |
|                 | Composition          | Manages multiple `Book`, `User`, and `Transaction` objects                                  |
|                 | Data Hiding          | Private helper methods `findBook()`, `findUser()`                                           |
| **Main**        | Client Code          | Uses all classes through their public interfaces only                                       |

