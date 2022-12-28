package com.example.lab_1.controllers;

import com.example.lab_1.models.User;
import com.example.lab_1.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Denys Lunhu
 * @since : 26.12.2022, Mon
 **/

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public User getUser(@PathVariable String id) {
        return userService.getOne(id);
    }

    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public User deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }

    @GetMapping()
    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
