package operations.callback;

import spark.Route;

import static spark.Spark.*;

public class CallbackServer {
    public CallbackServer(Integer cbPort) {
        port(cbPort);
        threadPool(
                Integer.parseInt(System.getenv().getOrDefault("BULLMQ_CALLBACK_MAX_THREADS", "10")),
                Integer.parseInt(System.getenv().getOrDefault("BULLMQ_CALLBACK_MIN_THREADS", "1")),
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
