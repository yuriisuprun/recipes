package com.recipes.service;

import com.recipes.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Yurii_Suprun
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private final ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    public RecipeServiceImpl(ReactiveMongoOperations reactiveMongoOperations) {
        this.reactiveMongoOperations = reactiveMongoOperations;
    }

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
        return recipeMono.flatMap(recipe -> reactiveMongoOperations.findAndModify(
                Query.query(Criteria.where("id").is(recipeId)),
                Update.update("recipeName", recipe.getRecipeName()), Recipe.class
                ).flatMap(result -> {
                    result.setRecipeName(recipe.getRecipeName());
                    return Mono.just(result);
                })
        );
    }

    @Override
    public Mono<Boolean> deleteRecipe(String recipeId) {
        return reactiveMongoOperations.remove(
                Query.query(Criteria.where("recipeId").is(recipeId)), Recipe.class)
                .flatMap(deleteResult -> Mono.just(deleteResult.wasAcknowledged()));
    }

    @Override
    public Flux<Recipe> listAllRecipes() {
        return reactiveMongoOperations.findAll(Recipe.class);
    }
}
