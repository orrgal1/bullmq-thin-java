package operations.createjob;

import types.JobsOptions;

public class JobBody<T> {
    private String name;
    private JobsOptions opts;
    private T data;

    // Constructor
    public JobBody(String name, JobsOptions opts, T data) {
        this.name = name;
        this.opts = opts;
        this.data = data;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobsOptions getOpts() {
        return opts;
    }

    public void setOpts(JobsOptions opts) {
        this.opts = opts;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
