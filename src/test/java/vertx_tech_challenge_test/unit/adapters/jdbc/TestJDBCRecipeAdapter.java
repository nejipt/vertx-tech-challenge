package vertx_tech_challenge_test.unit.adapters.jdbc;

import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vertx_tech_challenge.vertx_tech_challenge.adapters.jdbc.JDBCRecipeAdapter;

public class TestJDBCRecipeAdapter {
    JDBCRecipeAdapter jdbcRecipeAdapter;
    String recipeId;
    JsonObject body;

    @BeforeEach
    void create () {
        recipeId = "1";
        body = new JsonObject("{ \"foo\": \"bar\" }");
//        jdbcRecipeAdapter = new JDBCRecipeAdapter(JDBCPool.pool(Vertx.vertx()));
    }

    @Test
    void getRecipes () {
        assert(jdbcRecipeAdapter.getRecipes()).equals("um, dois");
    }

    @Test
    void getRecipe () {
        assert(jdbcRecipeAdapter.getRecipe(recipeId)).equals(recipeId);
    }

    @Test
    void createRecipe () {
        assert(jdbcRecipeAdapter.createRecipe(body)).equals("bar");
    }
}
