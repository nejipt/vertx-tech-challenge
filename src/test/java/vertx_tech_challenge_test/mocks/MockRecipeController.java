package vertx_tech_challenge_test.mocks;

import io.vertx.core.json.JsonObject;

import vertx_tech_challenge.vertx_tech_challenge.controllers.RecipeController;

public class MockRecipeController extends RecipeController {
    private int calledGetRecipes = 0;
    private int calledGetRecipe = 0;
    private int calledCreateRecipe = 0;

    public MockRecipeController(MockRecipeService recipeService) {
        super(recipeService);
    }

    @Override
    public String getRecipes() {
        calledGetRecipes++;
        return null;
    }

    @Override
    public String getRecipe(String recipeId) {
        calledGetRecipe++;
        return null;
    }

    @Override
    public String createRecipe(JsonObject body) {
        calledCreateRecipe++;
        return null;
    }

    public int getNumberOfTimesGetRecipesWasCalled() {
        return calledGetRecipes;
    }

    public int getNumberOfTimesGetRecipeWasCalled() {
        return calledGetRecipe;
    }

    public int getNumberOfTimesCreateRecipeWasCalled() {
        return calledCreateRecipe;
    }
}
