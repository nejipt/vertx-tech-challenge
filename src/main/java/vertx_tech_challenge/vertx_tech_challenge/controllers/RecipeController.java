package vertx_tech_challenge.vertx_tech_challenge.controllers;

import io.vertx.core.json.JsonObject;

import vertx_tech_challenge.vertx_tech_challenge.services.RecipeService;

public class RecipeController {
    RecipeService recipeService;

    public RecipeController (RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public String getRecipes() {
        return recipeService.getRecipes();
    }

    public String getRecipe(String recipeId) {
        return recipeService.getRecipe(recipeId);
    }

    public String createRecipe(JsonObject body) {
        return recipeService.createRecipe(body);
    }
}
