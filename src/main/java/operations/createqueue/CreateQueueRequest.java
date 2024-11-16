package operations.createqueue;

import utils.HttpClient;

import java.io.IOException;

public class CreateQueueRequest {
    private HttpClient httpClient = new HttpClient();

    public CreateQueueResponse request(CreateQueueBody body) throws IOException {
        return httpClient.post(body, CreateQueueResponse.class);
    }
}
