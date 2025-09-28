package org.example;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dax.DaxClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class AcceleratorDAXDemo4 {

    public static void main(String[] args) {
        String daxEndpoint = "daxs://daxcluster01.ee3lf0.dax-clusters.ap-south-1.amazonaws.com";

        DaxClient daxClient = DaxClient.builder()
                .endpointOverride(URI.create(daxEndpoint))
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();

        String tableName = "DaxDynamoTable";
        String keyName = "Id";
        String keyValue = "1001";

        Map<String, AttributeValue> item = new HashMap<>();
        item.put(keyName, AttributeValue.builder().s(keyValue).build());
        item.put("message", AttributeValue.builder().s("Hello from DAX!").build());

        PutItemRequest putReq = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();

        //daxClient.putItem(putReq);

        Map<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put(keyName, AttributeValue.builder().s(keyValue).build());

        GetItemRequest getReq = GetItemRequest.builder()
                .tableName(tableName)
                .key(keyToGet)
                .build();

        System.out.printf("Item from DAX: %s : %s", keyName,keyValue);

        daxClient.close();
    }
}
