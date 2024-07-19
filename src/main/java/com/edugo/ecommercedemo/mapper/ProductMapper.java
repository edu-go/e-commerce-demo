package com.edugo.ecommercedemo.mapper;

import com.edugo.ecommercedemo.domain.Product;
import com.edugo.ecommercedemo.dto.CategoryDTO;
import com.edugo.ecommercedemo.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductMapper {

    private final CategoryMapper categoryMapper;

    public ProductMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.name(),
                productDTO.price(),
                productDTO.stock(),
                Optional.ofNullable(productDTO.category()).map(categoryMapper::toCategory).orElse(null));
    }

    public ProductDTO fromProduct(Product product) {
        CategoryDTO categoryDTO = Optional.ofNullable(product.getCategory())
                .map(categoryMapper::fromCategory)
                .orElse(null);
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getStock(), categoryDTO);
    }
}
