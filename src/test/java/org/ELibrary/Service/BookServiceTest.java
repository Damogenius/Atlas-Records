package org.ELibrary.Service;

import org.ELibrary.Model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    private BookService bookService;
    private DynamoDbClient dynamoDb;

    @BeforeEach
    void setup() {
        dynamoDb = mock(DynamoDbClient.class);
        bookService = new BookService(dynamoDb);
    }

    @Test
    void testAddBook() {
        Book book = new Book("1", "Java 101", "Author A", 250.0, false);
        bookService.addBook(book);
        assertEquals(1, bookService.getAllBooks().size());
    }

    @Test
    void testIssueBook() {
        Book book = new Book("2", "Python 101", "Author B", 200.0, false);
        bookService.addBook(book);
        bookService.issueBook("2");
        assertTrue(bookService.getBookById("2").isIssued());
    }

    @Test
    void testReturnBook() {
        Book book = new Book("3", "C++ Basics", "Author C", 180.0, true);
        bookService.addBook(book);
        bookService.returnBook("3");
        assertFalse(bookService.getBookById("3").isIssued());
    }

    @Test
    void testSearchBooksByTitle() {
        Book book = new Book("4", "Spring Boot", "Author D", 300.0, false);
        bookService.addBook(book);
        List<Book> found = bookService.getBooksByTitle("Spring");
        assertFalse(found.isEmpty());
    }

    @Test
    void testSearchBooksByAuthor() {
        Book book = new Book("5", "React", "Author E", 150.0, false);
        bookService.addBook(book);
        List<Book> found = bookService.getBooksByAuthor("Author E");
        assertEquals(1, found.size());
    }
}
