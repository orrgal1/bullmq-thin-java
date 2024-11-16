package bullmqtypes;

class BaseJobOptions extends DefaultJobOptions {
    /**
     * Repeat this job, for example based on a `cron` schedule.
     */
    private RepeatOptions repeat;

    /**
     * Internal property used by repeatable jobs to save base repeat job key.
     */
    private String repeatJobKey;

    /**
     * Override the job ID - by default, the job ID is a unique
     * integer, but you can use this setting to override it.
     * If you use this option, it is up to you to ensure the
     * jobId is unique. If you attempt to add a job with an id that
     * already exists, it will not be added.
     */
    private String jobId;

    private ParentOptions parent;

    /**
     * Internal property used by repeatable jobs.
     */
    private Long prevMillis;

    // Getters and Setters
    public RepeatOptions getRepeat() {
        return repeat;
    }

    public void setRepeat(RepeatOptions repeat) {
        this.repeat = repeat;
    }

    public String getRepeatJobKey() {
        return repeatJobKey;
    }

    public void setRepeatJobKey(String repeatJobKey) {
        this.repeatJobKey = repeatJobKey;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public ParentOptions getParent() {
        return parent;
    }

    public void setParent(ParentOptions parent) {
        this.parent = parent;
    }

    public Long getPrevMillis() {
        return prevMillis;
    }

    public void setPrevMillis(Long prevMillis) {
        this.prevMillis = prevMillis;
    }
}
