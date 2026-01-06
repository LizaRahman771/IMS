package com.Loddo.InventoryMgtSystem.interfaces;

import com.Loddo.InventoryMgtSystem.dtos.SupplierDto;

import java.util.List;

public interface SupplierServiceInterface {
    SupplierDto addSupplier(SupplierDto supplierDto);
    SupplierDto updateSupplier(String id, SupplierDto supplierDto);
    List<SupplierDto> getAllSupplier();
    SupplierDto getSupplierById(String id);
    void deleteSupplier(String id);
}
