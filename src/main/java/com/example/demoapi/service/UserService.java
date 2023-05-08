package com.example.demoapi.service;

import com.example.demoapi.entity.User;
import com.example.demoapi.entity.UserRole;
import java.util.Set;
public interface UserService {

    public User create(User user, Set<UserRole> userRoles) throws Exception;
}
