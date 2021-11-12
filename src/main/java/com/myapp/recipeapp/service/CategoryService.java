package com.myapp.recipeapp.service;

import com.myapp.recipeapp.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findCategoryById(Long id);
}
