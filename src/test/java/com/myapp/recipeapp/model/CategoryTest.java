package com.myapp.recipeapp.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;
    @Before
    public void setUp() throws Exception {
        category=new Category();
    }

    @Test
    public void getId() {
        Long idValue=4L;

        category.setId(4L);

        assertEquals(idValue,category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}