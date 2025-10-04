package org.ELibrary.Service;

import org.ELibrary.Model.User;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final DynamoDbClient dynamoDb;
    private final String tableName = "Users";

    public UserService(DynamoDbClient dynamoDb) {
        this.dynamoDb = dynamoDb;
    }


    public void saveUser(User user) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("username", AttributeValue.builder().s(user.getUsername()).build());
        item.put("email", AttributeValue.builder().s(user.getEmail()).build());
        item.put("passwordHash", AttributeValue.builder().s(user.getPasswordHash()).build());
        item.put("fullName", AttributeValue.builder().s(user.getFullName()).build());
        item.put("createdAt", AttributeValue.builder()
                .s(user.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).build());

        dynamoDb.putItem(PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build());
    }

    public User getUser(String username) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("username", AttributeValue.builder().s(username).build());

        GetItemResponse response = dynamoDb.getItem(GetItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .build());

        if (!response.hasItem()) return null;

        Map<String, AttributeValue> item = response.item();
        return new User(
                item.get("username").s(),
                item.get("email").s(),
                item.get("passwordHash").s(),
                item.get("fullName").s()
        );
    }
}

