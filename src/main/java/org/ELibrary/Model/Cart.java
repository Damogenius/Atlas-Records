package org.ELibrary.Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Book, Integer> items = new HashMap<>();

    public void addBook(Book book, int quantity) {
        items.put(book, items.getOrDefault(book, 0) + quantity);
    }

    public void removeBook(Book book) {
        items.remove(book);
    }

    public Map<Book, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calculateTotal() {
        return items.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();
    }

    public void clearCart() {
        items.clear();
    }
}
