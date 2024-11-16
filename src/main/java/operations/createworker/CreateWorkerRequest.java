package operations.createworker;

import utils.HttpClient;

import java.io.IOException;

public class CreateWorkerRequest {
    private final HttpClient httpClient = new HttpClient();

    public CreateWorkerResponse request(CreateWorkerBody body) throws IOException {
        return httpClient.post(body, CreateWorkerResponse.class);
    }
}
