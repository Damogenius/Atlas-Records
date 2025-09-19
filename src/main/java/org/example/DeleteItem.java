package org.example;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.regions.Region;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class DeleteItem {
    public static void main(String[] args) {
        DynamoDbClient dynamodb = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .build();

        String tableName = "Users";

        Map<String, AttributeValue> keyToDelete = new HashMap<>();
        keyToDelete.put("UserId", AttributeValue.builder().s("1002").build());

        DeleteItemRequest deleteRequest = DeleteItemRequest.builder()
                .tableName(tableName)
                .key(keyToDelete)
                .build();

        dynamodb.deleteItem(deleteRequest);
        System.out.println("Deleted item with ID = 1002");

        dynamodb.close();
    }
}
