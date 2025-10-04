package org.ELibrary.Service;

import org.ELibrary.Model.Book;
import org.ELibrary.Model.Cart;
import org.ELibrary.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckoutServiceTest {
    private CheckoutService checkoutService;
    private User user;
    private DynamoDbClient dynamoDb;

    @BeforeEach
    void setup() {
        dynamoDb = mock(DynamoDbClient.class);
        checkoutService = new CheckoutService(dynamoDb);
        user = new User("john", "john@example.com", "pass123", "John Doe");
    }

    @Test
    void testCheckoutEmptyCart() {
        assertNull(checkoutService.checkout(user));
    }

    @Test
    void testCheckoutWithBooks() {
        Book book = new Book("1", "Java", "Author A", 200, false);
        user.getCart().addBook(book, 2);
        var order = checkoutService.checkout(user);
        assertNotNull(order);
        assertEquals(0, user.getCart().getItems().size()); // cart cleared
        assertEquals(1, user.getOrders().size());
    }
}
