package vertx_tech_challenge.vertx_tech_challenge.services;

import io.vertx.core.json.JsonObject;

import vertx_tech_challenge.vertx_tech_challenge.adapters.RecipeAdapter;

public class RecipeService {

    RecipeAdapter adapter;

    public RecipeService (RecipeAdapter adapter) {
        this.adapter = adapter;
    }

    public String getRecipes () {
        return adapter.getRecipes();
    }

    public String getRecipe(String recipeId) {
        return adapter.getRecipe(recipeId);
    }

    public String createRecipe(JsonObject body) {
        return adapter.createRecipe(body);
    }
}
