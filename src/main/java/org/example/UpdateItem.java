package org.example;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;
import software.amazon.awssdk.regions.Region;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class UpdateItem {

    public static void main(String[] args) {
        DynamoDbClient dynamodb = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .build();

        String tableName = "Users";
        String userIdToUpdate = "1001";
        String newAddress = "Canada";

        try {

            Map<String, AttributeValue> key = new HashMap<>();
            key.put("UserId", AttributeValue.builder().s(userIdToUpdate).build());

            Map<String, String> expressionAttributeNames = new HashMap<>();
            expressionAttributeNames.put("#A", "Address");

            Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
            expressionAttributeValues.put(":newAddr", AttributeValue.builder().s(newAddress).build());

            UpdateItemRequest updateRequest = UpdateItemRequest.builder()
                    .tableName(tableName)
                    .key(key)
                    .updateExpression("SET #A = :newAddr")
                    .expressionAttributeNames(expressionAttributeNames)
                    .expressionAttributeValues(expressionAttributeValues)
                    .build();

            //UpdateItemResponse updateResponse = dynamodb.updateItem(updateRequest);

            System.out.println("UpdateItem succeeded for UserId " + userIdToUpdate);

        } catch (Exception e) {
            System.err.println("Failed to update item: " + e.getMessage());
        } finally {
            dynamodb.close();
        }
    }
}

