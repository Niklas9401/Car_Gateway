package de.cargateway.web.security;

import de.cargateway.web.entity.Role;
import de.cargateway.web.entity.User;
import de.cargateway.web.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public void assertRole(Role... allowedRoles) {
        Set<String> allowedRolesSet = Stream.of(allowedRoles)
                .map(Role::getName)
                .collect(Collectors.toSet());

        User user = this.authenticationService.getCurrentUser();
        Set<String> owningRoleNames = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        boolean hasUserRequiredRole = CollectionUtils.atLeastOneMatch(allowedRolesSet, owningRoleNames);
        if (!hasUserRequiredRole) {
            // TODO throw access denied exception oder so
            throw new AccessDeniedException("User has not required role!");
        }
    }
}
// verschieb mal AuthorizationService und AuthorizationServiceImpl in das package security
// Wo sind die überhaupt xD Hab die gar nicht als Datei links
// drück mal oben das fadenkreuz. Headshot. AWP