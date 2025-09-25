package org.ELibrary.Service;

import org.ELibrary.Model.Cart;
import org.ELibrary.Model.Order;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CheckoutService {

    private final DynamoDbClient dynamoDb;
    private final String tableName = "Orders"; // DynamoDB table for orders

    public CheckoutService() {
        this.dynamoDb = DynamoDbClient.builder()
                .region(Region.AP_SOUTH_1) // dummy region for localhost
                .endpointOverride(URI.create("http://localhost:8000")) // Local DynamoDB
                .build();
    }

    public Order checkout(Cart cart) {
        // Generate Order
        String orderId = UUID.randomUUID().toString();
        double total = cart.calculateTotal();

        Order order = new Order(orderId, cart.getItems(), total, LocalDateTime.now());

        // Insert into DynamoDB
        persistOrder(order);

        System.out.println("Order placed successfully: " + orderId);
        System.out.println("Total amount: $" + total);

        return order;
    }

    private void persistOrder(Order order) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("orderId", AttributeValue.builder().s(order.getOrderId()).build());
        item.put("totalAmount", AttributeValue.builder().n(String.valueOf(order.getTotalAmount())).build());
        item.put("createdAt", AttributeValue.builder().s(order.getCreatedAt().toString()).build());

        // Flatten cart items into string (simple version)
        StringBuilder itemsString = new StringBuilder();
        order.getItems().forEach((book, qty) -> {
            itemsString.append(book.getTitle())
                    .append(" (x").append(qty).append("), ");
        });
        item.put("items", AttributeValue.builder().s(itemsString.toString()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();

        dynamoDb.putItem(request);
    }
}

