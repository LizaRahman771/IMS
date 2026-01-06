package com.Loddo.InventoryMgtSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    // ✅ Phase-1 dummy suppliers
    private final List<Map<String, Object>> suppliers = new ArrayList<>();

    public SupplierController() {
        suppliers.add(createSupplier(1, "Samsung Supplier"));
        suppliers.add(createSupplier(2, "Apple Supplier"));
        suppliers.add(createSupplier(3, "Local Wholesale Supplier"));

        for (int i = 4; i <= 20; i++) {
            suppliers.add(createSupplier(i, "Supplier " + i));
        }
    }

    private Map<String, Object> createSupplier(int id, String name) {
        Map<String, Object> s = new HashMap<>();
        s.put("id", id);
        s.put("name", name);
        return s;
    }

    // ✅ Supplier list page
    @GetMapping
    public String supplierPage(Model model) {
        model.addAttribute("title", "Suppliers");
        model.addAttribute("content", "pages/supplier :: content");
        model.addAttribute("suppliers", suppliers);
        return "layout";
    }

    // ✅ Add supplier page
    @GetMapping("/add")
    public String addSupplierPage(Model model) {
        model.addAttribute("title", "Add Supplier");
        model.addAttribute("content", "pages/supplier-form :: content");
        model.addAttribute("isEditing", false);
        model.addAttribute("supplier", null);
        return "layout";
    }

    // ✅ Edit supplier page
    @GetMapping("/edit/{id}")
    public String editSupplierPage(@PathVariable Integer id, Model model) {

        Map<String, Object> supplier = suppliers.stream()
                .filter(s -> s.get("id").equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("title", "Edit Supplier");
        model.addAttribute("content", "pages/supplier-form :: content");
        model.addAttribute("isEditing", true);
        model.addAttribute("supplier", supplier);

        return "layout";
    }

    // ✅ Save supplier
    @PostMapping("/save")
    public String saveSupplier(@RequestParam String name) {

        if (name == null || name.trim().isEmpty()) {
            return "redirect:/supplier/add?error=Supplier%20name%20cannot%20be%20empty";
        }

        int newId = suppliers.size() + 1;
        suppliers.add(createSupplier(newId, name));

        return "redirect:/supplier?message=Supplier%20successfully%20added";
    }

    // ✅ Update supplier
    @PostMapping("/update")
    public String updateSupplier(@RequestParam Integer id,
                                 @RequestParam String name) {

        suppliers.stream()
                .filter(s -> s.get("id").equals(id))
                .findFirst()
                .ifPresent(s -> s.put("name", name));

        return "redirect:/supplier?message=Supplier%20successfully%20updated";
    }

    // ✅ Delete supplier
    @PostMapping("/delete")
    public String deleteSupplier(@RequestParam Integer id) {
        suppliers.removeIf(s -> s.get("id").equals(id));
        return "redirect:/supplier?message=Supplier%20successfully%20deleted";
    }
}
