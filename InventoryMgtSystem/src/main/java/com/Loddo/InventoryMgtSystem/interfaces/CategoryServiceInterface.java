package com.Loddo.InventoryMgtSystem.interfaces;

import com.Loddo.InventoryMgtSystem.dtos.CategoryDto;

import java.util.List;

public interface CategoryServiceInterface {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(String id);
    CategoryDto updateCategory(String id, CategoryDto categoryDto);
    void deleteCategory(String id);
}
