package com.edugo.ecommercedemo.service;

import com.edugo.ecommercedemo.domain.Category;
import com.edugo.ecommercedemo.domain.Product;
import com.edugo.ecommercedemo.dto.CategoryDTO;
import com.edugo.ecommercedemo.dto.ProductDTO;
import com.edugo.ecommercedemo.mapper.ProductMapper;
import com.edugo.ecommercedemo.repository.CategoryRepository;
import com.edugo.ecommercedemo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(CategoryRepository categoryRepository,
                          ProductRepository productRepository,
                          ProductMapper productMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::fromProduct)
                .toList();
    }

    public ProductDTO findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::fromProduct)
                .orElseThrow(() -> new EntityNotFoundException("product with id: " + id + " not found"));
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Optional<Category> category = Optional.ofNullable(product.getCategory())
                .map(Category::getId)
                .map(categoryRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get);
        product.setCategory(category.orElse(null));
        product = productRepository.save(product);
        return productMapper.fromProduct(product);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found for id: " + id));
        Category category = Optional.ofNullable(productDTO.category())
                .map(CategoryDTO::id)
                .map(categoryRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new EntityNotFoundException("Category not found for id: " + id));
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setStock(productDTO.stock());
        product.setCategory(category);
        product = productRepository.save(product);
        return productMapper.fromProduct(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
