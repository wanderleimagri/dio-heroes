package com.digitalinnovation.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static com.digitalinnovation.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovation.heroesapi.constants.HeroesConstant.REGION_DYNAMO;

@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {

    public static void main(String[] args) throws Exception {
        var client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();

        var dynamoDB = new DynamoDB(client);

        var tableName = "heroes_table";
        var table = dynamoDB.createTable(tableName,
                Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                new ProvisionedThroughput(5L, 5l));
        table.waitForActive();
    }
}
