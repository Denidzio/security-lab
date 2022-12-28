package com.example.lab_1.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Data
@Document(collection = "dishes")
public class Dish {
    @Id
    private String id;
    private String name;
    private Float price;
}
