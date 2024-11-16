package types;

public class JobsOptions extends BaseJobOptions {
    /**
     * Debounce options.
     *
     * @deprecated use deduplication option
     */
    private DebounceOptions debounce;

    /**
     * Deduplication options.
     */
    private DebounceOptions deduplication;

    /**
     * If true, moves parent to failed.
     */
    private Boolean failParentOnFailure;

    /**
     * If true, moves the jobId from its parent dependencies to failed dependencies when it fails after all attempts.
     */
    private Boolean ignoreDependencyOnFailure;

    /**
     * If true, removes the job from its parent dependencies when it fails after all attempts.
     */
    private Boolean removeDependencyOnFailure;

    // Getters and Setters
    public DebounceOptions getDebounce() {
        return debounce;
    }

    public void setDebounce(DebounceOptions debounce) {
        this.debounce = debounce;
    }

    public DebounceOptions getDeduplication() {
        return deduplication;
    }

    public void setDeduplication(DebounceOptions deduplication) {
        this.deduplication = deduplication;
    }

    public Boolean getFailParentOnFailure() {
        return failParentOnFailure;
    }

    public void setFailParentOnFailure(Boolean failParentOnFailure) {
        this.failParentOnFailure = failParentOnFailure;
    }

    public Boolean getIgnoreDependencyOnFailure() {
        return ignoreDependencyOnFailure;
    }

    public void setIgnoreDependencyOnFailure(Boolean ignoreDependencyOnFailure) {
        this.ignoreDependencyOnFailure = ignoreDependencyOnFailure;
    }

    public Boolean getRemoveDependencyOnFailure() {
        return removeDependencyOnFailure;
    }

    public void setRemoveDependencyOnFailure(Boolean removeDependencyOnFailure) {
        this.removeDependencyOnFailure = removeDependencyOnFailure;
    }
}
