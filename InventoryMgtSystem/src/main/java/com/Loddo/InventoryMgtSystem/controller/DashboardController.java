package com.Loddo.InventoryMgtSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("title", "Dashboard");
        model.addAttribute("content", "pages/dashboard :: content");

        // ✅ Phase-1 dummy data (day wise transaction)
        List<Map<String, Object>> transactionData = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            Map<String, Object> row = new HashMap<>();
            row.put("day", i);
            row.put("count", new Random().nextInt(6));
            row.put("quantity", new Random().nextInt(50));
            row.put("amount", new Random().nextInt(5000));
            transactionData.add(row);
        }

        model.addAttribute("transactionData", transactionData);

        return "layout";
    }
}
