package com.example.lab_1.models;

import com.example.lab_1.enums.RoleType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private RoleType name;
}
