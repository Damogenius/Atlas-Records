package org.ELibrary;
import org.ELibrary.Service.BookService;
import org.ELibrary.Inventory.BookInventory;
import org.ELibrary.Controller.BookController;
import org.ELibrary.Model.Book;
import org.ELibrary.Service.CheckoutService;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        DynamoDbClient dynamoDb = DynamoDbClient.builder()
                .region(Region.US_EAST_1)  // can be any region for local
                .endpointOverride(URI.create("http://localhost:8000"))
                .build();

        System.out.println("Hello Bookstore!");

        BookService service = new BookService(dynamoDb);
        CheckoutService checkout=new CheckoutService();// default: in-memory (fast to run)
        BookController controller = new BookController(service,checkout);
        controller.start();
    }
}


