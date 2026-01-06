package com.Loddo.InventoryMgtSystem.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    @Id
    private String id;
    private String productId;
    private String userId;
    private String supplierId; // Null for sales
    private String transactionType; // "PURCHASE", "SELL", or "RETURN"
    private String status; // "PENDING", "COMPLETED"
    private Integer totalProducts;
    private BigDecimal totalPrice;
    private String description;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Transaction() {
    }

    public Transaction(String productId, String userId, String type, Integer qty, BigDecimal price) {
        this.productId = productId;
        this.userId = userId;
        this.transactionType = type;
        this.totalProducts = qty;
        this.totalPrice = price;
        this.createdAt = LocalDateTime.now();
        this.status = "COMPLETED";
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getSupplierId() { return supplierId; }
    public void setSupplierId(String supplierId) { this.supplierId = supplierId; }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String type) { this.transactionType = type; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getTotalProducts() { return totalProducts; }
    public void setTotalProducts(Integer totalProducts) { this.totalProducts = totalProducts; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
