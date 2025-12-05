package com.arrgano.dto;

public class AuthResponse {
    private String token;
    private String email;

    // Constructeur par défaut
    public AuthResponse() {
    }

    // Constructeur avec paramètres
    public AuthResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setToken(String token) {
        this.token = token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
