package org.ELibrary.Service;

import org.ELibrary.Model.Book;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.*;
import java.util.stream.Collectors;

public class BrowsingHistoryService {

    private final DynamoDbClient dynamoDb;
    private static final String TABLE_NAME = "Users";
    private static final String HISTORY_ATTR = "browsingHistory";

    public BrowsingHistoryService(DynamoDbClient dynamoDb) {
        this.dynamoDb = dynamoDb;
    }

    // Persist browsing history to DynamoDB
    public void saveBrowsingHistory(String username, List<Book> history) {
        if (history == null || history.isEmpty()) return;

        List<String> bookIds = history.stream().map(Book::getId).collect(Collectors.toList());

        Map<String, AttributeValue> item = new HashMap<>();
        item.put("username", AttributeValue.builder().s(username).build());
        item.put(HISTORY_ATTR, AttributeValue.builder().ss(bookIds).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(TABLE_NAME)
                .item(item)
                .build();

        dynamoDb.putItem(request);
    }

    // Load browsing history from DynamoDB
    public List<Book> getBrowsingHistory(String username, BookService bookService) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("username", AttributeValue.builder().s(username).build());

        GetItemRequest request = GetItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(key)
                .build();

        Map<String, AttributeValue> returnedItem = dynamoDb.getItem(request).item();
        if (returnedItem == null || !returnedItem.containsKey(HISTORY_ATTR)) {
            return new ArrayList<>();
        }

        List<String> bookIds = returnedItem.get(HISTORY_ATTR).ss();
        List<Book> books = new ArrayList<>();
        for (String id : bookIds) {
            Book book = bookService.getBookById(id);
            if (book != null) books.add(book);
        }
        return books;
    }
}
