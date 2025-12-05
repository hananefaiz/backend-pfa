package com.arrgano.controller;


import com.arrgano.service.DynamicConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/config")
public class SystemConfigController {
    private final DynamicConfigService configService;

    public SystemConfigController(DynamicConfigService configService) {
        this.configService = configService;
    }

    @GetMapping
    public String configPage(Model model) {
        model.addAttribute("config", configService.getConfig());
        return "admin/system-config";
    }

    @PostMapping("/update")
    public String updateConfig(@RequestParam String key,
                               @RequestParam String value) {
        Object convertedValue = convertValue(key, value);
        configService.updateConfig(key, convertedValue);
        return "redirect:/admin/config";
    }

    private Object convertValue(String key, String value) {
        if (key.contains("Threshold")) return Double.parseDouble(value);
        if (key.equals("notifications")) return Boolean.parseBoolean(value);
        return value;
    }
}
