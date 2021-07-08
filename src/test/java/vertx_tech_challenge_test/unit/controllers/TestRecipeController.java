package vertx_tech_challenge_test.unit.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import vertx_tech_challenge.vertx_tech_challenge.controllers.RecipeController;
import vertx_tech_challenge_test.mocks.MockRecipeAdapter;
import vertx_tech_challenge_test.mocks.MockRecipeService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRecipeController {
    static RecipeController recipeController;
    static MockRecipeService recipeService;

    @BeforeAll
    static void create_controller () {
        recipeService = new MockRecipeService(new MockRecipeAdapter());
        recipeController = new RecipeController(recipeService);
    }

    @Test
    void getRecipes () {
        assertEquals(recipeService.getNumberOfTimesGetRecipesWasCalled(), 0);
        recipeController.getRecipes();
        assertEquals(recipeService.getNumberOfTimesGetRecipesWasCalled(), 1);
        recipeController.getRecipes();
        assertEquals(recipeService.getNumberOfTimesGetRecipesWasCalled(), 2);
        recipeController.getRecipes();
        assertEquals(recipeService.getNumberOfTimesGetRecipesWasCalled(), 3);
        recipeController.getRecipes();
        assertEquals(recipeService.getNumberOfTimesGetRecipesWasCalled(), 4);
        recipeController.getRecipes();
        assertEquals(recipeService.getNumberOfTimesGetRecipesWasCalled(), 5);
    }

    @Test
    void getRecipe () {
        assertEquals(recipeService.getNumberOfTimesGetRecipeWasCalled(), 0);
        recipeService.getRecipe(null);
        assertEquals(recipeService.getNumberOfTimesGetRecipeWasCalled(), 1);
        recipeService.getRecipe(null);
        assertEquals(recipeService.getNumberOfTimesGetRecipeWasCalled(), 2);
        recipeService.getRecipe(null);
        assertEquals(recipeService.getNumberOfTimesGetRecipeWasCalled(), 3);
        recipeService.getRecipe(null);
        assertEquals(recipeService.getNumberOfTimesGetRecipeWasCalled(), 4);
        recipeService.getRecipe(null);
        assertEquals(recipeService.getNumberOfTimesGetRecipeWasCalled(), 5);
    }

    @Test
    void createRecipe () {
        assertEquals(recipeService.getNumberOfTimesCreateRecipeWasCalled(), 0);
        recipeService.createRecipe(null);
        assertEquals(recipeService.getNumberOfTimesCreateRecipeWasCalled(), 1);
        recipeService.createRecipe(null);
        assertEquals(recipeService.getNumberOfTimesCreateRecipeWasCalled(), 2);
        recipeService.createRecipe(null);
        assertEquals(recipeService.getNumberOfTimesCreateRecipeWasCalled(), 3);
        recipeService.createRecipe(null);
        assertEquals(recipeService.getNumberOfTimesCreateRecipeWasCalled(), 4);
        recipeService.createRecipe(null);
        assertEquals(recipeService.getNumberOfTimesCreateRecipeWasCalled(), 5);
    }
}
