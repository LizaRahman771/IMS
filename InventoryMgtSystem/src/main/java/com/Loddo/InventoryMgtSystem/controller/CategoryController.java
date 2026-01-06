package com.Loddo.InventoryMgtSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    // ✅ Phase-1 dummy data store (later MongoDB)
    private final List<Map<String, Object>> categories = new ArrayList<>();

    public CategoryController() {
        // dummy initial categories
        categories.add(createCategory(1, "Electronics"));
        categories.add(createCategory(2, "Grocery"));
        categories.add(createCategory(3, "Fashion"));
    }

    private Map<String, Object> createCategory(int id, String name) {
        Map<String, Object> cat = new HashMap<>();
        cat.put("id", id);
        cat.put("name", name);
        return cat;
    }

    // ✅ GET: show category page
    @GetMapping
    public String categoryPage(
            @RequestParam(required = false) Integer editId,
            Model model
    ) {
        model.addAttribute("title", "Category");
        model.addAttribute("content", "pages/category :: content");
        model.addAttribute("categories", categories);

        if (editId != null) {
            categories.stream()
                    .filter(c -> c.get("id").equals(editId))
                    .findFirst()
                    .ifPresent(cat -> {
                        model.addAttribute("isEditing", true);
                        model.addAttribute("editingCategoryId", editId);
                        model.addAttribute("categoryName", cat.get("name"));
                    });
        } else {
            model.addAttribute("isEditing", false);
            model.addAttribute("categoryName", "");
        }

        return "layout";
    }

    // ✅ POST: Add Category
    @PostMapping("/add")
    public String addCategory(@RequestParam String name) {

        if (name == null || name.trim().isEmpty()) {
            return "redirect:/category?error=Category%20name%20cannot%20be%20empty";
        }

        int newId = categories.size() + 1;
        categories.add(createCategory(newId, name));

        return "redirect:/category?message=Category%20successfully%20added";
    }

    // ✅ POST: Update Category
    @PostMapping("/update")
    public String updateCategory(@RequestParam Integer id,
                                 @RequestParam String name) {

        categories.stream()
                .filter(c -> c.get("id").equals(id))
                .findFirst()
                .ifPresent(cat -> cat.put("name", name));

        return "redirect:/category?message=Category%20successfully%20updated";
    }

    // ✅ POST: Delete Category
    @PostMapping("/delete")
    public String deleteCategory(@RequestParam Integer id) {

        categories.removeIf(c -> c.get("id").equals(id));

        return "redirect:/category?message=Category%20successfully%20deleted";
    }
}
