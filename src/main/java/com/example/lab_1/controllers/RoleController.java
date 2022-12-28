package com.example.lab_1.controllers;

import com.example.lab_1.models.Role;
import com.example.lab_1.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Denys Lunhu
 * @since : 26.12.2022, Mon
 **/

@RestController
@RequestMapping("/api/role")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public Role getRole(@PathVariable String id) {
        return roleService.getOne(id);
    }

    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public Role updateRole(@PathVariable String id, @RequestBody Role role) {
        return roleService.update(id, role);
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public Role createRole(@RequestBody Role role) {
        return roleService.create(role);
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public Role deleteRole(@PathVariable String id) {
        return roleService.delete(id);
    }

    @GetMapping()
    @Secured("ROLE_ADMIN")
    public List<Role> getAllRoles() {
        return roleService.getAll();
    }
}
