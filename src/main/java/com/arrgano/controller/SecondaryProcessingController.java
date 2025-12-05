package com.arrgano.controller;

import com.arrgano.dto.SecondaryProcessingForm;
import com.arrgano.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/secondary-processing")
public class SecondaryProcessingController {
    private final SecondaryProcessingService processingService;

    public SecondaryProcessingController(SecondaryProcessingService processingService) {
        this.processingService = processingService;
    }

    @GetMapping("/{batchId}")
    public String showForm(@PathVariable String batchId, Model model) {
        model.addAttribute("batchId", batchId);
        model.addAttribute("form", new SecondaryProcessingForm());
        model.addAttribute("crudeOilStock", processingService.getCurrentCrudeOilStock());
        model.addAttribute("filteredOilStock", processingService.getCurrentFilteredOilStock());
        model.addAttribute("machines", processingService.getAvailableFilteringMachines());
        model.addAttribute("operators", processingService.getAvailableOperators());
        return "secondary-processing/form";
    }

    @PostMapping("/{batchId}")
    public String processForm(@PathVariable String batchId,
                              @ModelAttribute SecondaryProcessingForm form) {
        processingService.startProcessing(batchId, form);
        return "redirect:/secondary-processing/" + batchId + "/results";
    }
}
