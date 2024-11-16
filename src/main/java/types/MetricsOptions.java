package types;

public class MetricsOptions {
    private Integer maxDataPoints;

    // Constructor
    public MetricsOptions() {
    }

    public MetricsOptions(Integer maxDataPoints) {
        this.maxDataPoints = maxDataPoints;
    }

    // Getter and Setter
    public Integer getMaxDataPoints() {
        return maxDataPoints;
    }

    public void setMaxDataPoints(Integer maxDataPoints) {
        this.maxDataPoints = maxDataPoints;
    }
}
