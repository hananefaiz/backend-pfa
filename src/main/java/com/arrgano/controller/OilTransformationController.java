package com.arrgano.controller;

import com.arrgano.dto.OilTransformationDTO;
import com.arrgano.dto.TransformationDashboardResponse;
import com.arrgano.service.OilTransformationService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transformation")
public class OilTransformationController {
    private final OilTransformationService transformationService;

    public OilTransformationController(OilTransformationService transformationService) {
        this.transformationService = transformationService;
    }

    @PostMapping
    @Secured({"ROLE_ADMIN", "ROLE_OPERATOR"})
    public void recordTransformation(@RequestBody OilTransformationDTO dto) {
        transformationService.recordTransformation(dto);
    }

    @GetMapping("/dashboard")
    @Secured({"ROLE_ADMIN", "ROLE_OPERATOR", "ROLE_ANALYST"})
    public TransformationDashboardResponse getTransformationDashboard() {
        return transformationService.getDashboardData();
    }
}
