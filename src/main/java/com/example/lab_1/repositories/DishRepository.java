package com.example.lab_1.repositories;

import com.example.lab_1.models.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Repository
public interface DishRepository extends MongoRepository<Dish, String> {
}
