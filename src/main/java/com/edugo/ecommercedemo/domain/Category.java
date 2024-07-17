package com.edugo.ecommercedemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Category {

    @Id
    private Long id;
    private String code;
    private String name;
    private String description;

    public Category() {}

    public Category(Long id, String code, String name, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id)
                && Objects.equals(code, category.code)
                && Objects.equals(name, category.name)
                && Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, description);
    }
}
