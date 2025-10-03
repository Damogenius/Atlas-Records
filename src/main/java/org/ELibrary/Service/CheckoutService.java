package org.ELibrary.Service;

import org.ELibrary.Model.Cart;
import org.ELibrary.Model.Order;
import org.ELibrary.Model.User;
import org.ELibrary.Model.Book;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CheckoutService {
    private final DynamoDbClient dynamoDb;
    private final String tableName = "Orders";

    public CheckoutService(DynamoDbClient dynamoDb) {
        this.dynamoDb = dynamoDb;
    }
    public Order checkout(User user) {
        Cart cart = user.getCart();
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add books before checkout.");
            return null;
        }

        double total = cart.calculateTotal();
        Order order = new Order(user.getUsername(), cart.getItems(), total, LocalDateTime.now());

        persistOrder(order);
        user.addOrder(order);
        cart.clearCart();

        System.out.println("Order placed successfully: " + order.getOrderId());
        return order;
    }

    private void persistOrder(Order order) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("orderId", AttributeValue.builder().s(order.getOrderId()).build());
        item.put("userId", AttributeValue.builder().s(order.getUserId()).build());
        item.put("totalAmount", AttributeValue.builder().n(String.valueOf(order.getTotalAmount())).build());
        item.put("createdAt", AttributeValue.builder().s(order.getCreatedAt().toString()).build());

        // Store items as a map of bookId -> quantity
        Map<String, AttributeValue> itemMap = new HashMap<>();
        for (Map.Entry<Book, Integer> entry : order.getItems().entrySet()) {
            itemMap.put(entry.getKey().getId(), AttributeValue.builder().n(entry.getValue().toString()).build());
        }
        item.put("items", AttributeValue.builder().m(itemMap).build());

        dynamoDb.putItem(PutItemRequest.builder().tableName(tableName).item(item).build());
    }
}
