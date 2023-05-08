package com.example.demoapi.repo;

import com.example.demoapi.entity.Role;
import com.example.demoapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
