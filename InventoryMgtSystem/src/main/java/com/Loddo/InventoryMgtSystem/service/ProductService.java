package com.Loddo.InventoryMgtSystem.service;

import com.Loddo.InventoryMgtSystem.dtos.ProductDto;
import com.Loddo.InventoryMgtSystem.interfaces.ProductServiceInterface;
import com.Loddo.InventoryMgtSystem.model.Product;
import com.Loddo.InventoryMgtSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto saveProduct(ProductDto dto, MultipartFile imageFile) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setBrand(dto.getBrand()); // New ML feature [cite: 651]
        product.setPrice(dto.getUnitPrice());
        product.setCategoryId(dto.getCategory());
        product.setSupplierId(dto.getSupplierId()); // Link to Supplier User [cite: 654]
        product.setStockQuantity(dto.getStockQuantity());
        product.setSku(dto.getSku());

        // Handle image saving logic...

        productRepository.save(product);
        return dto;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, MultipartFile imageFile) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return null;
    }

    @Override
    public ProductDto getProductById(String id) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {

    }

    @Override
    public List<ProductDto> searchProduct(String input) {
        return null;
    }


}
