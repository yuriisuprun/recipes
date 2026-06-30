package com.recipes.controller;

import com.recipes.model.Recipe;
import com.recipes.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/v1/recipes")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping(path = "/{recipeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Recipe>> getRecipeById(@PathVariable String recipeId) {
        return recipeService.getRecipe(recipeId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Recipe> getRecipes() {
        return recipeService.listAllRecipes();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Recipe>> createRecipe(@Valid @RequestBody Mono<Recipe> recipe) {
        return recipeService.createRecipe(recipe)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().build()));
    }

    @PutMapping(path = "/{recipeId}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Recipe>> updateRecipe(@PathVariable String recipeId, @Valid @RequestBody Mono<Recipe> recipe) {
        return recipeService.updateRecipe(recipeId, recipe)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().build()));
    }

    @DeleteMapping(path = "/{recipeId}")
    public Mono<ResponseEntity<Void>> deleteRecipe(@PathVariable String recipeId) {
        return recipeService.deleteRecipe(recipeId)
                .flatMap(deleted -> deleted ? 
                    Mono.just(ResponseEntity.noContent().<Void>build()) :
                    Mono.just(ResponseEntity.notFound().build()));
    }
}
