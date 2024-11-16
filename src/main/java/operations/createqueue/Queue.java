package operations.createqueue;

import utils.HttpClient;

import java.io.IOException;

public class Queue {
    public static CreateQueueResponse create(QueueBody body) throws IOException {
        return HttpClient.post("/queue", body, CreateQueueResponse.class);
    }
}
