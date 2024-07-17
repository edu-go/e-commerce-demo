package com.edugo.ecommercedemo.controller;

import com.edugo.ecommercedemo.dto.CategoryDTO;
import com.edugo.ecommercedemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/trigger-category")
    public ResponseEntity<?> getCategoriesTrigger() {
        List<CategoryDTO> categoryDTOs = categoryService.getCategoriesFromExternal();
        categoryService.updateCategories(categoryDTOs);
        return ResponseEntity.ok(categoryDTOs);
    }
}
