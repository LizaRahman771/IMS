package com.Loddo.InventoryMgtSystem.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profilePage(Model model) {

        // ✅ Get logged-in username from Spring Security
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // this will be email/username

        // ✅ Phase-1 dummy user info (later MongoDB)
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Admin User");
        user.put("email", username);
        user.put("phoneNumber", "01700000000");
        user.put("role", "ADMIN");

        model.addAttribute("title", "Profile");
        model.addAttribute("content", "pages/profile :: content");
        model.addAttribute("user", user);

        return "layout";
    }
}
