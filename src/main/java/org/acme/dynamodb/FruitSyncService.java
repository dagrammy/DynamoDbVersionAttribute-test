package org.acme.dynamodb;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@ApplicationScoped
public class FruitSyncService extends AbstractService {


    private final DynamoDbClient dynamoDB;

    private final DynamoDbEnhancedClient dynamoEnhancedClient;

    private DynamoDbTable<Fruit> fruitTable;

    @Inject
    FruitSyncService(DynamoDbClient dynamoDB, DynamoDbEnhancedClient dynamoEnhancedClient) {
        this.dynamoDB = dynamoDB;
        this.dynamoEnhancedClient = dynamoEnhancedClient;
        fruitTable = this.dynamoEnhancedClient.table(getTableName(),
            TableSchema.fromClass(Fruit.class));
    }

    public List<Fruit> findAll() {
        return fruitTable.scan().items().stream().collect(Collectors.toList());
    }

    public List<Fruit> add(Fruit fruit) {
        fruitTable.putItem(fruit);
        return findAll();
    }

    public Fruit get(String name) {
        Key partitionKey = Key.builder().partitionValue(name).build();
        return fruitTable.getItem(partitionKey);
    }
}