package types;

public interface AdvancedOptions extends AdvancedRepeatOptions {
    /**
     * A custom backoff strategy.
     */
    BackoffStrategy getBackoffStrategy();

    void setBackoffStrategy(BackoffStrategy backoffStrategy);
}
