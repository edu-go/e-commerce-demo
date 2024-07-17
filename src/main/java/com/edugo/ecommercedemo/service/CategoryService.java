package com.edugo.ecommercedemo.service;

import com.edugo.ecommercedemo.domain.Category;
import com.edugo.ecommercedemo.dto.CategoryDTO;
import com.edugo.ecommercedemo.mapper.CategoryMapper;
import com.edugo.ecommercedemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final RestClient restClient;

    @Autowired
    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository, RestClient restClient) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
        this.restClient = restClient;
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.fromCategory(categories);
    }

    public List<CategoryDTO> getCategoriesFromExternal() {
        List<CategoryDTO> categories = restClient.get()
                .uri("https://api.develop.bricks.com.ar/loyalty/category/producer")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return categories;
    }

    public void updateCategories(List<CategoryDTO> categoryDTOs) {
        List<Category> categories = categoryMapper.toCategory(categoryDTOs);
        categoryRepository.saveAll(categories);
    }
}
