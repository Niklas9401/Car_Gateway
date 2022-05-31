package de.cargateway.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthenticationService authenticationService;
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // TODO methode robust machen
        String authorizationHeader = request.getHeader("Authorization");

        String token = authorizationHeader.substring("Bearer ".length());
        authenticationService.authenticate(token);

        return true;
    }
}
