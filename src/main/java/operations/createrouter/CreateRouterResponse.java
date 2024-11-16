package operations.createrouter;

public class CreateRouterResponse {
    private final Boolean running;

    public CreateRouterResponse(Boolean running) {
        this.running = running;
    }

    public Boolean getRunning() {
        return this.running;
    }
}
