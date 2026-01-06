package com.Loddo.InventoryMgtSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    // ✅ Dummy products + suppliers (later from DB)
    private final List<Map<String, Object>> products = new ArrayList<>();
    private final List<Map<String, Object>> suppliers = new ArrayList<>();

    public PurchaseController() {

        // dummy products
        products.add(createProduct(1, "iPhone 15 Pro"));
        products.add(createProduct(2, "MacBook Air"));
        products.add(createProduct(3, "Samsung S24"));

        // dummy suppliers
        suppliers.add(createSupplier(1, "Apple Supplier"));
        suppliers.add(createSupplier(2, "Samsung Supplier"));
        suppliers.add(createSupplier(3, "Local Wholesale Supplier"));
    }

    private Map<String, Object> createProduct(int id, String name) {
        Map<String, Object> p = new HashMap<>();
        p.put("id", id);
        p.put("name", name);
        return p;
    }

    private Map<String, Object> createSupplier(int id, String name) {
        Map<String, Object> s = new HashMap<>();
        s.put("id", id);
        s.put("name", name);
        return s;
    }

    // ✅ GET Purchase page
    @GetMapping
    public String purchasePage(Model model) {

        model.addAttribute("title", "Purchase");
        model.addAttribute("content", "pages/purchase :: content");

        model.addAttribute("products", products);
        model.addAttribute("suppliers", suppliers);

        return "layout";
    }

    // ✅ POST Purchase submit (Phase-1 dummy)
    @PostMapping
    public String doPurchase(@RequestParam Integer productId,
                             @RequestParam Integer supplierId,
                             @RequestParam String description,
                             @RequestParam String note,
                             @RequestParam Integer quantity) {

        // ✅ Phase-1: just redirect with success message
        return "redirect:/purchase?message=Purchase%20successfully%20saved";
    }
}
