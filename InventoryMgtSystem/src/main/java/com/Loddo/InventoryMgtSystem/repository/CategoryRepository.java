package com.Loddo.InventoryMgtSystem.repository;

import com.Loddo.InventoryMgtSystem.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findByName(String name);
    Optional<Category> findById(String id);
}
