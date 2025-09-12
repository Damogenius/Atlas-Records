package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.regions.Region;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class ScanTable {
    public static void main(String[] args) throws IOException {
        //Client Connection
        DynamoDbClient dynamodb = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .build();

        String Tablename = "Users";
        try {
            // Create scan request
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(Tablename)
                    .build();

            // Perform scan operation
            ScanResponse response = dynamodb.scan(scanRequest);

            // Get list of items returned by scan
            List<Map<String, AttributeValue>> items = response.items();

            System.out.println("Scan results:");

            // Iterate and print each item
            for (Map<String, AttributeValue> item : items) {
                System.out.println("Item:");
                for (String key : item.keySet()) {
                    AttributeValue val = item.get(key);
                    // Print attribute key and value (handle types)
                    if (val.s() != null) {
                        System.out.println("  " + key + ": " + val.s());
                    } else if (val.n() != null) {
                        System.out.println("  " + key + ": " + val.n());
                    } else {
                        System.out.println("  " + key + ": " + val.toString());
                    }
                }
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            System.err.println("Error scanning table: " + e.getMessage());
        } finally {
            dynamodb.close();
        }
    }
}