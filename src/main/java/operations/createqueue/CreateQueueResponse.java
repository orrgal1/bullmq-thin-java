package operations.createqueue;

public class CreateQueueResponse {
    private final String jobId;

    public CreateQueueResponse(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return this.jobId;
    }
}
