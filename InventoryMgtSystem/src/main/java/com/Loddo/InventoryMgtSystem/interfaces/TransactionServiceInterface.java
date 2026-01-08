package com.Loddo.InventoryMgtSystem.interfaces;

import com.Loddo.InventoryMgtSystem.dtos.TransactionDto;
import com.Loddo.InventoryMgtSystem.dtos.TransactionRequest;

import java.util.List;

public interface TransactionServiceInterface {
    TransactionDto sell(TransactionRequest transactionRequest);

    TransactionDto purchase(TransactionRequest transactionRequest);

    List<TransactionDto> getAllTransactions();

    TransactionDto getTransactionById(String id);

    List<TransactionDto> getSalesHistoryForProduct(String productId);
    List<TransactionDto> getTransactionsByMonthAndYear(int month, int year);
    TransactionDto updateTransactionStatus(String transactionId, String status);
}
