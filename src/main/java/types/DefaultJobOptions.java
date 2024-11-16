package types;

class DefaultJobOptions {
    /**
     * Timestamp when the job was created.
     * Default value is Date.now()
     */
    private Long timestamp = System.currentTimeMillis();

    /**
     * Ranges from 0 (highest priority) to 2,097,152 (lowest priority).
     * Default value is 0.
     */
    private Integer priority = 0;

    /**
     * An amount of milliseconds to wait until this job can be processed.
     * Default value is 0.
     */
    private Long delay = 0L;

    /**
     * The total number of attempts to try the job until it completes.
     * Default value is 0.
     */
    private Integer attempts = 0;

    /**
     * Backoff setting for automatic retries if the job fails.
     */
    private Object backoff;

    /**
     * If true, adds the job to the right of the queue instead of the left.
     * Default value is false.
     */
    private Boolean lifo = false;

    /**
     * If true, removes the job when it successfully completes.
     * Default behavior is to keep the job in the completed set.
     */
    private Object removeOnComplete;

    /**
     * If true, removes the job when it fails after all attempts.
     * Default behavior is to keep the job in the failed set.
     */
    private Object removeOnFail;

    /**
     * Maximum amount of log entries that will be preserved.
     */
    private Integer keepLogs;

    /**
     * Limits the amount of stack trace lines that will be recorded in the stacktrace.
     */
    private Integer stackTraceLimit;

    /**
     * Limits the size in bytes of the job's data payload (as a JSON serialized string).
     */
    private Integer sizeLimit;

    // Getters and Setters
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Object getBackoff() {
        return backoff;
    }

    public void setBackoff(Object backoff) {
        this.backoff = backoff;
    }

    public Boolean getLifo() {
        return lifo;
    }

    public void setLifo(Boolean lifo) {
        this.lifo = lifo;
    }

    public Object getRemoveOnComplete() {
        return removeOnComplete;
    }

    public void setRemoveOnComplete(Object removeOnComplete) {
        this.removeOnComplete = removeOnComplete;
    }

    public Object getRemoveOnFail() {
        return removeOnFail;
    }

    public void setRemoveOnFail(Object removeOnFail) {
        this.removeOnFail = removeOnFail;
    }

    public Integer getKeepLogs() {
        return keepLogs;
    }

    public void setKeepLogs(Integer keepLogs) {
        this.keepLogs = keepLogs;
    }

    public Integer getStackTraceLimit() {
        return stackTraceLimit;
    }

    public void setStackTraceLimit(Integer stackTraceLimit) {
        this.stackTraceLimit = stackTraceLimit;
    }

    public Integer getSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(Integer sizeLimit) {
        this.sizeLimit = sizeLimit;
    }
}
