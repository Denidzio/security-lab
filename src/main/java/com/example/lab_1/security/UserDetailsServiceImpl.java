package com.example.lab_1.security;

import com.example.lab_1.models.User;
import com.example.lab_1.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl {
    private final UserService userService;

    public UserDetailsImpl getUserByUsername(String username) {
        User user = userService.getByUsername(username);
        return UserDetailsImpl.fromUserToCustomUserDetails(user);
    }
}
