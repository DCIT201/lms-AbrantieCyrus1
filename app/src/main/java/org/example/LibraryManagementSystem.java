import java.util.ArrayList;
import java.util.Scanner;

// This is a book class representing a single book
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }
}

// Library class to manage  collection of books
class Library {
    private ArrayList<Book> books;


    public Library() {
        books = new ArrayList<>();
    }


    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title);
    }

    // Method to borrow a book you want
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                book.borrowBook();
                System.out.println("You have borrowed: " + title);
                return;
            }
        }
        System.out.println("Sorry, the book is not available.");
    }

    // Method to return a book you want
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) {
                book.returnBook();
                System.out.println("You have returned: " + title);
                return;
            }
        }
        System.out.println("This book was not borrowed.");
    }

    // Method to display available books
    public void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;

                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case 4:
                    library.displayAvailableBooks();
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}