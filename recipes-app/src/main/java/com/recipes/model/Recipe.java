package com.recipes.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Created by Yurii_Suprun
 */
@Data
@NoArgsConstructor
@Document
public class Recipe {

    @Id
    private String recipeId;
    private String recipeName;
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate addedDate;

    public Recipe(String recipeName, String description, LocalDate addedDate) {
        this.recipeName = recipeName;
        this.description = description;
        this.addedDate = addedDate;
    }
}
