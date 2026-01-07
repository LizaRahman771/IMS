package com.Loddo.InventoryMgtSystem.service;

import com.Loddo.InventoryMgtSystem.dtos.TransactionRequest;
import com.Loddo.InventoryMgtSystem.model.Product;
import com.Loddo.InventoryMgtSystem.model.Transaction;
import com.Loddo.InventoryMgtSystem.repository.ProductRepository;
import com.Loddo.InventoryMgtSystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class InventoryService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void processTransaction(TransactionRequest req, String type, String userId) {
        Product product = productRepository.findById(req.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (type.equals("SELL")) {
            if (product.getStockQuantity() < req.getQuantity()) {
                throw new RuntimeException("Insufficient stock available");
            }
            product.setStockQuantity(product.getStockQuantity() - req.getQuantity());
        } else if (type.equals("PURCHASE")) {
            product.setStockQuantity(product.getStockQuantity() + req.getQuantity());
        }

        productRepository.save(product);

        Transaction transaction = new Transaction();
        transaction.setProductId(req.getProductId());
        transaction.setUserId(userId);
        transaction.setSupplierId(req.getSupplierId());
        transaction.setTransactionType(type);
        transaction.setTotalProducts(req.getQuantity());
        transaction.setTotalPrice(product.getPrice().multiply(new BigDecimal(req.getQuantity())));
        transaction.setDescription(req.getDescription());
        transaction.setNote(req.getNote());
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setStatus("COMPLETED");

        transactionRepository.save(transaction);
    }
}
