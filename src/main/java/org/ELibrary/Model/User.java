package org.ELibrary.Model;

import java.time.LocalDateTime;
import java.util.*;

public class User {
    private final String username;
    private final String email;
    private final String passwordHash;
    private final String fullName;
    private final Cart cart;
    private final List<Order> orders;
    private final LocalDateTime createdAt;

    private final LinkedList<Book> browsingHistory;
    private static final int HISTORY_LIMIT = 10;


    public User(String username, String email, String passwordHash, String fullName) {
        this(username, email, passwordHash, fullName, LocalDateTime.now());
    }


    public User(String username, String email, String passwordHash, String fullName, LocalDateTime createdAt) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.cart = new Cart();
        this.orders = new ArrayList<>();
        this.createdAt = createdAt;
        this.browsingHistory = new LinkedList<>();
    }

    // --------------- Getters ----------------
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getFullName() { return fullName; }
    public Cart getCart() { return cart; }
    public List<Order> getOrders() { return orders; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Browsing history methods
    public void addToBrowsingHistory(Book book) {
        browsingHistory.remove(book);
        browsingHistory.addFirst(book);
        if (browsingHistory.size() > HISTORY_LIMIT) {
            browsingHistory.removeLast();
        }
    }

    public List<Book> getBrowsingHistory() {
        return Collections.unmodifiableList(browsingHistory);
    }

    public void setBrowsingHistory(List<Book> history) {
        browsingHistory.clear();
        if (history != null) {
            for (int i = history.size() - 1; i >= 0; i--) {
                addToBrowsingHistory(history.get(i));
            }
        }
    }

    // Orders management
    public void addOrder(Order order) {
        orders.add(order);
    }
}
