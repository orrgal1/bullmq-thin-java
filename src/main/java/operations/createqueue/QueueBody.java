package operations.createqueue;

import types.QueueOptions;

public class QueueBody {
    private String name;
    private QueueOptions opts;

    // Constructor
    public QueueBody(String name, QueueOptions opts) {
        this.name = name;
        this.opts = opts;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QueueOptions getOpts() {
        return opts;
    }

    public void setOpts(QueueOptions opts) {
        this.opts = opts;
    }
}
