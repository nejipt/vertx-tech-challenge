package vertx_tech_challenge_test.unit.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import vertx_tech_challenge.vertx_tech_challenge.services.RecipeService;
import vertx_tech_challenge_test.mocks.MockRecipeAdapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRecipeService {
    private static RecipeService recipeService = null;
    private static MockRecipeAdapter recipeAdapter = null;

    @BeforeAll
    static void create_service() {
        recipeAdapter = new MockRecipeAdapter();
        recipeService = new RecipeService(recipeAdapter);
    }

    @Test
    void getRecipes () {
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipesWasCalled(), 0);
        recipeService.getRecipes();
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipesWasCalled(), 1);
        recipeService.getRecipes();
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipesWasCalled(), 2);
        recipeService.getRecipes();
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipesWasCalled(), 3);
        recipeService.getRecipes();
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipesWasCalled(), 4);
        recipeService.getRecipes();
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipesWasCalled(), 5);
    }

    @Test
    void getRecipe () {
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipeWasCalled(), 0);
        recipeService.getRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipeWasCalled(), 1);
        recipeService.getRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipeWasCalled(), 2);
        recipeService.getRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipeWasCalled(), 3);
        recipeService.getRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipeWasCalled(), 4);
        recipeService.getRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesGetRecipeWasCalled(), 5);
    }

    @Test
    void createRecipe () {
        assertEquals(recipeAdapter.getNumberOfTimesCreateRecipeWasCalled(), 0);
        recipeService.createRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesCreateRecipeWasCalled(), 1);
        recipeService.createRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesCreateRecipeWasCalled(), 2);
        recipeService.createRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesCreateRecipeWasCalled(), 3);
        recipeService.createRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesCreateRecipeWasCalled(), 4);
        recipeService.createRecipe(null);
        assertEquals(recipeAdapter.getNumberOfTimesCreateRecipeWasCalled(), 5);
    }
}
