package com.arrgano.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendPasswordResetEmail(String email, String resetToken) {
        // Implémentation réelle enverrait un email
        System.out.println("Envoi d'email à " + email + " avec token: " + resetToken);
        // URL exemple: http://votre-app/reset-password?token=" + resetToken
    }
}
