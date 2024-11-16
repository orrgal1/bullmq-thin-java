package operations.createWorker;

import spark.Route;
import utils.HttpServer;

public class WorkerCallbackProcessor {
    WorkerCallbackProcessor(int port, String path, Route callback) {
        // Create a new HttpServer instance
        HttpServer server = new HttpServer(port);

        // Add an endpoint to the server
        server.addEndpoint(path, callback);

        // Start the server
        server.start();
    }
}
