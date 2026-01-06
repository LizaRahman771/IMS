package com.Loddo.InventoryMgtSystem.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Prediction {
    @Id
    private String id;
    private String productId;
    private Integer predictedQuantity;
    private Double confidenceScore;
    private LocalDate predictionDate;

    public Prediction() {
    }

    public Prediction(String productId, Integer predictedQuantity, Double confidenceScore) {
        this.productId = productId;
        this.predictedQuantity = predictedQuantity;
        this.confidenceScore = confidenceScore;
        this.predictionDate = LocalDate.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public Integer getPredictedQuantity() { return predictedQuantity; }
    public void setPredictedQuantity(Integer predictedQuantity) { this.predictedQuantity = predictedQuantity; }
    public Double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(Double confidenceScore) { this.confidenceScore = confidenceScore; }
    public LocalDate getPredictionDate() { return predictionDate; }
    public void setPredictionDate(LocalDate predictionDate) { this.predictionDate = predictionDate; }
}
