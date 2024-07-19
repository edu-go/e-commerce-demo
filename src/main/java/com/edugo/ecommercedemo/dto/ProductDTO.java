package com.edugo.ecommercedemo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         @NotEmpty(message = "name can't be null or empty") String name,
                         @NotNull(message = "price can't be null") BigDecimal price,
                         @NotNull(message = "stock can't be null")Integer stock,
                         CategoryDTO category) {
}
