package org.ELibrary.Service;

import org.ELibrary.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private DynamoDbClient dynamoDb;

    @BeforeEach
    void setup() {
        dynamoDb = mock(DynamoDbClient.class);
        userService = new UserService(dynamoDb);
    }

    @Test
    void testSaveUser() {
        User user = new User("alice", "alice@example.com", "pass123", "Alice");
        assertDoesNotThrow(() -> userService.saveUser(user));
    }

    @Test
    void testGetUserReturnsNullIfNotExist() {
        when(dynamoDb.getItem((GetItemRequest) any())).thenReturn(null);
        assertNull(userService.getUser("nonexistent"));
    }
}
