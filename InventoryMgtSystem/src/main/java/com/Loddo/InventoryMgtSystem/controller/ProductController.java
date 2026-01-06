package com.Loddo.InventoryMgtSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    // ✅ Dummy products (Phase-1)
    private final List<Map<String, Object>> products = new ArrayList<>();

    // ✅ Dummy categories (Phase-1) - later from Category table
    private final List<Map<String, Object>> categories = new ArrayList<>();

    public ProductController() {

        // ✅ Dummy categories
        categories.add(createCategory(1, "Electronics"));
        categories.add(createCategory(2, "Grocery"));
        categories.add(createCategory(3, "Fashion"));

        // ✅ Dummy products
        products.add(createProduct(1, "iPhone 15 Pro", "SKU001", 1200, 20, 1, "Best Apple Phone", "/images/default-product.png"));
        products.add(createProduct(2, "MacBook Air", "SKU002", 1500, 10, 1, "Apple Laptop", "/images/default-product.png"));
        products.add(createProduct(3, "Samsung S24", "SKU003", 900, 30, 1, "Samsung Flagship", "/images/default-product.png"));

        // ✅ More dummy products for pagination
        for (int i = 4; i <= 35; i++) {
            products.add(createProduct(i, "Product " + i, "SKU" + i, 100 + i, 5 + i, 2,
                    "Description for product " + i, "/images/default-product.png"));
        }
    }

    // ✅ Create Category Map
    private Map<String, Object> createCategory(int id, String name) {
        Map<String, Object> c = new HashMap<>();
        c.put("id", id);
        c.put("name", name);
        return c;
    }

    // ✅ Create Product Map
    private Map<String, Object> createProduct(int id,
                                              String name,
                                              String sku,
                                              int price,
                                              int qty,
                                              int categoryId,
                                              String description,
                                              String img) {

        Map<String, Object> p = new HashMap<>();
        p.put("id", id);
        p.put("name", name);
        p.put("sku", sku);
        p.put("price", price);
        p.put("stockQuantity", qty);
        p.put("categoryId", categoryId);
        p.put("description", description);
        p.put("imageUrl", img);
        return p;
    }

    // ✅ GET: Product List Page with Pagination
    @GetMapping
    public String productPage(@RequestParam(defaultValue = "1") int page, Model model) {

        int itemsPerPage = 10;
        int totalPages = (int) Math.ceil((double) products.size() / itemsPerPage);

        int start = (page - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, products.size());

        List<Map<String, Object>> paginatedProducts = products.subList(start, end);

        model.addAttribute("title", "Products");
        model.addAttribute("content", "pages/product :: content");
        model.addAttribute("products", paginatedProducts);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "layout";
    }

    // ✅ GET: Add Product Page
    @GetMapping("/add")
    public String addProductPage(Model model) {

        model.addAttribute("title", "Add Product");
        model.addAttribute("content", "pages/add-edit-product :: content");
        model.addAttribute("categories", categories);
        model.addAttribute("isEditing", false);
        model.addAttribute("product", null);

        return "layout";
    }

    // ✅ GET: Edit Product Page
    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable Integer id, Model model) {

        Map<String, Object> product = products.stream()
                .filter(p -> p.get("id").equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("title", "Edit Product");
        model.addAttribute("content", "pages/add-edit-product :: content");
        model.addAttribute("categories", categories);
        model.addAttribute("isEditing", true);
        model.addAttribute("product", product);

        return "layout";
    }

    // ✅ POST: Save Product (Phase-1 dummy)
    @PostMapping("/save")
    public String saveProduct(@RequestParam String name,
                              @RequestParam String sku,
                              @RequestParam Integer stockQuantity,
                              @RequestParam Integer price,
                              @RequestParam Integer categoryId,
                              @RequestParam(required = false) String description,
                              @RequestParam(required = false) MultipartFile imageFile) {

        int newId = products.size() + 1;

        // ✅ Phase-1: image save not implemented (default)
        String imageUrl = "/images/default-product.png";

        products.add(createProduct(newId, name, sku, price, stockQuantity, categoryId, description, imageUrl));

        return "redirect:/product?message=Product%20successfully%20saved";
    }

    // ✅ POST: Update Product (Phase-1 dummy)
    @PostMapping("/update")
    public String updateProduct(@RequestParam Integer id,
                                @RequestParam String name,
                                @RequestParam String sku,
                                @RequestParam Integer stockQuantity,
                                @RequestParam Integer price,
                                @RequestParam Integer categoryId,
                                @RequestParam(required = false) String description,
                                @RequestParam(required = false) MultipartFile imageFile) {

        products.stream()
                .filter(p -> p.get("id").equals(id))
                .findFirst()
                .ifPresent(p -> {
                    p.put("name", name);
                    p.put("sku", sku);
                    p.put("price", price);
                    p.put("stockQuantity", stockQuantity);
                    p.put("categoryId", categoryId);
                    p.put("description", description);

                    // ✅ Phase-1: ignore image upload
                    // ✅ Phase-2: save file and update imageUrl
                });

        return "redirect:/product?message=Product%20successfully%20updated";
    }

    // ✅ POST: Delete Product
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id) {

        products.removeIf(p -> p.get("id").equals(id));

        return "redirect:/product?message=Product%20successfully%20deleted";
    }
}
