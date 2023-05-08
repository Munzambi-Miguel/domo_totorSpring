package com.example.demoapi;

import com.example.demoapi.entity.Role;
import com.example.demoapi.entity.User;
import com.example.demoapi.entity.UserRole;
import com.example.demoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApiApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("inicializando o spring boot");

        User user = new User();

        user.setFirstName("Munzambi");
        user.setLastName("Miguel");
        user.setUsername("munzambi.miguel");
        user.setPassword("miguel2023");

        user.setEmail("munzambi.miguel@gmail.com");
        user.setProfile("default.png");

        Role role = new Role();
        role.setId(44L);
        role.setName("ADMIN");

        Set<UserRole> userRoleSet = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        userRoleSet.add(userRole);
        User userCreated = this.userService.create(user, userRoleSet);

        System.out.println(userCreated.getUsername());

    }
}
