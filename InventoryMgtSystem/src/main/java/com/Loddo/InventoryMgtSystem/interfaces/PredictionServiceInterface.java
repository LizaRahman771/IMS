package com.Loddo.InventoryMgtSystem.interfaces;

import java.util.List;
import java.util.Map;

public interface PredictionServiceInterface {
    /**
     * AI Logic: Predicts sales quantity for a specific product in the next month.
     */
    Integer predictNextMonthSales(String productId);

    /**
     * AI Logic: Provides proactive stock suggestions and alerts based on trends.
     */
    List<String> getProactiveSuggestions(String userId);

    /**
     * Formats historical transaction data for visualization in Dashboard charts.
     */
    List<Map<String, Object>> getFormattedTransactionData();
}
