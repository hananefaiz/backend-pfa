package com.arrgano;

import com.arrgano.model.User;
import com.arrgano.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArrganoApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    public ArrganoApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ArrganoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (!userRepository.existsByEmail("admin@example.com")) {
            User admin = new User();
            admin.setEmail("admin@example.com");
            admin.setPassword("admin123"); // À hasher en production !
            admin.setRole("ADMIN");
            userRepository.save(admin);
        }
    }
}
