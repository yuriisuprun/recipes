package com.recipes.service;

import com.recipes.model.Recipe;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Yurii_Suprun
 */
public interface RecipeService {

    Mono<Recipe> getRecipe(String recipeName);

    Mono<Recipe> createRecipe(Mono<Recipe> recipeMono);

    Mono<Recipe> updateRecipe(String recipeId, Mono<Recipe> recipeMono);

    Mono<Boolean> deleteRecipe(String recipeId);

    Flux<Recipe> listAllRecipes();
}
