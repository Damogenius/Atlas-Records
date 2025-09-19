package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.regions.Region;
import java.net.URI;
public class DescribeTable {
    public static void main(String[] args) {

DynamoDbClient dynamodb = DynamoDbClient.builder()
        .endpointOverride(URI.create("http://localhost:8000"))
        .region(Region.AP_SOUTH_1)
        .build();

String TableName="Users";
        try{
DescribeTableRequest request =DescribeTableRequest.builder()
        .tableName(TableName)
        .build();
DescribeTableResponse response= dynamodb.describeTable(request);

TableDescription table = response.table();

        System.out.println("Table Name: " + table.tableName());
        System.out.println("Table Status: " + table.tableStatusAsString());
        System.out.println("Item Count: " + table.itemCount());
        System.out.println("Key Schema: " + table.keySchema());
        System.out.println("Provisioned Throughput: " + table.provisionedThroughput());
        System.out.println("Creation Date: " + table.creationDateTime());



        }
        catch (ResourceNotFoundException e)
        {
            System.out.println("Table Not Found" +TableName);
        }
        catch (DynamoDbException e)
        {
            System.out.println("Failed to describe Table" +e.getMessage());
        }
        finally {
            dynamodb.close();
        }
    }
}
