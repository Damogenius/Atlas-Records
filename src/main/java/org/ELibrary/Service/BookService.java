package org.ELibrary.Service;

import org.ELibrary.Model.Book;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.*;

public class BookService {
    private static final String TABLE_NAME = "Books";
    private final boolean useDynamo;
    private final DynamoDbClient dynamoDb;
    private final Map<String, Book> inMemory;

    public BookService(DynamoDbClient dynamoDb) {
        this.useDynamo = true;
        this.dynamoDb = dynamoDb;
        this.inMemory = null;
    }

    public void addBook(Book book) {
        if (useDynamo) {
            Map<String, AttributeValue> item = new HashMap<>();
            item.put("BookID", AttributeValue.builder().s(book.getId()).build());
            item.put("Title", AttributeValue.builder().s(book.getTitle()).build());
            item.put("Author", AttributeValue.builder().s(book.getAuthor()).build());
//            item.put("Issued", AttributeValue.builder().bool(book.isIssued()).build());
            item.put("Price", AttributeValue.builder().n(String.valueOf(book.getPrice())).build());
            dynamoDb.putItem(PutItemRequest.builder().tableName(TABLE_NAME).item(item).build());
        } else {
            if (inMemory.containsKey(book.getId()))
                throw new IllegalArgumentException("Book ID already exists: " + book.getId());
            inMemory.put(book.getId(), book);
        }
    }

    public List<Book> getAllBooks() {
        if (useDynamo) {
            ScanResponse resp = dynamoDb.scan(ScanRequest.builder().tableName(TABLE_NAME).build());
            List<Book> out = new ArrayList<>();
            for (Map<String, AttributeValue> item : resp.items()) out.add(mapToBook(item));
            return out;
        } else {
            return new ArrayList<>(inMemory.values());
        }
    }

    public Book getBookById(String id) {
        if (useDynamo) {
            GetItemResponse resp = dynamoDb.getItem(GetItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("BookID", AttributeValue.builder().s(id).build()))
                    .build());
            return resp.hasItem() ? mapToBook(resp.item()) : null;
        } else {
            return inMemory.get(id);
        }
    }

    // Search by title (case-sensitive partial match)
    public List<Book> getBooksByTitle(String titlePart) {
        if (useDynamo) {
            ScanRequest req = ScanRequest.builder()
                    .tableName(TABLE_NAME)
                    .filterExpression("contains(Title, :t)")
                    .expressionAttributeValues(Map.of(":t", AttributeValue.builder().s(titlePart).build()))
                    .build();
            ScanResponse resp = dynamoDb.scan(req);
            List<Book> out = new ArrayList<>();
            for (Map<String, AttributeValue> item : resp.items()) out.add(mapToBook(item));
            return out;
        } else {
            List<Book> out = new ArrayList<>();
            for (Book b : inMemory.values()) {
                if (b.getTitle() != null && b.getTitle().toLowerCase().contains(titlePart.toLowerCase())) {
                    out.add(b);
                }
            }
            return out;
        }
    }

    // Search by author (case-sensitive partial match)
    public List<Book> getBooksByAuthor(String authorPart) {
        if (useDynamo) {
            ScanRequest req = ScanRequest.builder()
                    .tableName(TABLE_NAME)
                    .filterExpression("contains(Author, :a)")
                    .expressionAttributeValues(Map.of(":a", AttributeValue.builder().s(authorPart).build()))
                    .build();
            ScanResponse resp = dynamoDb.scan(req);
            List<Book> out = new ArrayList<>();
            for (Map<String, AttributeValue> item : resp.items()) out.add(mapToBook(item));
            return out;
        } else {
            List<Book> out = new ArrayList<>();
            for (Book b : inMemory.values()) {
                if (b.getAuthor() != null && b.getAuthor().toLowerCase().contains(authorPart.toLowerCase())) {
                    out.add(b);
                }
            }
            return out;
        }
    }

    public void issueBook(String id) {
        Book b = getBookById(id);
        if (b == null) throw new IllegalArgumentException("Book not found: " + id);
        if (b.isIssued()) throw new IllegalStateException("Book is already issued: " + id);

        if (useDynamo) {
            dynamoDb.updateItem(UpdateItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("BookID", AttributeValue.builder().s(id).build()))
                    .updateExpression("SET Issued = :val")
                    .expressionAttributeValues(Map.of(":val", AttributeValue.builder().bool(true).build()))
                    .build());
        } else {
            b.setIssued(true);
            inMemory.put(id, b);
        }
    }

    public void returnBook(String id) {
        Book b = getBookById(id);
        if (b == null) throw new IllegalArgumentException("Book not found: " + id);

        if (useDynamo) {
            dynamoDb.updateItem(UpdateItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("BookID", AttributeValue.builder().s(id).build()))
                    .updateExpression("SET Issued = :val")
                    .expressionAttributeValues(Map.of(":val", AttributeValue.builder().bool(false).build()))
                    .build());
        } else {
            b.setIssued(false);
            inMemory.put(id, b);
        }
    }

    // Delete book
    public boolean deleteBook(String id) {
        if (useDynamo) {
            dynamoDb.deleteItem(DeleteItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("BookID", AttributeValue.builder().s(id).build()))
                    .build());
        } else {
            inMemory.remove(id);
        }
        return true;
    }

    // Map DynamoDB item to Book
    private Book mapToBook(Map<String, AttributeValue> item) {
        String id = item.get("BookID").s();
        String title = item.get("Title").s();
        String author = item.get("Author").s();
//        boolean issued = item.get("Issued").bool();
        double price = Double.parseDouble(item.get("Price").n());
        return new Book(id, title, author, price);
    }
}
