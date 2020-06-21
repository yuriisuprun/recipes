package com.recipes.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


        return Mono.just("{}");
    }
}