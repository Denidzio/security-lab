package com.example.lab_1.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author : Denys Lunhu
 * @since : 26.12.2022, Mon
 **/

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    @DBRef
    private User client;
    private List<Dish> dishes;
}
