package de.cargateway.web.security;

import de.cargateway.web.entity.User;

public interface AuthenticationService {
    void authenticate(String token);
    User getCurrentUser();
}
