package com.Loddo.InventoryMgtSystem.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class UserDto {
    public enum Role { SUPPLIER, SELLER }
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address; // Required for supplier/seller logistics
    private Role role;
    private LocalDateTime createdAt;

    public UserDto() {}

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
