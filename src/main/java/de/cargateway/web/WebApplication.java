package de.cargateway.web;

import de.cargateway.web.entity.Role;
import de.cargateway.web.entity.User;
import de.cargateway.web.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_WORKER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//
//			userService.saveUser(new User(null, "Niklas Weiblen", "Testuser1", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "Thomas Klein", "tk", "1234567", new ArrayList<>()));
//			userService.saveUser(new User(null, "Manfred Mevenkamp", "Testuser3", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "Jan Bredereke", "Moin", "1234", new ArrayList<>()));
//
//			userService.addRoleToUser("Moin", "ROLE_WORKER");
//			userService.addRoleToUser("tk", "ROLE_USER");
//			userService.addRoleToUser("Testuser3", "ROLE_WORKER");
//			userService.addRoleToUser("Testuser1", "ROLE_ADMIN");
//		};
//	}
}
