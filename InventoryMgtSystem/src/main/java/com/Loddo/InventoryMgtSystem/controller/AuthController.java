package com.Loddo.InventoryMgtSystem.controller;

import com.Loddo.InventoryMgtSystem.dtos.RegisterRequest;
import com.Loddo.InventoryMgtSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute("content", "pages/login :: content");
        return "auth-layout";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("content", "pages/register :: content");
        return "auth-layout";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute RegisterRequest registrationData, RedirectAttributes ra) {
        try {
            userService.registerUser(registrationData);
            ra.addFlashAttribute("message", "Registration Successful! Please Login. ✅");
            return "redirect:/login";
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }
}
