package com.nexshop.benz.dashboard;


import com.nexshop.benz.common.MicroServiceVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * Created by liuwenbo on 2017/3/18.
 */
public class DashboardVerticle extends MicroServiceVerticle {


    @Override
    public void start(Future<Void> future){
        Router router = Router.router(vertx);

        router.route("/*").handler(StaticHandler.create());

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080, ar -> {
                    if (ar.failed()) {
                        future.fail(ar.cause());
                    } else {
                        future.complete();
                    }
                });
    }
}
