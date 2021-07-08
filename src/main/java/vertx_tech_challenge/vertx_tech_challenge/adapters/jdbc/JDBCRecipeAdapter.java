package vertx_tech_challenge.vertx_tech_challenge.adapters.jdbc;

import io.vertx.core.json.JsonObject;

import vertx_tech_challenge.vertx_tech_challenge.adapters.RecipeAdapter;

import java.util.Arrays;

public class JDBCRecipeAdapter implements RecipeAdapter {
    // TODO: use real identifier
    private static final String IDENTIFIER_KEY = "foo";
//    JDBCPool pool;
//
//    public JDBCRecipeAdapter(JDBCPool pool) {
//        this.pool = pool;
//    }

    // TODO: get all recipes from DB
    @Override
    public String getRecipes() {
         return "";
    }

    // TODO: get one recipe from DB
    @Override
    public String getRecipe(String recipeId) {
        return "";
    }

    // TODO: actually store data and return an identifier
    @Override
    public String createRecipe(JsonObject body) {
        return "";
    }
}
