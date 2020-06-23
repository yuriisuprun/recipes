package com.recipes.controller;

import com.recipes.model.Recipe;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by Yurii_Suprun
 */
@RestController()
@RequestMapping("v1/recipe")
@CrossOrigin
public class RecipeResource {

    @GetMapping(path = "{recipeId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<String> getRecipeById(@PathVariable String recipeId){


        return Mono.just("{Recipe}");
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<String> createRecipe(@RequestBody Mono<Recipe> recipe){


        return Mono.just("{Recipe}");
    }

    @PutMapping(path = "recipeId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
             consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<String> updateDescription(@PathVariable String recipeId, @RequestBody Mono<Recipe> recipe){


        return Mono.just("{Recipe}");
    }
}
