package com.example.lab_1.repositories;

import com.example.lab_1.enums.RoleType;
import com.example.lab_1.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> getRoleByName(RoleType name);
}
