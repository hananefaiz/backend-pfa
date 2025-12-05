package com.arrgano.service;

import com.arrgano.model.User;
import com.arrgano.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllActiveUsers() {
        return userRepository.findByActiveTrue();
    }
    public void updateLastLogin(String email) {
        userRepository.findByEmail(email).ifPresent(user -> {
            user.setLastLogin(new Date());
            userRepository.save(user);
        });
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
    public User createUser(String email, String password, String role) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email déjà utilisé");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // À hasher en production !
        user.setRole(role);
        user.setLastLogin(new Date());
        user.setActive(true);
        return userRepository.save(user);
    }
    public User createUser(User user) {
        // Validation
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email est obligatoire");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }

        // Valeurs par défaut
        if (user.getLastLogin() == null) {
            user.setLastLogin(new Date());
        }
        if (!user.isActive()) {  // Si active est false (valeur par défaut)
            user.setActive(true);
        }

        return userRepository.save(user);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }
    public User updateUser(String id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setFullName(userDetails.getFullName());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setRole(userDetails.getRole());
        user.setDepartment(userDetails.getDepartment());
        return userRepository.save(user);
    }
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }
}
