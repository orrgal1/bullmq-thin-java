package types;

public interface AdvancedRepeatOptions {
    /**
     * A custom cron strategy.
     */
    RepeatStrategy getRepeatStrategy();

    void setRepeatStrategy(RepeatStrategy repeatStrategy);

    /**
     * A hash algorithm to be used when trying to create the job redis key.
     * Default - md5
     */
    String getRepeatKeyHashAlgorithm();

    void setRepeatKeyHashAlgorithm(String repeatKeyHashAlgorithm);
}

