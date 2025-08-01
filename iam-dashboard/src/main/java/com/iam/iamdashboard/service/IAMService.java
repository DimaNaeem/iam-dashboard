package com.iam.iamdashboard.service;
import com.iam.iamdashboard.model.AuditLog;

import com.iam.iamdashboard.model.Permission;
import com.iam.iamdashboard.model.Role;
import com.iam.iamdashboard.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IAMService {

    private final Map<String, User> userStore = new HashMap<>();
    private final Map<String, Role> roleStore = new HashMap<>();
    private final List<Permission> permissions = new ArrayList<>();
    private final List<AuditLog> auditLogs = new ArrayList<>();


    public IAMService() {
        // Sample Permissions
        Permission readPermission = new Permission("READ");
        Permission writePermission = new Permission("WRITE");
        Permission deletePermission = new Permission("DELETE");

        permissions.add(readPermission);
        permissions.add(writePermission);
        permissions.add(deletePermission);

        // Sample Roles
        Role adminRole = new Role("Admin");
        Role userRole = new Role("User");

        // Assign permissions to roles
        adminRole.addPermission(readPermission);
        adminRole.addPermission(writePermission);
        adminRole.addPermission(deletePermission);

        userRole.addPermission(readPermission);

        roleStore.put("Admin", adminRole);
        roleStore.put("User", userRole);

        // Sample Users
        User alice = new User(1L, "alice", adminRole);
        User bob = new User(2L, "bob", userRole);

        userStore.put("alice", alice);
        userStore.put("bob", bob);
    }

    public Collection<User> getAllUsers() {
        return userStore.values();
    }

    public User getUser(String username) {
        return userStore.get(username);
    }

    public Collection<Role> getAllRoles() {
        return roleStore.values();
    }

    public Collection<Permission> getAllPermissions() {
        return permissions;
    }

    // Optional: add user
    public void addUser(User user) {
        if (user.getRole() == null) {
            user.setRole(roleStore.get("User")); // Assign default role
        }


        // Replace the simple role with the actual object from store
        Role assignedRole = roleStore.get(user.getRole().getName());
        user.setRole(assignedRole);  // ✅ important

        userStore.put(user.getUsername(), user);

        // Add to audit log
        String logMessage = "User '" + user.getUsername() + "' was assigned role '" + assignedRole.getName() + "'";
        auditLogs.add(new AuditLog(logMessage));
    }


    public List<AuditLog> getAuditLogs() {
        return auditLogs;
    }


    // Optional: get role by name
    public Role getRole(String roleName) {
        return roleStore.get(roleName);
    }
}
