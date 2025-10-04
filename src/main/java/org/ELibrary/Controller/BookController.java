package org.ELibrary.Controller;

import org.ELibrary.Model.Book;
import org.ELibrary.Model.Cart;
import org.ELibrary.Model.Order;
import org.ELibrary.Model.User;
import org.ELibrary.Service.BookService;
import org.ELibrary.Service.CheckoutService;
import org.ELibrary.Service.UserService;
import org.ELibrary.Service.RecommendationService;
import org.ELibrary.Service.BrowsingHistoryService;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookController {

    private final BookService bookService;
    private final CheckoutService checkoutService;
    UserService userService;
    private final RecommendationService recommendationService;
    BrowsingHistoryService browsingHistoryService;
    private final Scanner scanner;
    final Map<String, User> users = new HashMap<>();
    User currentUser;

    public BookController(BookService bookService, CheckoutService checkoutService,
                          RecommendationService recommendationService,UserService userService,BrowsingHistoryService browsingHistoryService) {
        this.bookService = bookService;
        this.checkoutService = checkoutService;
        this.recommendationService = recommendationService;
        this.userService=userService;
        this.browsingHistoryService = browsingHistoryService;
        this.scanner = new Scanner(System.in);

    }

    public void start() {
        while (true) {
            if (currentUser == null) {
                showUserMenu();
            } else {
                showBookstoreMenu();
            }
        }
    }

    // ---------------- USER MENU ----------------
    private void showUserMenu() {
        System.out.println("\n==== User Menu ====");
        System.out.println("1. Register User");
        System.out.println("2. Login User");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> registerUser();
            case "2" -> loginUser();
            case "3" -> {
                System.out.println("Exiting Bookstore. Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        User user = new User(username, email, password, fullName);
        userService.saveUser(user);
        users.put(username, user);
        System.out.println("User registered successfully!");
    }

    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        User user = userService.getUser(username);

        if (user == null) {
            System.out.println("User not found. Please register first.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        if (password.equals(user.getPasswordHash())) {
            currentUser = user;
            users.put(username, user);
            List<Book> history = browsingHistoryService.getBrowsingHistory(username, bookService);
            currentUser.setBrowsingHistory(history);
            System.out.println("Login successful. Welcome, " + user.getFullName());
        } else {
            System.out.println("Invalid password.");
        }
    }

    // ---------------- BOOKSTORE MENU ----------------
    private void showBookstoreMenu() {
        System.out.println("\n==== Online Bookstore ====");
        System.out.println("Logged in as: " + currentUser.getUsername());
        System.out.println("1. View all books");
        System.out.println("2. Add new book");
        System.out.println("3. Issue book");
        System.out.println("4. Return book");
        System.out.println("5. Add existing book to cart");
        System.out.println("6. View cart");
        System.out.println("7. Checkout");
        System.out.println("8. Remove book from cart");
        System.out.println("9. View my orders");
        System.out.println("10. Recommended Books");
        System.out.println("11. View Recently Browsed Books");
        System.out.println("12. Logout");
        System.out.println("13. View Account Info");
        System.out.println("14. Exit");
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
            case "8" -> removeFromCart();
            case "9" -> viewOrders();
            case "10" -> viewRecommendations();
            case "11" -> viewBrowsingHistory();
            case "12" -> logoutUser();
            case "13" -> viewAccountInfo();
            case "14" -> {
                System.out.println("Exiting Bookstore. Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

    private void logoutUser() {
        // Persist browsing history to DynamoDB
        browsingHistoryService.saveBrowsingHistory(currentUser.getUsername(), currentUser.getBrowsingHistory());
        currentUser = null;
        System.out.println("Logged out successfully.");
    }

    // ---------------- BOOK & CART ----------------
    void viewAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.printf("%-5s %-25s %-20s %-10s %-10s%n", "ID", "Title", "Author", "Price", "Status");
        System.out.println("--------------------------------------------------------------------");
        books.forEach(b -> System.out.printf("%-5s %-25s %-20s $%-9.2f %-10s%n",
                b.getId(), b.getTitle(), b.getAuthor(), b.getPrice(), b.isIssued() ? "Issued" : "Available"));
    }

    void addNewBook() {
        try {
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
        } catch (NumberFormatException e) {
            System.out.println("Invalid price input.");
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    void issueBook() {
        System.out.print("Enter book id to issue: ");
        String id = scanner.nextLine();
        try {
            bookService.issueBook(id);
            System.out.println("Book issued successfully.");
        } catch (Exception e) {
            System.out.println("Error issuing book: " + e.getMessage());
        }
    }

    void returnBook() {
        System.out.print("Enter book id to return: ");
        String id = scanner.nextLine();
        try {
            bookService.returnBook(id);
            System.out.println("Book returned successfully.");
        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }

    void addExistingBookToCart() {
        System.out.println("Search by: 1) Book ID  2) Title  3) Author");
        String choice = scanner.nextLine();
        Book selectedBook = null;

        try {
            if ("1".equals(choice)) {
                System.out.print("Enter book id: ");
                String id = scanner.nextLine();
                selectedBook = bookService.getBookById(id);
                if (selectedBook == null) {
                    System.out.println("Book ID not found.");
                    return;
                }
            } else if ("2".equals(choice)) {
                System.out.print("Enter book title (partial allowed): ");
                String title = scanner.nextLine();
                List<Book> matches = bookService.getBooksByTitle(title);
                selectedBook = chooseFromList(matches);
            } else if ("3".equals(choice)) {
                System.out.print("Enter author name (partial allowed): ");
                String author = scanner.nextLine();
                List<Book> matches = bookService.getBooksByAuthor(author);
                selectedBook = chooseFromList(matches);
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            if (selectedBook != null) {
                System.out.print("Enter quantity: ");
                int qty = Integer.parseInt(scanner.nextLine());
                if (qty <= 0) {
                    System.out.println("Quantity must be positive.");
                    return;
                }
                currentUser.getCart().addBook(selectedBook, qty);
                currentUser.addToBrowsingHistory(selectedBook);
                System.out.println(selectedBook.getTitle() + " added to cart.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.");
        }
    }

    private Book chooseFromList(List<Book> matches) {
        if (matches.isEmpty()) {
            System.out.println("No matching books found.");
            return null;
        }

        System.out.println("Matching books:");
        for (int i = 0; i < matches.size(); i++) {
            Book b = matches.get(i);
            System.out.printf("%d. %s by %s ($%.2f) - %s%n", i + 1, b.getTitle(), b.getAuthor(), b.getPrice(),
                    b.isIssued() ? "Issued" : "Available");
        }

        System.out.print("Choose book number: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= matches.size()) {
            System.out.println("Invalid choice.");
            return null;
        }
        Book chosen = matches.get(idx);
        currentUser.addToBrowsingHistory(chosen);
        return chosen;
    }

    private void viewCart() {
        Cart cart = currentUser.getCart();
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.printf("%-25s %-10s %-10s %-10s%n", "Title", "Qty", "Price", "Subtotal");
        System.out.println("------------------------------------------------------");
        cart.getItems().forEach((book, qty) -> {
            double subtotal = book.getPrice() * qty;
            System.out.printf("%-25s %-10d $%-9.2f $%-9.2f%n", book.getTitle(), qty, book.getPrice(), subtotal);
        });
        System.out.printf("Total: $%.2f%n", cart.calculateTotal());
    }

    void removeFromCart() {
        Cart cart = currentUser.getCart();
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.print("Enter Book ID to remove: ");
        String removeId = scanner.nextLine();

        Book bookToRemove = bookService.getBookById(removeId);
        if (bookToRemove != null && cart.getItems().containsKey(bookToRemove)) {
            System.out.print("Enter quantity to remove (or full quantity to remove all): ");
            try {
                int qty = Integer.parseInt(scanner.nextLine());
                if (qty >= cart.getItems().get(bookToRemove)) {
                    cart.removeBook(bookToRemove);
                } else {
                    cart.getItems().put(bookToRemove, cart.getItems().get(bookToRemove) - qty);
                }
                System.out.println(bookToRemove.getTitle() + " updated in cart.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity input.");
            }
        } else {
            System.out.println("Book not found in cart.");
        }
    }

    void checkout() {
        Cart cart = currentUser.getCart();
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Cannot checkout.");
            return;
        }

        System.out.println("Confirm checkout? (Y/N)");
        String confirm = scanner.nextLine().trim().toUpperCase();
        if ("Y".equals(confirm)) {
            checkoutService.checkout(currentUser);
        } else {
            System.out.println("Checkout cancelled.");
        }
    }

    void viewRecommendations() {
        List<Book> recBooks = recommendationService.getRecommendations(currentUser.getUsername(), bookService);
        if (recBooks.isEmpty()) {
            System.out.println("No recommended books for you right now.");
            return;
        }

        System.out.printf("%-5s %-25s %-20s %-10s %-10s%n", "ID", "Title", "Author", "Price", "Status");
        System.out.println("--------------------------------------------------------------------");
        recBooks.forEach(b -> System.out.printf("%-5s %-25s %-20s $%-9.2f %-10s%n",
                b.getId(), b.getTitle(), b.getAuthor(), b.getPrice(), b.isIssued() ? "Issued" : "Available"));
    }

    private void viewOrders() {
        List<Order> orders = currentUser.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }
        orders.stream().sorted((o1, o2) -> o2.getCreatedAt().compareTo(o1.getCreatedAt()))
                .forEach(o -> {
                    System.out.println(o);
                    o.getItems().forEach((book, qty) ->
                            System.out.printf("  - %s x%d ($%.2f each)%n", book.getTitle(), qty, book.getPrice())
                    );
                });
    }

    void viewBrowsingHistory() {
        List<Book> history = currentUser.getBrowsingHistory();
        if (history.isEmpty()) {
            System.out.println("No recently browsed books.");
            return;
        }
        System.out.println("=== Recently Browsed Books ===");
        for (Book book : history) {
            System.out.printf("%s by %s ($%.2f)%n", book.getTitle(), book.getAuthor(), book.getPrice());
        }
    }
    private void viewAccountInfo() {
        System.out.println("=== Account Info ===");
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("Full Name: " + currentUser.getFullName());
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Account Created At: " + currentUser.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}

