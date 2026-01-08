package com.Loddo.InventoryMgtSystem.repository;

import com.Loddo.InventoryMgtSystem.model.Prediction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PredictionRepository extends MongoRepository<Prediction, String> {
    Prediction findFirstByProductIdOrderByPredictionDateDesc(String productId);
    List<Prediction> findByOwnerIdAndProductIdOrderByPredictionDateAsc(String ownerId, String productId);
}
