package org.ELibrary.Model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Order {
    private final String orderId;
    private final String userId;
    private final Map<Book, Integer> items;
    private final double totalAmount;
    private final LocalDateTime createdAt;

    public Order(String userId, Map<Book, Integer> items, double totalAmount, LocalDateTime createdAt) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
    }

    public String getOrderId() { return orderId; }
    public String getUserId() { return userId; }
    public Map<Book, Integer> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return String.format("Order %s for %s: $%.2f (%d items)",
                orderId, userId, totalAmount, items.size());
    }
}
