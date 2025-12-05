package com.arrgano.controller;

import com.arrgano.dto.PrimaryProcessingForm;
import com.arrgano.model.*;
import com.arrgano.service.*;
import com.arrgano.repository.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/processing")
public class ProcessingController {
    private final ProcessingService processingService;
    private final UserRepository userRepository;

    public ProcessingController(ProcessingService processingService,
                                UserRepository userRepository) {
        this.processingService = processingService;
        this.userRepository = userRepository;
    }

    @GetMapping("/primary/{batchId}")
    public String primaryProcessingForm(@PathVariable String batchId, Model model) {
        model.addAttribute("batchId", batchId);
        model.addAttribute("fruitStock", processingService.getCurrentFruitStock());
        model.addAttribute("almondStock", processingService.getCurrentAlmondStock());
        model.addAttribute("operators", userRepository.findByRole("OPERATOR"));
        model.addAttribute("form", new PrimaryProcessingForm());
        return "processing/primary-form";
    }

    @PostMapping("/primary/{batchId}")
    public String submitPrimaryProcessing(@PathVariable String batchId,
                                          @ModelAttribute PrimaryProcessingForm form,
                                          @AuthenticationPrincipal User user) {
        processingService.startPrimaryProcessing(batchId, user.getId());
        processingService.updatePrimaryProcessing(batchId, form);
        return "redirect:/processing/primary/" + batchId + "/results";
    }

    @GetMapping("/secondary/{batchId}")
    public String secondaryProcessingForm(@PathVariable String batchId, Model model) {
        PrimaryProcessing primary = processingService.getPrimaryProcessing(batchId);
        model.addAttribute("primary", primary);
        model.addAttribute("almondStock", processingService.getCurrentAlmondStock());
        model.addAttribute("machines", processingService.getAvailableMachines());
        model.addAttribute("operators", userRepository.findByRole("OPERATOR"));
        return "processing/secondary-form";
    }
}