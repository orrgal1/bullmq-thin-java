package types;

public class RateLimiterOptions {
    private int max;
    private int duration;

    // Constructor
    public RateLimiterOptions(int max, int duration) {
        this.max = max;
        this.duration = duration;
    }

    // Getters and Setters
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
