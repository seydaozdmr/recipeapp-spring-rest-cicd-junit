package com.myapp.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @JsonBackReference
    @OneToOne
    private Ingredient ingredient;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(String unitOfMeasure, Ingredient ingredient) {

        this.description = unitOfMeasure;
        this.ingredient = ingredient;
    }

    public UnitOfMeasure(String description) {
        this.description = description;
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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
