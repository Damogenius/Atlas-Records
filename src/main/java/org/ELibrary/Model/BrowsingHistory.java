//package org.ELibrary.Model;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class BrowsingHistory {
//    private LinkedList<Book> history = new LinkedList<>();
//    private static final int MAX_HISTORY = 10;
//
//    public void addBook(Book book) {
//        if (history.size() >= MAX_HISTORY) {
//            history.removeLast();
//        }
//        history.addFirst(book);
//    }
//
//    public List<Book> getHistory() {
//        return history;
//    }
//
//    public void setHistory(List<Book> pastHistory) {
//        history = new LinkedList<>(pastHistory);
//    }
//}
