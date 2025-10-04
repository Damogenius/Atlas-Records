package org.ELibrary.Service;

import org.ELibrary.Model.Book;
import org.ELibrary.Model.User;
import org.ELibrary.Service.BrowsingHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrowsingHistoryServiceTest {
    private BrowsingHistoryService historyService;
    private User user;

    @BeforeEach
    void setup() {
        historyService = new BrowsingHistoryService(null); // mock DynamoDB
        user = new User("bob", "bob@example.com", "pass", "Bob");
    }

    @Test
    void testAddToBrowsingHistory() {
        Book book = new Book("1", "History", "Author X", 100, false);
        user.addToBrowsingHistory(book);
        List<Book> history = user.getBrowsingHistory();
        assertEquals(1, history.size());
        assertEquals("History", history.get(0).getTitle());
    }
}
