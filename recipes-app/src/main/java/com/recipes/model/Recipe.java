package com.recipes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Yurii_Suprun
 */
@Document
public class Recipe {

    @Id
    private String recipeId;
    private String recipeName;
    private String description;
    private List<String> ingredients;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate addedDate;

    public Recipe() {
    }

    public Recipe(String recipeName, String description, List<String> ingredients, LocalDate addedDate) {
        this.recipeName = recipeName;
        this.description = description;
        this.ingredients = ingredients;
        this.addedDate = addedDate;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
}
