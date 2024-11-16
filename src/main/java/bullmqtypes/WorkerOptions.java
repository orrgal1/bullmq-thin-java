package bullmqtypes;

public class WorkerOptions extends QueueBaseOptions  {

    private String name;
    private Boolean autorun = true;
    private Integer concurrency = 1;
    private RateLimiterOptions limiter;
    private MetricsOptions metrics;
    private Integer maxStalledCount = 1;
    private Integer stalledInterval = 30000;
    private KeepJobs removeOnComplete;
    private KeepJobs removeOnFail;
    private Boolean skipStalledCheck = false;
    private Boolean skipLockRenewal = false;
    private Integer drainDelay = 5;
    private Integer lockDuration = 30000;
    private Integer lockRenewTime;
    private Integer runRetryDelay = 15000;
    private AdvancedOptions settings;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAutorun() {
        return autorun;
    }

    public void setAutorun(Boolean autorun) {
        this.autorun = autorun;
    }

    public Integer getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
    }

    public RateLimiterOptions getLimiter() {
        return limiter;
    }

    public void setLimiter(RateLimiterOptions limiter) {
        this.limiter = limiter;
    }

    public MetricsOptions getMetrics() {
        return metrics;
    }

    public void setMetrics(MetricsOptions metrics) {
        this.metrics = metrics;
    }

    public Integer getMaxStalledCount() {
        return maxStalledCount;
    }

    public void setMaxStalledCount(Integer maxStalledCount) {
        this.maxStalledCount = maxStalledCount;
    }

    public Integer getStalledInterval() {
        return stalledInterval;
    }

    public void setStalledInterval(Integer stalledInterval) {
        this.stalledInterval = stalledInterval;
    }

    public KeepJobs getRemoveOnComplete() {
        return removeOnComplete;
    }

    public void setRemoveOnComplete(KeepJobs removeOnComplete) {
        this.removeOnComplete = removeOnComplete;
    }

    public KeepJobs getRemoveOnFail() {
        return removeOnFail;
    }

    public void setRemoveOnFail(KeepJobs removeOnFail) {
        this.removeOnFail = removeOnFail;
    }

    public Boolean getSkipStalledCheck() {
        return skipStalledCheck;
    }

    public void setSkipStalledCheck(Boolean skipStalledCheck) {
        this.skipStalledCheck = skipStalledCheck;
    }

    public Boolean getSkipLockRenewal() {
        return skipLockRenewal;
    }

    public void setSkipLockRenewal(Boolean skipLockRenewal) {
        this.skipLockRenewal = skipLockRenewal;
    }

    public Integer getDrainDelay() {
        return drainDelay;
    }

    public void setDrainDelay(Integer drainDelay) {
        this.drainDelay = drainDelay;
    }

    public Integer getLockDuration() {
        return lockDuration;
    }

    public void setLockDuration(Integer lockDuration) {
        this.lockDuration = lockDuration;
    }

    public Integer getLockRenewTime() {
        return lockRenewTime;
    }

    public void setLockRenewTime(Integer lockRenewTime) {
        this.lockRenewTime = lockRenewTime;
    }

    public Integer getRunRetryDelay() {
        return runRetryDelay;
    }

    public void setRunRetryDelay(Integer runRetryDelay) {
        this.runRetryDelay = runRetryDelay;
    }

    public AdvancedOptions getSettings() {
        return settings;
    }

    public void setSettings(AdvancedOptions settings) {
        this.settings = settings;
    }
}
