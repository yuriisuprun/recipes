package com.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "recipes")
public class Recipe {

    @Id
    private String recipeId;

    @NotBlank(message = "Recipe name is required")
    private String recipeName;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate addedDate;

    public Recipe(String recipeName, String description, LocalDate addedDate) {
        this.recipeName = recipeName;
        this.description = description;
        this.addedDate = addedDate;
    }
}
