package com.Loddo.InventoryMgtSystem.repository;

import com.Loddo.InventoryMgtSystem.model.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier, String> {
}
