package com.arrgano.dto;

public class RegisterRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String role;

    // Constructeurs
    public RegisterRequest() {}

    public RegisterRequest(String email, String password, String confirmPassword, String role) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    // Getters & Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "email='" + email + '\'' +
                ", password='[PROTECTED]'" +
                ", confirmPassword='[PROTECTED]'" +
                ", role='" + role + '\'' +
                '}';
    }
}
