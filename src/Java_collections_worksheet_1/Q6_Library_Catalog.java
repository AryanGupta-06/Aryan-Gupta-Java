package Java_collections_worksheet_1;

import java.util.*;

class Book {
    String title;
    String author;
    int publicationYear;
    String isbn;

    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

public class Q6_Library_Catalog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<Book>> libraryCatalog = new HashMap<>();

        System.out.println("Enter the number of books:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter book title:");
            String title = scanner.nextLine();

            System.out.println("Enter book author:");
            String author = scanner.nextLine();

            System.out.println("Enter book publication year:");
            int publicationYear = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter book ISBN:");
            String isbn = scanner.nextLine();

            System.out.println("Enter book genre:");
            String genre = scanner.nextLine();

            Book book = new Book(title, author, publicationYear, isbn);

            libraryCatalog.putIfAbsent(genre, new HashSet<>());
            libraryCatalog.get(genre).add(book);
        }

        System.out.println("Enter the genre to print books:");
        String genreToPrint = scanner.nextLine();

        if (libraryCatalog.containsKey(genreToPrint)) {
            List<Book> booksInGenre = new ArrayList<>(libraryCatalog.get(genreToPrint));
            booksInGenre.sort(Comparator.comparingInt(book -> book.publicationYear));

            System.out.println("Books in genre " + genreToPrint + " sorted by publication year:");
            for (Book book : booksInGenre) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found in genre " + genreToPrint);
        }
    }
}

