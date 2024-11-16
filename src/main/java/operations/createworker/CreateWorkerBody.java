package operations.createworker;

import types.WorkerOptions;

public class CreateWorkerBody {
    private String name;
    private WorkerOptions opts;
    private String callback;

    // Constructor
    public CreateWorkerBody(String name, WorkerOptions opts, String callback) {
        this.name = name;
        this.opts = opts;
        this.callback = callback;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerOptions getOpts() {
        return opts;
    }

    public void setOpts(WorkerOptions opts) {
        this.opts = opts;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
