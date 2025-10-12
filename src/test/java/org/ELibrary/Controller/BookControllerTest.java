package org.ELibrary.Controller;

import org.ELibrary.Model.Book;
import org.ELibrary.Model.User;
import org.ELibrary.Model.Order;
import org.ELibrary.Service.BookService;
import org.ELibrary.Service.CheckoutService;
import org.ELibrary.Service.RecommendationService;
import org.ELibrary.Service.BrowsingHistoryService;
import org.ELibrary.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookControllerTest {

    BookController controller;
    BookService bookService;
    CheckoutService checkoutService;
    RecommendationService recommendationService;
    BrowsingHistoryService browsingHistoryService;
    UserService userService;

    @BeforeEach
    void setup() {
        bookService = mock(BookService.class);
        checkoutService = mock(CheckoutService.class);
        recommendationService = mock(RecommendationService.class);
        browsingHistoryService = mock(BrowsingHistoryService.class);
        userService = mock(UserService.class);

        controller = new BookController(bookService, checkoutService, recommendationService, userService, browsingHistoryService);
    }
    @Test
    void testViewAllBooksEmpty() {
        when(bookService.getAllBooks()).thenReturn(Collections.emptyList());
        controller.viewAllBooks();
        verify(bookService, times(1)).getAllBooks();
    }
    @Test
    void testDeleteBook() {
        Book book = new Book("10", "Delete Me", "Author", 25.0);
        when(bookService.getBookById("10")).thenReturn(book);
        when(bookService.deleteBook("10")).thenReturn(true);

        boolean result = bookService.deleteBook("10");
        assertTrue(result);
        verify(bookService, times(1)).deleteBook("10");
    }



    @Test
    void testAddNewBook() {
        Book book = new Book("1", "Test Book", "Author1", 50.0);
        when(bookService.getAllBooks()).thenReturn(Collections.singletonList(book));

        controller.viewAllBooks();
        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    void testViewBrowsingHistoryEmpty() {
        User user = new User("Damo", "xyz@example.com", "pass123", "Damo K");
        controller.currentUser = user;

        controller.viewBrowsingHistory();
        assertTrue(user.getBrowsingHistory().isEmpty());
    }

    @Test
    void testAddToBrowsingHistory() {
        User user = new User("Damo", "xyz@example.com", "pass123", "Damo K");
        controller.currentUser = user;

        Book book = new Book("1", "ML Book", "Author", 30.0);
        user.addToBrowsingHistory(book);

        List<Book> history = user.getBrowsingHistory();
        assertEquals(1, history.size());
        assertEquals("ML Book", history.get(0).getTitle());
    }

    @Test
    void testLogoutUser() {
        User user = new User("Damo", "xyz@example.com", "pass123", "Damo K");
        controller.currentUser = user;

        controller.logoutUser();
        assertNull(controller.currentUser);
        verify(browsingHistoryService, times(1)).saveBrowsingHistory(eq(user.getUsername()), anyList());
    }

    @Test
    void testRecommendationFetch() {
        User user = new User("Damo", "xyz@example.com", "pass123", "Damo K");
        controller.currentUser = user;

        Book recommendedBook = new Book("99", "Recommended Book", "Test Book", 99.0);
        when(recommendationService.getRecommendations(anyString(), any(BookService.class)))
                .thenReturn(Collections.singletonList(recommendedBook));

        controller.viewRecommendations();
        List<Book> recs = recommendationService.getRecommendations(user.getUsername(), bookService);
        assertEquals(1, recs.size());
        assertEquals("Recommended Book", recs.get(0).getTitle());
    }

    @Test
    void testCheckoutServiceCalled() {
        User user = new User("Damo", "xyz@example.com", "pass123", "Damo K");
        Book book = new Book("1", "Test Book", "Author1", 50.0);
        user.getCart().addBook(book, 1);
        controller.currentUser = user;

        Order mockOrder = new Order(user.getUsername(), user.getCart().getItems(), user.getCart().calculateTotal(), LocalDateTime.now());
        when(checkoutService.checkout(any(User.class))).thenReturn(mockOrder);

        Order result = checkoutService.checkout(user);
        assertNotNull(result);
        assertEquals(mockOrder, result);
        verify(checkoutService, times(1)).checkout(user);
    }

    @Test
    void testSetAndGetBrowsingHistory() {
        User user = new User("Damo", "xyz@example.com", "pass123", "Damo K");
        controller.currentUser = user;

        List<Book> books = Arrays.asList(
                new Book("1", "Book A", "Author1", 12.0),
                new Book("2", "Book B", "Author2", 20.0)
        );

        user.setBrowsingHistory(books);
        List<Book> history = user.getBrowsingHistory();
        assertEquals(2, history.size());
        assertEquals("Book A", history.get(0).getTitle());
    }
    @Test
    void testCheckoutWithEmptyCart() {
        User user = new User("emptyUser", "e@x.com", "pass", "Empty User");
        controller.currentUser = user;
        when(checkoutService.checkout(user)).thenReturn(null);

        Order result = checkoutService.checkout(user);
        assertNull(result);
    }


    @Test
    void testViewAccountInfo() {
        User user = new User("damo", "xyz@example.com", "pass123", "Damo K");
        controller.currentUser = user;

        controller.viewAccountInfo();
        assertEquals("damo", user.getUsername());
        assertEquals("Damo K", user.getFullName());
    }

    @Test
    void testUserRegistration() {
        User user = new User("damo", "xyz@example.com", "pass123", "Damo K");
        when(userService.getUser("damo")).thenReturn(user);

        controller.users.put(user.getUsername(), user);
        assertTrue(controller.users.containsKey("damo"));
    }

    @Test
    void testUserLogin() {
        User user = new User("damo", "xyz@example.com", "pass123", "Bob");
        when(userService.getUser("damo")).thenReturn(user);

        controller.currentUser = user;
        assertEquals("damo", controller.currentUser.getUsername());
    }
}
