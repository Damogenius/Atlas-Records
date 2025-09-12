package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import software.amazon.awssdk.regions.Region;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Load_Table {
    public static void main(String[] args) throws IOException {
        //Client Connection
        DynamoDbClient dynamodb = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .region(Region.AP_SOUTH_1)
                .build();

        String Tablename="Users";

//object Mapper
        ObjectMapper mapper = new ObjectMapper();

        //giving input stream of data
        InputStream stream = Load_Table.class.getClassLoader()
                .getResourceAsStream(("Employee.json"));
        System.out.println("the json file in the input stream");
        JsonNode node = mapper.readTree(stream);

        Iterator<JsonNode> iterator = node.elements();

        while (iterator.hasNext()) {
            JsonNode Jsonnode2 = iterator.next();
            Map<String, AttributeValue> item = new HashMap<>();
            item.put("UserId", AttributeValue.builder().s(Jsonnode2.get("ID").asText()).build());
            item.put("Name", AttributeValue.builder().s(Jsonnode2.get("Name").asText()).build());
            item.put("Address", AttributeValue.builder().s(Jsonnode2.get("Address").asText()).build());

            PutItemRequest request = PutItemRequest.builder()
                    .tableName(Tablename)
                    .item(item)
                    .build();

            dynamodb.putItem(request);
            System.out.println(" loading the data to the table");
        }
        dynamodb.close();
        System.out.println("closing client connection");
    }
}
