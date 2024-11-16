package bullmqtypes;

public class QueueBaseOptions {
    /**
     * Denotes commands should retry indefinitely.
     */
    private Boolean blockingConnection;

    /**
     * Prefix for all queue keys.
     */
    private String prefix;

    /**
     * Avoid version validation to be greater or equal than v5.0.0.
     * Default value is false.
     */
    private Boolean skipVersionCheck = false;

    public Boolean getBlockingConnection() {
        return blockingConnection;
    }

    public void setBlockingConnection(Boolean blockingConnection) {
        this.blockingConnection = blockingConnection;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Boolean getSkipVersionCheck() {
        return skipVersionCheck;
    }

    public void setSkipVersionCheck(Boolean skipVersionCheck) {
        this.skipVersionCheck = skipVersionCheck;
    }
}
