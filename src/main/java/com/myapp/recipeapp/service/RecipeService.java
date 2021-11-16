package com.myapp.recipeapp.service;

import com.myapp.recipeapp.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    Recipe findById(Long id);
}
