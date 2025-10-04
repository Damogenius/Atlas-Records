package org.ELibrary.Service;

import org.ELibrary.Model.Book;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecommendationService {

    private final DynamoDbClient dynamoDb;
    private static final String TABLE_NAME = "Recommendations";

    public RecommendationService(DynamoDbClient dynamoDb) {
        this.dynamoDb = dynamoDb;
    }

    /**
     * Get recommended books for a user by username
     */
    public List<Book> getRecommendations(String username, BookService bookService) {
        List<Book> recommendedBooks = new ArrayList<>();

        if (dynamoDb == null) {
            System.out.println("DynamoDbClient not initialized!");
            return recommendedBooks;
        }

        GetItemRequest request = GetItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(Map.of("username", AttributeValue.builder().s(username).build()))
                .build();

        Map<String, AttributeValue> item = dynamoDb.getItem(request).item();

        if (item == null || item.isEmpty()) {
            //System.out.println("No recommendations found for user: " + username);
            return recommendedBooks;
        }


        Map<String, AttributeValue> recMap = item.get("recommendedBooks").m();

        for (String bookId : recMap.keySet()) {
            Book book = bookService.getBookById(bookId);
            if (book != null) {
                recommendedBooks.add(book);
            }
        }

        return recommendedBooks;
    }
}
