package com.iam.iamdashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // maps to dashboard.html
    }
}
