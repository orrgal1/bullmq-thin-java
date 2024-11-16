package operations.createworker;

public class CreateWorkerResponse {
    private final Boolean running;

    public CreateWorkerResponse(Boolean running) {
        this.running = running;
    }

    public Boolean getRunning() {
        return this.running;
    }
}
