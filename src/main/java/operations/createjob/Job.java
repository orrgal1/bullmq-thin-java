package operations.createjob;

import utils.HttpClient;

import java.io.IOException;

public class Job {
    private Job() {
    }

    public static CreateJobResponse create(JobBody body) throws IOException {
        return HttpClient.post("/job", body, CreateJobResponse.class);
    }
}
