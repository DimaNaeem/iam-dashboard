
package com.iam.iamdashboard.model;

import java.util.List;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private String name;
    private List<Permission> permissions = new ArrayList<>();


    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public List<Permission> getPermissions() {
        return permissions;
    }

    public void addPermission(Permission p) {
        permissions.add(p);
    }
}