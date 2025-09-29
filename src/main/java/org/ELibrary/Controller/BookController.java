package org.ELibrary.Controller;
import org.ELibrary.Model.Cart;
import org.ELibrary.Model.Order;
import org.ELibrary.Service.BookService;
import org.ELibrary.Model.Book;
import org.ELibrary.Service.CheckoutService;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private final BookService bookService;
    private final Cart cart;
    private final CheckoutService checkoutService;
    private final Scanner scanner;

    public BookController(BookService bookService, CheckoutService checkoutService) {
        this.bookService = bookService;
        this.cart = new Cart();
        this.checkoutService = checkoutService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n==== Online Bookstore ====");
            System.out.println("1. View all books");
            System.out.println("2. Add new book");
            System.out.println("3. Issue book");
            System.out.println("4. Return book");
            System.out.println("5. Add existing book to cart");
            System.out.println("6. View cart");
            System.out.println("7. Checkout");
            System.out.println("8. Remove book from cart");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> viewAllBooks();
                case "2" -> addNewBook();
                case "3" -> issueBook();
                case "4" -> returnBook();
                case "5" -> addExistingBookToCart();
                case "6" -> viewCart();
                case "7" -> checkout();
                case "8" -> RemoveCart();
                case "9" -> {
                    System.out.println("Exiting Bookstore. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void viewAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.forEach(b -> System.out.printf("[%s] %s by %s ($%.2f)%n",
                b.getId(), b.getTitle(), b.getAuthor(), b.getPrice()));
    }

    private void addNewBook() {
        System.out.print("Enter book id: ");
        String id = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Book book = new Book(id, title, author, price, false);
        bookService.addBook(book);
        System.out.println("Book added successfully.");
    }

    private void issueBook() {
        System.out.print("Enter book id to issue: ");
        String id = scanner.nextLine();
        try {
            bookService.issueBook(id);
            System.out.println("Book issued successfully.");
        } catch (Exception e) {
            System.out.println("Error issuing book: " + e.getMessage());
        }
    }

    private void returnBook() {
        System.out.print("Enter book id to return: ");
        String id = scanner.nextLine();
        try {
            bookService.returnBook(id);
            System.out.println("Book returned successfully.");
        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }

    // New feature for Day 5
    private void addExistingBookToCart() {
        System.out.println("Search by: 1) Book ID  2) Title");
        String choice = scanner.nextLine();

        Book selectedBook = null;

        if ("1".equals(choice)) {
            // Search by ID
            System.out.print("Enter book id: ");
            String id = scanner.nextLine();
            selectedBook = bookService.getBookById(id);
            if(selectedBook==null) {
                System.out.printf("\n BookID %s Does not exist", id);
                return;
            }

        } else if ("2".equals(choice)) {
            // Partial search by title
            System.out.print("Enter book title (partial allowed in proper case): ");
            String title = scanner.nextLine();
            List<Book> matches = bookService.getBooksByTitle(title);

            if (matches.isEmpty()) {
                System.out.println("No books found with title: " + title);
                return;
            }

            System.out.println("Matching books:");
            for (int i = 0; i < matches.size(); i++) {
                Book b = matches.get(i);
                System.out.printf("%d. %s by %s ($%.2f)%n", i + 1, b.getTitle(), b.getAuthor(), b.getPrice());
            }

            System.out.print("Choose book number: ");
            int idx = Integer.parseInt(scanner.nextLine()) - 1;

            if (idx < 0 || idx >= matches.size()) {
                System.out.println("Invalid choice.");
                return;
            }
            selectedBook = matches.get(idx);
        }

        if (selectedBook != null) {
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(scanner.nextLine());

            cart.addBook(selectedBook, qty);
            System.out.println(selectedBook.getTitle() + " added to cart.");
        }
    }
    private void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        cart.getItems().forEach((book, qty) ->
                System.out.printf("%s by %s x%d = $%.2f%n",
                        book.getTitle(), book.getAuthor(), qty, book.getPrice() * qty));
        System.out.printf("Total: $%.2f%n", cart.calculateTotal());
    }

    private void RemoveCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to remove.");
        } else {
            System.out.print("Enter Book ID to remove: ");
            String removeId = scanner.nextLine();
            //scanner.nextLine(); // consume newline

            Book bookToRemove = bookService.getBookById(removeId);
            if (bookToRemove != null && cart.getItems().containsKey(bookToRemove)) {
                cart.removeBook(bookToRemove);
                System.out.println(bookToRemove.getTitle() + " removed from cart.");
            } else {
                System.out.println("Book not found in cart.");
            }
        }
    }

    private void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add books before checkout.");
            return;
        }
        Order order = checkoutService.checkout(cart);
        System.out.println("Checkout complete. Order summary:");
        System.out.printf("Order ID: %s, Total: $%.2f%n", order.getOrderId(), order.getTotalAmount());
        cart.isEmpty();
    }
}
