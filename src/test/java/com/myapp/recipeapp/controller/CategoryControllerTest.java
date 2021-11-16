package com.myapp.recipeapp.controller;

import com.myapp.recipeapp.model.Category;
import com.myapp.recipeapp.service.CategoryService;
import com.myapp.recipeapp.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryControllerTest {
    @Mock
    CategoryService categoryService;

    CategoryController categoryController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryController=new CategoryController(categoryService);
    }
    @Test
    public void mockMvcTest() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(categoryController).build();
        for(int i=0;i<1000000;i++){
            mockMvc.perform(get("/categories"))
                    .andExpect(status().isOk());
        }

    }

    @Test
    public void getAll() {
        //given
        Category category=new Category();
        Category category1=new Category();
        List<Category> categoryList=List.of(category,category1);

        //when
        org.mockito.Mockito.when(categoryService.findAll()).thenReturn(categoryList);

        //then
        List<Category> categories=categoryService.findAll();
        assertEquals(2,categories.size());
        verify(categoryService,times(1)).findAll();
    }
}