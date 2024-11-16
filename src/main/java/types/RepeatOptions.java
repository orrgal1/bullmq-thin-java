package types;

class RepeatOptions {
    /**
     * A repeat pattern.
     */
    private String pattern;

    /**
     * Custom repeatable key. This is the key that holds the "metadata" of a given repeatable job.
     */
    private String key;

    /**
     * Number of times the job should repeat at max.
     */
    private Integer limit;

    /**
     * Repeat after this amount of milliseconds.
     */
    private Long every;

    /**
     * Repeated job should start right now.
     * @deprecated
     */
    private Boolean immediately;

    /**
     * The start value for the repeat iteration count.
     */
    private Integer count;

    /**
     * Internal property to store the previous time the job was executed.
     */
    private Long prevMillis;

    /**
     * Internal property to store the offset to apply to the next iteration.
     * @deprecated
     */
    private Long offset;

    /**
     * Internal property to store the job id.
     * @deprecated
     */
    private String jobId;

    // Getters and Setters
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getEvery() {
        return every;
    }

    public void setEvery(Long every) {
        this.every = every;
    }

    public Boolean getImmediately() {
        return immediately;
    }

    public void setImmediately(Boolean immediately) {
        this.immediately = immediately;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getPrevMillis() {
        return prevMillis;
    }

    public void setPrevMillis(Long prevMillis) {
        this.prevMillis = prevMillis;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
