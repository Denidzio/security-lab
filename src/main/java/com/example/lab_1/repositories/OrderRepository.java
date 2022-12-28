package com.example.lab_1.repositories;

import com.example.lab_1.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Denys Lunhu
 * @since : 26.12.2022, Mon
 **/

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
