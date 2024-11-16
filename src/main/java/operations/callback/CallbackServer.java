package operations.callback;

import spark.Route;

import static spark.Spark.*;

public class CallbackServer {
    public CallbackServer() {
        port(Integer.parseInt(System.getenv("BULLMQ_CALLBACK_PORT")));
        threadPool(
            Integer.parseInt(System.getenv().getOrDefault("BULLMQ_CALLBACK_MAX_THREADS", "200")),
            Integer.parseInt(System.getenv().getOrDefault("BULLMQ_CALLBACK_MIN_THREADS", "8")),
            Integer.parseInt(System.getenv().getOrDefault("BULLMQ_CALLBACK_IDLE_TIMEOUT", "60000"))
        );
    }

    public void addEndpoint(String path, Route route) {
        post(path, route);
    }

    public void awaitReady() {
        awaitInitialization();
    }
}
