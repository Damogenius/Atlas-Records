package org.ELibrary.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private String email;
    private String passwordHash;
    private String fullName;
    private LocalDateTime createdAt;

    private final Cart cart;
    private final List<Order> orders;

    public User(String username, String email, String passwordHash, String fullName) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.createdAt = LocalDateTime.now();
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getFullName() { return fullName; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public Cart getCart() { return cart; }
    public List<Order> getOrders() { return orders; }

    public void addOrder(Order order) { orders.add(order); }

    @Override
    public String toString() {
        return String.format("User: %s (%s), Orders: %d, Cart Items: %d",
                username, email, orders.size(), cart.getItems().size());
    }
}
