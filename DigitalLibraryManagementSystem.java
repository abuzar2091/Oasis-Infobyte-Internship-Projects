import java.util.*;

public class DigitalLibraryManagementSystem {

    private HashMap<String, Book> books;

    public DigitalLibraryManagementSystem() {
        this.books = new HashMap<>();
    }

    public void addBook(String bookId, Book book) {
        if (!books.containsKey(bookId)) {
            books.put(bookId, book);
        }
    }

    public Book getBook(String bookId) {
        return books.get(bookId);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DigitalLibraryManagementSystem library = new DigitalLibraryManagementSystem();

        while (true) {
            System.out.println("Welcome to the digital library management system. What would you like to do?");
            System.out.println("1. Add a book");
            System.out.println("2. View a book");
            System.out.println("3. List all books");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the book ID: ");
                    String bookId = scanner.next();

                    System.out.println("Enter the book title: ");
                    String bookTitle = scanner.next();

                    System.out.println("Enter the author: ");
                    String author = scanner.next();

                    Book book = new Book(bookId, bookTitle, author);
                    library.addBook(bookId, book);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.println("Enter the book ID: ");
                    bookId = scanner.next();

                    Book book = library.getBook(bookId);
                    if (book != null) {
                        System.out.println("Book ID: " + book.getBookId());
                        System.out.println("Book Title: " + book.getBookTitle());
                        System.out.println("Author: " + book.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    List<Book> books = library.getBooks();
                    if (books != null) {
                        for (Book book : books) {
                            System.out.println("Book ID: " + book.getBookId());
                            System.out.println("Book Title: " + book.getBookTitle());
                            System.out.println("Author: " + book.getAuthor());
                        }
                    } else {
                        System.out.println("No books found.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the digital library management system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
