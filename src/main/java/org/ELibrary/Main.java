package org.ELibrary;
import org.ELibrary.Service.BookService;
import org.ELibrary.Inventory.BookInventory;
import org.ELibrary.Controller.BookController;
import org.ELibrary.Model.Book;
import org.ELibrary.Service.CheckoutService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Bookstore!");
        BookService service = new BookService(dynamoDb);
        CheckoutService checkout=new CheckoutService();// default: in-memory (fast to run)
        BookController controller = new BookController(service,checkout);
        controller.start();
    }
}


