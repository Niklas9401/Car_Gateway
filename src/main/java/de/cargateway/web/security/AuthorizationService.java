package de.cargateway.web.security;

import de.cargateway.web.entity.Role;

public interface AuthorizationService {

    void assertRole(Role... allowedRoles); // hier auch der import
}
