package operations.createrouter;

import utils.HttpClient;

import java.io.IOException;

public class Router {
    public static CreateRouterResponse create(RouterBody body) throws IOException {
        return HttpClient.post("/router", body, CreateRouterResponse.class);
    }
}
