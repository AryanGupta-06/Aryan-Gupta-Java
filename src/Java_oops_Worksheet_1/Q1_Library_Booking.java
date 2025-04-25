package Java_oops_Worksheet_1;

import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
    }

    public String getTitle() {
        return title;
    }
}

class Library {
    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public Book searchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
}

public class Q1_Library_Booking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(100);  // Assuming the library can hold up to 100 books

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            if (choice == 1) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                System.out.print("Enter book ISBN: ");
                String ISBN = scanner.nextLine();
                Book book = new Book(title, author, ISBN);
                library.addBook(book);
                System.out.println("Book added successfully.");
            } else if (choice == 2) {
                System.out.print("Enter the title of the book to search: ");
                String title = scanner.nextLine();
                Book book = library.searchByTitle(title);
                if (book != null) {
                    System.out.println("Book found:");
                    book.printDetails();
                } else {
                    System.out.println("Book not found.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting the library system.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
