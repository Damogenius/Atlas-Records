package org.ELibrary.Service;

import org.ELibrary.Model.Book;
import org.ELibrary.Service.BookService;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecommendationServiceTest {

    @Test
    void testGetRecommendationsEmpty() {
        DynamoDbClient mockDynamo = mock(DynamoDbClient.class);
        RecommendationService service = new RecommendationService(mockDynamo); // mock if needed
        BookService bookService = new BookService(mockDynamo);
        List<Book> rec = service.getRecommendations("user123", bookService);
        assertNotNull(rec);
    }
}
