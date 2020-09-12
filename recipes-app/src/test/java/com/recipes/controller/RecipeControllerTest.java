package com.recipes.controller;

import com.recipes.model.Recipe;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static com.recipes.controller.RecipeController.V1_RECIPE_URI;

/**
 * Created by Yurii_Suprun
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecipeControllerTest extends TestCase {

    @Autowired
    private ApplicationContext applicationContext;

    private WebTestClient webTestClient;

    private Recipe recipe;

    @Before
    public void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(this.applicationContext)
                .build();

        recipe = new Recipe("Osso Buco", "Veal shanks braised with vegetables", LocalDate.now());
    }

    @Test
    public void testGetRecipes() {
        webTestClient.get()
                .uri(V1_RECIPE_URI)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Recipe.class);
    }

    @Test
    public void testCreateRecipe() {
        webTestClient.post()
                .uri(V1_RECIPE_URI)
                .body(Mono.just(recipe), Recipe.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(Recipe.class);
    }
}