package org.ELibrary.Model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Order {
    private String orderId;
    private String userId;
    private Map<Book, Integer> items;
    private double totalPrice;
    private double totalAmount;
    private LocalDateTime createdAt;


    public Order(String userId, Map<Book, Integer> items, double totalPrice, LocalDateTime createdAt) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }

    public String getOrderId() { return orderId; }
    public String getUserId() { return userId; }
    public Map<Book, Integer> getItems() { return items; }
    public double getTotalAmount() { return totalPrice; }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    @Override
    public String toString() {
        return String.format("Order %s for User %s: %.2f USD (%d items)",
                orderId, userId, totalPrice, items.size());
    }
}
