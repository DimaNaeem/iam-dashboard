package com.iam.iamdashboard.controller;

import com.iam.iamdashboard.model.Permission;
import com.iam.iamdashboard.model.Role;
import com.iam.iamdashboard.model.User;
import com.iam.iamdashboard.service.IAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller

public class UserController {

    private final IAMService iamService;

    @Autowired
    public UserController(IAMService iamService) {
        this.iamService = iamService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from User controller";
    }

    // ✅ This method displays the Thymeleaf users.html
    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", iamService.getAllUsers());
        return "users";
    }

    // ✅ Optional: Use this only for JSON data
    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username) {
        return iamService.getUser(username);
    }

    @GetMapping("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", iamService.getAllRoles());
        return "add-user";
    }



    @GetMapping("/roles-json")
    @ResponseBody
    public Collection<Role> getAllRoles() {
        return iamService.getAllRoles();
    }

    @GetMapping("/permissions")
    public Collection<Permission> getAllPermissions() {
        return iamService.getAllPermissions();
    }
    @GetMapping("/roles")
    public String showRoles(Model model) {
        model.addAttribute("roles", iamService.getAllRoles());
        return "roles";  // maps to roles.html
    }


    @PostMapping("/users")
    public String createUser(@ModelAttribute User user) {
        iamService.addUser(user); // Store user
        return "redirect:/users"; // Redirect to user list
    }
    @GetMapping("/logs")
    public String showAuditLogs(Model model) {
        model.addAttribute("logs", iamService.getAuditLogs());
        return "logs"; // → logs.html
    }







}
