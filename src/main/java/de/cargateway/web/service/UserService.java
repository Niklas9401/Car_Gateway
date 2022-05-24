package de.cargateway.web.service;

import de.cargateway.web.entity.Role;
import de.cargateway.web.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
