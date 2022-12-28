package com.example.lab_1.repositories;

import com.example.lab_1.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> getUserByUsername(String username);
}
