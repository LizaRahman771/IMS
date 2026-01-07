package com.Loddo.InventoryMgtSystem.service;

import com.Loddo.InventoryMgtSystem.model.Transaction;
import com.Loddo.InventoryMgtSystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PredictionService {
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * AI Logic: Predicts sales for the next 30 days based on moving averages.
     */
    public Integer predictNextMonthSales(String productId) {
        List<Transaction> sales = transactionRepository.findByProductIdAndTransactionTypeOrderByCreatedAtAsc(productId, "SELL");

        if (sales.isEmpty()) return 0;

        // Calculate average daily sales over the available history
        double totalQuantity = sales.stream().mapToInt(Transaction::getTotalProducts).sum();
        long daysInRange = ChronoUnit.DAYS.between(sales.get(0).getCreatedAt(), LocalDateTime.now()) + 1;

        double dailyAverage = totalQuantity / daysInRange;

        // Forecast: (Average Daily Sales * 30 days) + 15% growth factor
        return (int) Math.round(dailyAverage * 30 * 1.15);
    }
}
