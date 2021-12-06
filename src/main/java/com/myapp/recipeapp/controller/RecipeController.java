package com.myapp.recipeapp.controller;

import com.myapp.recipeapp.model.Recipe;
import com.myapp.recipeapp.repository.RecipeRepository;
import com.myapp.recipeapp.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipies")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController( RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Recipe>> getAll(){
        return ResponseEntity.ok(recipeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> findRecipe(@PathVariable Long id){
        return ResponseEntity.ok(recipeService.findById(id));
    }
}
