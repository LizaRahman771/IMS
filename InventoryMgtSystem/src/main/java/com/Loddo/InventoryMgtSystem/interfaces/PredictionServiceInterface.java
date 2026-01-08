package com.Loddo.InventoryMgtSystem.interfaces;

import com.Loddo.InventoryMgtSystem.model.Prediction;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface PredictionServiceInterface {
    /**
     * AI Logic: Triggers a request to the Python ML service and saves a Prediction.
     * Based on Project Plan High-Level Flow[cite: 24, 28].
     */
    Prediction generatePrediction(String ownerId, String productId, LocalDate predictionDate);

    /**
     * Retrieves prediction history for a specific product to be plotted on Chart.js[cite: 498].
     */
    List<Prediction> getPredictionHistory(String ownerId, String productId);

    /**
     * Provides proactive stock suggestions and alerts based on trends.
     */
    List<String> getProactiveSuggestions(String userId);

    /**
     * Formats prediction and actual sales data for Dashboard charts[cite: 494, 495].
     */
    List<Map<String, Object>> getFormattedGraphData(String productId);
}
