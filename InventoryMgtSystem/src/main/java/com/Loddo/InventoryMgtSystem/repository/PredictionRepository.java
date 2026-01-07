package com.Loddo.InventoryMgtSystem.repository;

import com.Loddo.InventoryMgtSystem.model.Prediction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PredictionRepository extends MongoRepository<Prediction, String> {
    Optional<Prediction> findFirstByProductIdOrderByPredictionDateDesc(String productId);
}
