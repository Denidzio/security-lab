package com.example.lab_1.services;

import com.example.lab_1.models.User;
import com.example.lab_1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getOne(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(String id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public User delete(String id) {
        User user = this.getOne(id);
        userRepository.deleteById(id);
        return user;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByUsername(String username) {
        Optional<User> user = userRepository.getUserByUsername(username);
        return user.orElse(null);
    }
}
