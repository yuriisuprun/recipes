package com.recipes.service;

import com.recipes.model.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final ReactiveMongoOperations reactiveMongoOperations;

    @Override
    public Mono<Recipe> getRecipe(String recipeId) {
        return reactiveMongoOperations.findById(recipeId, Recipe.class);
    }

    @Override
    public Mono<Recipe> createRecipe(Mono<Recipe> recipeMono) {
        return reactiveMongoOperations.save(recipeMono);
    }

    @Override
    public Mono<Recipe> updateRecipe(String recipeId, Mono<Recipe> recipeMono) {
        return recipeMono.flatMap(recipe ->
            reactiveMongoOperations.findById(recipeId, Recipe.class)
                .flatMap(existingRecipe -> {
                    existingRecipe.setRecipeName(recipe.getRecipeName());
                    existingRecipe.setDescription(recipe.getDescription());
                    existingRecipe.setAddedDate(recipe.getAddedDate());
                    return reactiveMongoOperations.save(existingRecipe);
                })
        );
    }

    @Override
    public Mono<Boolean> deleteRecipe(String recipeId) {
        return reactiveMongoOperations.remove(
                Query.query(Criteria.where("recipeId").is(recipeId)), Recipe.class)
                .map(deleteResult -> deleteResult.wasAcknowledged());
    }

    @Override
    public Flux<Recipe> listAllRecipes() {
        return reactiveMongoOperations.findAll(Recipe.class);
    }
}
