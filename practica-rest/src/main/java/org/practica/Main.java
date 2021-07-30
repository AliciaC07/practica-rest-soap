package org.practica;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.openapi.OpenApiPlugin;

public class Main {
    Javalin app = Javalin.create(config ->{
        config.addStaticFiles("/public"); //desde la carpeta de resources
        config.registerPlugin(new RouteOverviewPlugin("/routes")); //aplicando plugins de las rutas
        config.enableCorsForAllOrigins();

    });
}
