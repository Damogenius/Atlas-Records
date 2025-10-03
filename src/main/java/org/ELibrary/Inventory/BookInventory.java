package org.ELibrary.Inventory;

import org.ELibrary.Model.Book;

import java.util.*;

/**
 * Acts as an in-memory cache for books.
 * Actual persistence is handled by BookService (via DynamoDB).
 */
public class BookInventory {

    private final Map<String, Book> books = new HashMap<>();

    // Add a new book (or overwrite existing one by ID)
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    // Fetch a book by its ID
    public Book getBook(String id) {
        return books.get(id);
    }

    // Fetch all books as a list
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    // Update book details if it exists
    public void updateBook(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        } else {
            throw new IllegalArgumentException("Book with ID " + book.getId() + " not found.");
        }
    }

    // Remove a book by ID
    public void removeBook(String id) {
        books.remove(id);
    }

    // Clear inventory (useful for resets)
    public void clearInventory() {
        books.clear();
    }

    // Check if inventory is empty
    public boolean isEmpty() {
        return books.isEmpty();
    }
}
