package org.ELibrary.Model;

import java.util.Objects;

public class Book {
    private String id;
    private String title;
    private String author;
    private double price;
    private boolean issued;

    public Book(String id, String title, String author, double price, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.issued = issued;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public boolean isIssued() { return issued; }

    public void setIssued(boolean issued) { this.issued = issued; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return String.format("[%s] %s by %s ($%.2f)%s",
                id, title, author, price, issued ? " [Issued]" : "");
    }
}
