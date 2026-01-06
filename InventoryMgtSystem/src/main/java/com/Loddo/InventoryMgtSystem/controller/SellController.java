package com.Loddo.InventoryMgtSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/sell")
public class SellController {

    // ✅ Dummy products (later from MongoDB)
    private final List<Map<String, Object>> products = new ArrayList<>();

    public SellController() {
        products.add(createProduct(1, "iPhone 15 Pro"));
        products.add(createProduct(2, "MacBook Air"));
        products.add(createProduct(3, "Samsung S24"));
        products.add(createProduct(4, "Headphone"));
        products.add(createProduct(5, "Mouse"));
    }

    private Map<String, Object> createProduct(int id, String name) {
        Map<String, Object> p = new HashMap<>();
        p.put("id", id);
        p.put("name", name);
        return p;
    }

    // ✅ GET Sell page
    @GetMapping
    public String sellPage(Model model) {
        model.addAttribute("title", "Sell");
        model.addAttribute("content", "pages/sell :: content");
        model.addAttribute("products", products);
        return "layout";
    }

    // ✅ POST Sell submit (Phase-1 dummy)
    @PostMapping
    public String doSell(@RequestParam Integer productId,
                         @RequestParam Integer quantity,
                         @RequestParam String description,
                         @RequestParam String note) {

        // ✅ Phase-1: no real selling, just success message
        return "redirect:/sell?message=Product%20successfully%20sold";
    }
}
