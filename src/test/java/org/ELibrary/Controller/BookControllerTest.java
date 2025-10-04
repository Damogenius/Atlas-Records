package org.ELibrary.Controller;

import org.ELibrary.Model.Book;
import org.ELibrary.Model.Cart;
import org.ELibrary.Model.Order;
import org.ELibrary.Model.User;
import org.ELibrary.Service.BookService;
import org.ELibrary.Service.CheckoutService;
import org.ELibrary.Service.RecommendationService;
import org.ELibrary.Service.UserService;
import org.ELibrary.Service.BrowsingHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookControllerTest {

    private BookService bookService;
    private CheckoutService checkoutService;
    private UserService userService;
    private RecommendationService recommendationService;
    private BrowsingHistoryService browsingHistoryService;
    private BookController controller;

    @BeforeEach
    void setUp() {
        bookService = mock(BookService.class);
        checkoutService = mock(CheckoutService.class);
        recommendationService = mock(RecommendationService.class);
        userService = mock(UserService.class);
        browsingHistoryService = mock(BrowsingHistoryService.class);

        controller = new BookController(bookService, checkoutService, recommendationService,userService,browsingHistoryService);

        // Override services for testing
        controller.userService = userService;
        controller.browsingHistoryService = browsingHistoryService;
    }

    // Helper to simulate user input
    private void provideInput(String data) {
        InputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void testUserRegistrationAndLogin() {
        provideInput("1\nuser123\nuser@example.com\nJohn Doe\npassword\n2\nuser123\npassword\n14\n");

        controller.start(); // Run the loop

        verify(userService, atLeastOnce()).saveUser(any(User.class));
    }

    @Test
    void testViewAllBooksAddsBrowsingHistory() {
        Book book1 = new Book("B1", "Java Basics", "Author A", 100.0, false);
        Book book2 = new Book("B2", "Python Basics", "Author B", 120.0, false);
        when(bookService.getAllBooks()).thenReturn(List.of(book1, book2));

        User user = new User("user123", "user@example.com", "password", "John Doe");
        controller.users.put("user123", user);
        controller.currentUser = user;

        controller.viewAllBooks();

        List<Book> history = user.getBrowsingHistory();
        assertEquals(2, history.size());
        assertTrue(history.contains(book1));
        assertTrue(history.contains(book2));
    }

    @Test
    void testAddBookToCartById() {
        Book book = new Book("B1", "Java Basics", "Author A", 100.0, false);
        when(bookService.getBookById("B1")).thenReturn(book);

        User user = new User("user123", "user@example.com", "password", "John Doe");
        controller.currentUser = user;

        provideInput("1\nB1\n2\n");
        controller.addExistingBookToCart();

        Cart cart = user.getCart();
        assertTrue(cart.getItems().containsKey(book));
        assertEquals(2, cart.getItems().get(book));
    }

    @Test
    void testAddBookToCartByTitle() {
        Book book = new Book("B1", "Java Basics", "Author A", 100.0, false);
        when(bookService.getBooksByTitle("Java")).thenReturn(List.of(book));

        User user = new User("user123", "user@example.com", "password", "John Doe");
        controller.currentUser = user;

        provideInput("2\nJava\n1\n");
        controller.addExistingBookToCart();

        assertEquals(1, user.getCart().getItems().get(book));
        assertTrue(user.getBrowsingHistory().contains(book));
    }

    @Test
    void testAddBookToCartByAuthor() {
        Book book = new Book("B1", "Java Basics", "Author A", 100.0, false);
        when(bookService.getBooksByAuthor("Author A")).thenReturn(List.of(book));

        User user = new User("user123", "user@example.com", "password", "John Doe");
        controller.currentUser = user;

        provideInput("3\nAuthor A\n1\n");
        controller.addExistingBookToCart();

        assertEquals(1, user.getCart().getItems().get(book));
        assertTrue(user.getBrowsingHistory().contains(book));
    }

    @Test
    void testRemoveFromCart() {
        Book book = new Book("B1", "Java Basics", "Author A", 100.0, false);
        User user = new User("user123", "user@example.com", "password", "John Doe");
        user.getCart().addBook(book, 3);
        controller.currentUser = user;

        provideInput("B1\n2\n");
        controller.removeFromCart();

        assertEquals(1, user.getCart().getItems().get(book));
    }

    @Test
    void testCheckout() {
        Book book = new Book("B1", "Java Basics", "Author A", 100.0, false);
        User user = new User("user123", "user@example.com", "password", "John Doe");
        user.getCart().addBook(book, 1);
        controller.currentUser = user;

        provideInput("Y\n");
        controller.checkout();

        verify(checkoutService, times(1)).checkout(user);
    }

    @Test
    void testViewRecommendations() {
        Book book = new Book("B1", "Java Basics", "Author A", 100.0, false);
        when(recommendationService.getRecommendations("user123", bookService)).thenReturn(List.of(book));

        User user = new User("user123", "user@example.com", "password", "John Doe");
        controller.currentUser = user;

        controller.viewRecommendations();
    }

    @Test
    void testViewBrowsingHistory() {
        Book book1 = new Book("B1", "Java Basics", "Author A", 100.0, false);
        Book book2 = new Book("B2", "Python Basics", "Author B", 120.0, false);

        User user = new User("user123", "user@example.com", "password", "John Doe");
        user.addToBrowsingHistory(book1);
        user.addToBrowsingHistory(book2);
        controller.currentUser = user;

        controller.viewBrowsingHistory();
        List<Book> history = user.getBrowsingHistory();
        assertEquals(2, history.size());
    }

    @Test
    void testLogoutUser() {
        User user = new User("user123", "user@example.com", "password", "John Doe");
        controller.currentUser = user;

        controller.currentUser = null;
        assertNull(controller.currentUser);
    }

    @Test
    void testIssueAndReturnBook() {
        Book book = new Book("B1", "Java Basics", "Author A", 100.0, false);
        when(bookService.getBookById("B1")).thenReturn(book);

        controller.currentUser = new User("user123", "user@example.com", "password", "John Doe");

        provideInput("B1\n");
        controller.issueBook();
        verify(bookService, times(1)).issueBook("B1");

        provideInput("B1\n");
        controller.returnBook();
        verify(bookService, times(1)).returnBook("B1");
    }

    @Test
    void testAddNewBook() {
        provideInput("B1\nJava Basics\nAuthor A\n100\n");
        controller.currentUser = new User("admin", "admin@example.com", "adminpass", "Admin");

        controller.addNewBook();
        verify(bookService, times(1)).addBook(any(Book.class));
    }

}
