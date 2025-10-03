package org.ELibrary;

import org.ELibrary.Controller.BookController;
import org.ELibrary.Service.BookService;
import org.ELibrary.Service.CheckoutService;
import org.ELibrary.Service.RecommendationService;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

public class Main {
    public static void main(String[] args) {

        DynamoDbClient dynamoDb = DynamoDbClient.builder()
                .region(Region.AP_SOUTH_1)
                .endpointOverride(URI.create("http://localhost:8000"))
                .build();

        BookService bookService = new BookService(dynamoDb);
        CheckoutService checkoutService = new CheckoutService(dynamoDb);
        RecommendationService recommendationService = new RecommendationService(dynamoDb);

        BookController controller = new BookController(bookService, checkoutService, recommendationService);
        controller.start();
    }
}
