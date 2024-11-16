package operations.createrouter;

import utils.HttpClient;

import java.io.IOException;

public class CreateRouterRequest {
    private final HttpClient httpClient = new HttpClient();

    public CreateRouterResponse request(CreateRouterBody body) throws IOException {
        return httpClient.post(body, CreateRouterResponse.class);
    }
}
