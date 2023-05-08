package com.example.demoapi.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
 @Table(name = "roles")
public class Role {


    @Id
    private Long id;
    private String Name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
