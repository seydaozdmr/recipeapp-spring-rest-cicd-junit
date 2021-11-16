package com.myapp.recipeapp.service;

import com.myapp.recipeapp.model.Recipe;
import com.myapp.recipeapp.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository repository;

    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Recipe> getAll() {
        List<Recipe> myList=new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(myList::add);
        return myList;
    }

    @Override
    public Recipe findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Eleman bulunamadı..."));
    }
}
