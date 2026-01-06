package com.Loddo.InventoryMgtSystem.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDto {
    private String id;
    private String name;
    private String sku;
    private BigDecimal price;
    private Integer stockQuantity;
    private String categoryId;
    private String description;
    private String imageUrl;
    private LocalDateTime createdAt;

    public ProductDto() {
    }

    public ProductDto(String id, String name, String sku, BigDecimal price, Integer stockQuantity, String categoryId, String description, String imageUrl, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.categoryId = categoryId;
        this.description = description;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
