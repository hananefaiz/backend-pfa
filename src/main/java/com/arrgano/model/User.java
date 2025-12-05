package com.arrgano.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Document(collection = "users")
public class User implements UserDetails {
    @Id
    private String id;
    private String email;
    private String password;
    private String fullName;
    private String phone;
    private boolean enabled = true;
    private String resetToken;
    private String role;
    private String department;
    private Date lastLogin;
    private boolean active;
    private Map<String, Object> dynamicFields;

    // Constructeurs
    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Méthodes obligatoires de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email; // Dans notre cas, l'email est le username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Le compte n'est jamais expiré
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Le compte n'est jamais verrouillé
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Les identifiants n'expirent jamais
    }

    @Override
    public boolean isEnabled() {
        return enabled; // Utilise le champ enabled
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public Map<String, Object> getDynamicFields() { return dynamicFields; }
    public void setDynamicFields(Map<String, Object> dynamicFields) { this.dynamicFields = dynamicFields; }
    public boolean hasRole(String role) {
        return role != null && role.contains(role);}
}