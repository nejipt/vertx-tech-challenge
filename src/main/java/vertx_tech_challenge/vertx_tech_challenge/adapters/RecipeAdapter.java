package vertx_tech_challenge.vertx_tech_challenge.adapters;

import io.vertx.core.json.JsonObject;

public interface RecipeAdapter {
    String getRecipes();

    String getRecipe(String recipeId);

    String createRecipe(JsonObject body);
}
