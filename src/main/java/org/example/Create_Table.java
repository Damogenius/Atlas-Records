package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import software.amazon.awssdk.regions.Region;

import java.net.URI;

public class Create_Table {
    public static void main(String[] args) {
        DynamoDbClient dynamodb = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .build();

        CreateTableRequest request = CreateTableRequest.builder()
                .tableName("Users")
                .keySchema(KeySchemaElement.builder()
                        .attributeName("UserId")
                        .keyType(KeyType.HASH) // Partition key
                        .build())
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("UserId")
                        .attributeType(ScalarAttributeType.S)
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(5L)
                        .writeCapacityUnits(5L)
                        .build())
                .build();

        try {
            CreateTableResponse response = dynamodb.createTable(request);
            System.out.println("Table created: " + response.tableDescription().tableName());
        } catch (ResourceInUseException e) {
            System.out.println("Table already exists: " + e.getMessage());
        } catch (DynamoDbException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            dynamodb.close();
        }
    }
}
