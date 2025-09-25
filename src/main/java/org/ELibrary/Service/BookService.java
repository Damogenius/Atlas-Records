package org.ELibrary.Service;

import org.ELibrary.Model.Book;
import org.ELibrary.Model.Cart;
import org.ELibrary.Model.Order;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.*;

public class BookService {
    private static final String TABLE_NAME = "Books";
    private final boolean useDynamo;
    private final DynamoDbClient dynamoDb; // null if in-memory
    private final Map<String, Book> inMemory; // non-null if in-memory

    // Default constructor: in-memory with seeded books
//    public BookService() {
//        this.useDynamo = false;
//        this.dynamoDb = null;
//        this.inMemory = new HashMap<>();
//        inMemory.put("1", new Book("1", "Clean Code", "Robert C. Martin",
//                25.90,false));
//        inMemory.put("2", new Book("2", "Design Patterns", "Erich Gamma et al.",35.78, false));
//    }

    // DynamoDB constructor
    public BookService(DynamoDbClient dynamoDb) {
        this.useDynamo = true;
        this.dynamoDb = dynamoDb;
        this.inMemory = null;
    }

    // Add book
    public void addBook(Book book) {
        if (useDynamo) {
            Map<String, AttributeValue> item = new HashMap<>();
            item.put("id", AttributeValue.builder().s(book.getId()).build());
            item.put("title", AttributeValue.builder().s(book.getTitle()).build());
            item.put("author", AttributeValue.builder().s(book.getAuthor()).build());
            item.put("issued", AttributeValue.builder().bool(book.isIssued()).build());
            item.put("price", AttributeValue.builder().n(String.valueOf(book.getPrice())).build());
            dynamoDb.putItem(PutItemRequest.builder().tableName(TABLE_NAME).item(item).build());
        } else {
            if (inMemory.containsKey(book.getId()))
                throw new IllegalArgumentException("Book ID " + book.getId() + " already exists.");
            inMemory.put(book.getId(), book);
        }
    }

    // Get all books
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

    // Get book by ID
    public Book getBookById(String id) {
        if (useDynamo) {
            GetItemResponse resp = dynamoDb.getItem(GetItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("id", AttributeValue.builder().s(id).build()))
                    .build());
            return resp.hasItem() ? mapToBook(resp.item()) : null;
        } else {
            return inMemory.get(id);
        }
    }

    // Search by title (partial match)
    public List<Book> getBooksByTitle(String titlePart) {
        if (useDynamo) {
            ScanRequest req = ScanRequest.builder()
                    .tableName(TABLE_NAME)
                    .filterExpression("contains(title, :t)")
                    .expressionAttributeValues(Map.of(":t", AttributeValue.builder().s(titlePart).build()))
                    .build();

            ScanResponse resp = dynamoDb.scan(req);
            List<Book> out = new ArrayList<>();
            for (Map<String, AttributeValue> item : resp.items()) {
                out.add(mapToBook(item));
            }
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

    // Search by author (partial match)
    public List<Book> getBooksByAuthor(String authorPart) {
        if (useDynamo) {
            ScanRequest req = ScanRequest.builder()
                    .tableName(TABLE_NAME)
                    .filterExpression("contains(author, :a)")
                    .expressionAttributeValues(Map.of(":a", AttributeValue.builder().s(authorPart).build()))
                    .build();

            ScanResponse resp = dynamoDb.scan(req);
            List<Book> out = new ArrayList<>();
            for (Map<String, AttributeValue> item : resp.items()) {
                out.add(mapToBook(item));
            }
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


    // Issue book
    public void issueBook(String id) {
        Book b = getBookById(id);
        if (b == null) throw new IllegalArgumentException("Book ID " + id + " not found.");
        if (b.isIssued()) throw new IllegalStateException("Book ID " + id + " is already issued.");
        if (useDynamo) {
            dynamoDb.updateItem(UpdateItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("id", AttributeValue.builder().s(id).build()))
                    .updateExpression("SET issued = :val")
                    .expressionAttributeValues(Map.of(":val", AttributeValue.builder().bool(true).build()))
                    .build());
        } else {
            b.setIssued(true);
            inMemory.put(id, b);
        }
    }

    // Return book
    public void returnBook(String id) {
        Book b = getBookById(id);
        if (b == null) throw new IllegalArgumentException("Book ID " + id + " not found.");
        if (useDynamo) {
            dynamoDb.updateItem(UpdateItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("id", AttributeValue.builder().s(id).build()))
                    .updateExpression("SET issued = :val")
                    .expressionAttributeValues(Map.of(":val", AttributeValue.builder().bool(false).build()))
                    .build());
        } else {
            b.setIssued(false);
            inMemory.put(id, b);
        }
    }

    // Delete book
    public void deleteBook(String id) {
        if (useDynamo) {
            dynamoDb.deleteItem(DeleteItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Map.of("id", AttributeValue.builder().s(id).build()))
                    .build());
        } else {
            inMemory.remove(id);
        }
    }

    // Map DynamoDB item to Book object
    private Book mapToBook(Map<String, AttributeValue> item) {
        String id = item.containsKey("id") ? item.get("id").s() : null;
        String title = item.containsKey("title") ? item.get("title").s() : null;
        String author = item.containsKey("author") ? item.get("author").s() : null;
        boolean issued = item.containsKey("issued") && item.get("issued").bool();
        double price = item.containsKey("price") ? Double.parseDouble(item.get("price").n()) : 0.0;
        return new Book(id, title, author, price, issued);

    }

}
