package com.arrgano.controller;

import com.arrgano.model.Batch;
import com.arrgano.model.User;
import com.arrgano.service.OperatorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operator")
@PreAuthorize("hasRole('OPERATOR') or hasRole('ADMIN')")
public class OperatorController {
    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("/dashboard")
    public String operatorDashboard(Model model) {
        User operator = operatorService.getCurrentOperator();
        model.addAttribute("operator", operator);
        model.addAttribute("currentBatches", operatorService.getCurrentBatches(operator.getId()));
        model.addAttribute("completedBatches", operatorService.getCompletedBatches(operator.getId()));
        return "operator/dashboard";
    }

    @PostMapping("/create-batch")
    public String createBatch(@RequestParam String batchId) {
        User operator = operatorService.getCurrentOperator();
        operatorService.createNewBatch(batchId, operator.getId());
        return "redirect:/operator/dashboard";
    }
}
