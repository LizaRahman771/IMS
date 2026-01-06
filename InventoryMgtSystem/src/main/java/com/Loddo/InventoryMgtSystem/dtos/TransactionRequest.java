package com.Loddo.InventoryMgtSystem.dtos;

import jakarta.validation.constraints.Positive;

public class TransactionRequest {
    @Positive(message = "Product ID is required")
    private String productId;
    @Positive(message = "Quantity is required")
    private Integer quantity;
    private String supplierId;
    private String description;
    private String note;

    public TransactionRequest() {}

    public TransactionRequest(String productId, Integer quantity, String supplierId, String description, String note) {
        this.productId = productId;
        this.quantity = quantity;
        this.supplierId = supplierId;
        this.description = description;
        this.note = note;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
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
}
