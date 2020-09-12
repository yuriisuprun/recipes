package com.recipes.controller;

import com.recipes.model.Recipe;
import com.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Yurii_Suprun
 */
@RestController
@RequestMapping(RecipeController.V1_RECIPE_URI)
@CrossOrigin
public class RecipeController {

    private final RecipeService recipeService;

    public static final String V1_RECIPE_URI = "/v1/recipe/";

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "{recipeId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Recipe> getRecipeById(@PathVariable String recipeId) {

        return recipeService.getRecipe(recipeId);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<Recipe> getRecipes() {

        return recipeService.listAllRecipes();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Recipe> createRecipe(@RequestBody Mono<Recipe> recipe) {

        return recipeService.createRecipe(recipe);
    }

    @PutMapping(path = "recipeId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Recipe> updateDescription(@PathVariable String recipeId, @RequestBody Mono<Recipe> recipe) {

        return recipeService.updateRecipe(recipeId, recipe);
    }

    @DeleteMapping(path = "{recipeId}")
    public Mono<Boolean> deleteRecipe(@PathVariable String recipeId) {

        return recipeService.deleteRecipe(recipeId);
    }
}
