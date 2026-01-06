package com.Loddo.InventoryMgtSystem.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String role; // "ADMIN" or "STAFF"
    private LocalDateTime createdAt;

    public User() {
    }

    public User(String name, String email, String password, String phoneNumber, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.createdAt = LocalDateTime.now();
    }

    public User(String id, String name, String email, String password, String phoneNumber, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

