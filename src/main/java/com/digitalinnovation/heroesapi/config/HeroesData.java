package com.digitalinnovation.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import static com.digitalinnovation.heroesapi.constants.HeroesConstant.*;

import java.util.Arrays;

public class HeroesData {

    public static void main(String[] args) throws Exception {
        var client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();

        var dynamoDB = new DynamoDB(client);

        var table = dynamoDB.getTable("heroes_table");
        Item hero = new Item()
                .withPrimaryKey("id","1")
                .withString("name","Mulher Maravilha")
                .withString("universe","dc comics")
                .withNumber("films",3);

        PutItemOutcome outcom= table.putItem(hero);
    }
}
