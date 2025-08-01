package com.iam.iamdashboard.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String username;
    private Role role;

    public User(){

    }

    public User(Long id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public Role getRole() {
        return role;
    }
    public void setUsername(String username) { this.username = username; }
    public void setRole(Role role) { this.role = role; }




}
