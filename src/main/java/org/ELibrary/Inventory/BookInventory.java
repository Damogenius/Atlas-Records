//package org.ELibrary.Inventory;
//
//import org.ELibrary.Model.Book;
//
//import java.util.*;
//
///**
// * Acts as an in-memory cache for books.
// * Actual persistence is handled by BookService (via DynamoDB).
// */
//public class BookInventory {
//
//    private final Map<String, Book> books = new HashMap<>();
//
//    public void addBook(Book book) {
//        books.put(book.getId(), book);
//    }
//
//    public Book getBook(String id) {
//        return books.get(id);
//    }
//
//    public List<Book> getAllBooks() {
//        return new ArrayList<>(books.values());
//    }
//
//    public void updateBook(Book book) {
//        if (books.containsKey(book.getId())) {
//            books.put(book.getId(), book);
//        } else {
//            throw new IllegalArgumentException("Book with ID " + book.getId() + " not found.");
//        }
//    }
//
//    public void removeBook(String id) {
//        books.remove(id);
//    }
//
//    public void clearInventory() {
//        books.clear();
//    }
//
//    public boolean isEmpty() {
//        return books.isEmpty();
//    }
//}
