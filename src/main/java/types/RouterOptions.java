package types;

import java.util.function.Function;

public class RouterOptions extends QueueBaseOptions {
    /**
     * Skip Meta update.
     *
     * If true, the queue will not update the metadata of the queue.
     * Useful for read-only systems that should not update the metadata.
     * Default value is false.
     */
    private Boolean skipMetasUpdate = false;

    private Integer batchSize;

    private Long blockTimeMs;

    private Long maxRetentionMs;

    private Long trimIntervalMs;

    private Function<Object, JobsOptions> optsOverride;

    // Getters and Setters
    public Boolean getSkipMetasUpdate() {
        return skipMetasUpdate;
    }

    public void setSkipMetasUpdate(Boolean skipMetasUpdate) {
        this.skipMetasUpdate = skipMetasUpdate;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public Long getBlockTimeMs() {
        return blockTimeMs;
    }

    public void setBlockTimeMs(Long blockTimeMs) {
        this.blockTimeMs = blockTimeMs;
    }

    public Long getMaxRetentionMs() {
        return maxRetentionMs;
    }

    public void setMaxRetentionMs(Long maxRetentionMs) {
        this.maxRetentionMs = maxRetentionMs;
    }

    public Long getTrimIntervalMs() {
        return trimIntervalMs;
    }

    public void setTrimIntervalMs(Long trimIntervalMs) {
        this.trimIntervalMs = trimIntervalMs;
    }

    public Function<Object, JobsOptions> getOptsOverride() {
        return optsOverride;
    }

    public void setOptsOverride(Function<Object, JobsOptions> optsOverride) {
        this.optsOverride = optsOverride;
    }
}
