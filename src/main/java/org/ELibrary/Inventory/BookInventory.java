package org.ELibrary.Inventory;
import org.ELibrary.Model.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookInventory {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
