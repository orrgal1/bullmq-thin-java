package operations.createRouter;

import utils.HttpClient;

import java.io.IOException;

public class CreateWorkerRequest {
    private HttpClient httpClient = new HttpClient();

    public CreateWorkerResponse request(CreateWorkerBody body) throws IOException {
        return httpClient.post(body, CreateWorkerResponse.class);
    }
}
