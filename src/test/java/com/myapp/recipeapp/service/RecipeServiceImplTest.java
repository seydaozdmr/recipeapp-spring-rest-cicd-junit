package com.myapp.recipeapp.service;

import com.myapp.recipeapp.model.Recipe;
import com.myapp.recipeapp.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository repository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        recipeService=new RecipeServiceImpl(repository);
    }

    @Test
    public void getAll() {
        Recipe recipe=new Recipe();
        List<Recipe> recipes=new ArrayList<>();
        recipes.add(recipe);
        org.mockito.Mockito.when(repository.findAll()).thenReturn(recipes);
        List<Recipe> recipeList=recipeService.getAll();
        assertEquals(recipeList.size(),1);
        verify(repository,times(1)).findAll();
    }

    @Test
    public void findById(){
        Recipe recipe=new Recipe();
        recipe.setId(1L);

        when(repository.findById(anyLong())).thenReturn(Optional.of(recipe));

        Recipe getRecipe= recipeService.findById(1L);

        assertNotNull(getRecipe);
    }
}