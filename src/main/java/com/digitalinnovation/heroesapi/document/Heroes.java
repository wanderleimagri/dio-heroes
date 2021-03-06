package com.digitalinnovation.heroesapi.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

@Data
@NoArgsConstructor
@Getter
@Setter
@DynamoDBTable(tableName = "heroes_table")
public class Heroes {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;
    @DynamoDBAttribute(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "universe")
    private String universe;
    @DynamoDBAttribute(attributeName = "films")
    private int films;

    public Heroes(String id, String name, String universe, int films) {
        this.id = id;
        this.name = name;
        this.universe = universe;
        this.films = films;
    }
}
