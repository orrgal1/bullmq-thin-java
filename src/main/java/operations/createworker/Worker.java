package operations.createworker;

import utils.HttpClient;

import java.io.IOException;

public class Worker {
    public static CreateWorkerResponse create(WorkerBody body) throws IOException {
        return HttpClient.post("/worker", body, CreateWorkerResponse.class);
    }
}
