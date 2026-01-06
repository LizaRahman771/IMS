package com.Loddo.InventoryMgtSystem.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private String id;
    private Integer totalProducts;
    private BigDecimal totalPrice;
    private String transactionType;
    private String status;
    private String description;
    private String note;
    private LocalDateTime createdAt;
    private ProductDto product;
    private UserDto user;
    private SupplierDto supplier;

    public TransactionDto() {
    }

    public TransactionDto(String id, Integer totalProducts, BigDecimal totalPrice, String transactionType, String status, String description, String note, LocalDateTime createdAt, ProductDto product, UserDto user, SupplierDto supplier) {
        this.id = id;
        this.totalProducts = totalProducts;
        this.totalPrice = totalPrice;
        this.transactionType = transactionType;
        this.status = status;
        this.description = description;
        this.note = note;
        this.createdAt = createdAt;
        this.product = product;
        this.user = user;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }
}
