package com.myapp.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @JsonBackReference
    @ManyToMany(mappedBy = "categories")
    private List<Recipe> recipes=new ArrayList<>();

    public Category() {
    }

    public Category( String description, List<Recipe> recipes) {
        this.description = description;
        this.recipes = recipes;
    }

    public Category(Long id, String description, List<Recipe> recipes) {
        this.id = id;
        this.description = description;
        this.recipes = recipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
