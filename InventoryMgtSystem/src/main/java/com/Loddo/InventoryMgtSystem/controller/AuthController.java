package com.Loddo.InventoryMgtSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    // ✅ LOGIN PAGE
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute("content", "pages/login :: content");
        return "auth-layout";
    }

    // ✅ REGISTER PAGE
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("content", "pages/register :: content");
        return "auth-layout";
    }

    // ✅ REGISTER SUBMIT (POST) ✅ ONLY ONE METHOD HERE
    @PostMapping("/register")
    public String doRegister(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String phoneNumber,
                             RedirectAttributes redirectAttributes) {

        // ✅ Phase-1 dummy register (Later MongoDB save)
        redirectAttributes.addFlashAttribute("message", "Registration Successfull ✅");

        return "redirect:/login";
    }

    // ✅ LOGOUT
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
