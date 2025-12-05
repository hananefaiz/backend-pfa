package com.arrgano.controller;

import com.arrgano.model.StockMovement;
import com.arrgano.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public String stockDashboard(Model model) {
        model.addAttribute("movements", stockService.getAllMovements());
        return "admin/stock-dashboard";
    }

    @PostMapping("/add-movement")
    public String addMovement(@RequestParam String productName,
                              @RequestParam double quantity,
                              @RequestParam String movementType,
                              @RequestParam String notes) {
        stockService.recordMovement(productName, quantity, movementType, notes);
        return "redirect:/admin/stocks";
    }
}
