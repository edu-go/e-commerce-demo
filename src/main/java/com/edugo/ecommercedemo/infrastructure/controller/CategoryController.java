package com.edugo.ecommercedemo.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping("/category")
    public String getCategories() {
        return "Categories";
    }
}
