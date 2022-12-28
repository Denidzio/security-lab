package com.example.lab_1.services;

import com.example.lab_1.enums.RoleType;
import com.example.lab_1.models.Role;
import com.example.lab_1.repositories.RoleRepository;
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
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getOne(String id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null);
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public Role update(String id, Role role) {
        role.setId(id);
        return roleRepository.save(role);
    }

    public Role delete(String id) {
        Role role = this.getOne(id);
        roleRepository.deleteById(id);
        return role;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getByName(RoleType name) {
        Optional<Role> role = roleRepository.getRoleByName(name);
        return role.orElse(null);
    }
}
