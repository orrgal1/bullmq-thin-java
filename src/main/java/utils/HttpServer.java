package utils;

import static spark.Spark.*;
import spark.Route;

public class HttpServer {
    public HttpServer(int serverPort) {
        port(serverPort);
    }

    public void addEndpoint(String path, Route route) {
        post(path, route);
    }

    public void start() {
        awaitInitialization();
    }
}
