package com.example.lab_1.services;

import com.example.lab_1.enums.RoleType;
import com.example.lab_1.models.Role;
import com.example.lab_1.models.User;
import com.example.lab_1.security.jwt.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : Denys Lunhu
 * @since : 25.12.2022, Sun
 **/

@Service
@AllArgsConstructor
public class AuthService {
    private final UserService userService;
    private final RoleService roleService;

    private JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    private User getByUserByUsernameAndPassword(String username, String password) {
        User user = userService.getByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }

    public String login(String username, String password) {
        User user = getByUserByUsernameAndPassword(username, password);

        if (user == null) {
            throw new BadCredentialsException("Bad credentials");
        }

        return jwtProvider.generateToken(user.getUsername());
    }

    public User register(User user) {
        Role defaultRole = roleService.getByName(RoleType.ROLE_CLIENT);

        user.setRole(defaultRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userService.create(user);
    }
}
