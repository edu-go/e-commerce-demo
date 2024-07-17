package com.edugo.ecommercedemo.mapper;

import com.edugo.ecommercedemo.domain.Category;
import com.edugo.ecommercedemo.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {

    public Category toCategory(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.id(), categoryDTO.code(), categoryDTO.name(), categoryDTO.description());
    }

    public List<Category> toCategory(List<CategoryDTO> categoryDTOs) {
        return categoryDTOs.stream()
                .map(this::toCategory)
                .toList();
    }

    public CategoryDTO fromCategory(Category category) {
        return new CategoryDTO(category.getId(), category.getCode(), category.getName(), category.getDescription());
    }

    public List<CategoryDTO> fromCategory(List<Category> categories) {
        return categories.stream()
                .map(this::fromCategory)
                .toList();
    }
}
