package vertx_tech_challenge.vertx_tech_challenge;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import vertx_tech_challenge.vertx_tech_challenge.controllers.RecipeController;
import vertx_tech_challenge.vertx_tech_challenge.services.RecipeService;
import vertx_tech_challenge.vertx_tech_challenge.adapters.jdbc.JDBCRecipeAdapter;

public class MainVerticle extends AbstractVerticle {
  private static final int PORT = 8081;
  private static final String RECIPES_ENDPOINT = "/recipes";
  private static final int TEN_KILOBYTES = 10 * 1024;
  Router router = Router.router(vertx);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

//    JDBCConnectOptions opts = new JDBCConnectOptions()
//            .setJdbcUrl("jdbc:mysql://localhost:3306")
//            .setDatabase("RecipesDB")
//            .setUser("recipes")
//            .setPassword("sillyrecipespw");
//
//    PoolOptions poolOpts = new PoolOptions().setMaxSize(5);
//
//    JDBCPool POOL = JDBCPool.pool(vertx, opts, poolOpts);

    RecipeController recipeController = new RecipeController(new RecipeService(new JDBCRecipeAdapter()));

    HttpServer server = vertx.createHttpServer();

    router.route("/").handler(ctx -> ctx.redirect(RECIPES_ENDPOINT));

    router.route(HttpMethod.GET, RECIPES_ENDPOINT).handler(ctx -> {
      HttpServerResponse res = ctx.response();

      String data = recipeController.getRecipes();

      res.end(data);
    });

    router.route(HttpMethod.GET, RECIPES_ENDPOINT + "/:recipeId").handler(ctx -> {
      HttpServerResponse res = ctx.response();

      String data = recipeController.getRecipe(ctx.pathParam("recipeId"));

      res.end(data);
    });

    router.route(HttpMethod.POST, RECIPES_ENDPOINT).handler(BodyHandler.create());

    router.route(HttpMethod.POST, RECIPES_ENDPOINT).handler(ctx -> {
      HttpServerResponse res = ctx.response();

      JsonObject body = ctx.getBodyAsJson(TEN_KILOBYTES);

      String data = recipeController.createRecipe(body);

      res.end(data);
    });

    server.requestHandler(router).listen(PORT, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
        return;
      }

      startPromise.fail(http.cause());
    });
  }
}
