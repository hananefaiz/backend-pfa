package com.arrgano.controller;

import com.arrgano.model.User;
import com.arrgano.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userManagement(Model model) {
        model.addAttribute("users", userService.getAllActiveUsers());
        return "admin/user-management";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable String id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/edit-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable String id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add-user";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/admin/users";
    }
}
