package com.arrgano.controller;

import com.arrgano.model.Machine;
import com.arrgano.service.MachineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/machines")
public class MachineController {
    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping
    public String machineDashboard(Model model) {
        model.addAttribute("machines", machineService.getAllMachines());
        return "admin/machine-dashboard";
    }

    @PostMapping("/add")
    public String addMachine(@RequestParam String name,
                             @RequestParam String type,
                             @RequestParam String status,
                             @RequestParam double performance) {
        machineService.addMachine(name, type, status, performance);
        return "redirect:/admin/machines";
    }
}
