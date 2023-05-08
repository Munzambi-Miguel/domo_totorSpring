package com.example.demoapi.service.impl;

import com.example.demoapi.entity.User;
import com.example.demoapi.entity.UserRole;
import com.example.demoapi.repo.RoleRepository;
import com.example.demoapi.repo.UserRepository;
import com.example.demoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User create(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());

        if (local != null) {
            System.out.printf("User is already there !!");
            throw new Exception("User already present");
        }

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);
        local = this.userRepository.save(user);

        return local;
    }
}
