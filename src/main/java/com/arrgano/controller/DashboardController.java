package com.arrgano.controller;

import com.arrgano.model.User;
import com.arrgano.service.UserService;
import com.arrgano.service.DashboardService;
import com.arrgano.dto.DashboardResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;

import java.util.Date;
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/admin")
    public String adminDashboard(@AuthenticationPrincipal User user) {
        if (!"ADMIN".equals(user.getRole())) {
            throw new RuntimeException("Accès refusé");
        }
        return "Tableau de bord Admin";
    }

    @GetMapping("/operator")
    public String operatorDashboard(@AuthenticationPrincipal User user) {
        if (!"OPERATOR".equals(user.getRole()) && !"ADMIN".equals(user.getRole())) {
            throw new RuntimeException("Accès refusé");
        }
        return "Tableau de bord Opérateur";
    }

    @GetMapping("/analyst")
    public String analystDashboard(@AuthenticationPrincipal User user) {
        if (!"ANALYST".equals(user.getRole()) && !"ADMIN".equals(user.getRole())) {
            throw new RuntimeException("Accès refusé");
        }
        return "Tableau de bord Analyste";
    }
    @GetMapping
    @Secured({"ROLE_ADMIN", "ROLE_OPERATOR", "ROLE_ANALYST"})
    public DashboardResponse getDashboardData(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            @RequestParam(required = false) String lotId) {

        if (startDate == null) {
            startDate = new Date(System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000); // 30 jours par défaut
        }
        if (endDate == null) {
            endDate = new Date();
        }
        return dashboardService.getDashboardData(startDate, endDate, lotId);
    }
}
