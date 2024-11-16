package types;

public class QueueOptions extends QueueBaseOptions {
    private DefaultJobOptions defaultJobOptions;

    /**
     * Options for the streams used internally in BullMQ.
     */
    private StreamsOptions streams;

    /**
     * Skip Meta update.
     *
     * If true, the queue will not update the metadata of the queue.
     * Useful for read-only systems that should not update the metadata.
     *
     * Default value is false.
     */
    private boolean skipMetasUpdate = false;

    /**
     * Advanced options for the repeatable jobs.
     */
    private AdvancedRepeatOptions settings;

    // Getters and setters
    public DefaultJobOptions getDefaultJobOptions() {
        return defaultJobOptions;
    }

    public void setDefaultJobOptions(DefaultJobOptions defaultJobOptions) {
        this.defaultJobOptions = defaultJobOptions;
    }

    public StreamsOptions getStreams() {
        return streams;
    }

    public void setStreams(StreamsOptions streams) {
        this.streams = streams;
    }

    public boolean isSkipMetasUpdate() {
        return skipMetasUpdate;
    }

    public void setSkipMetasUpdate(boolean skipMetasUpdate) {
        this.skipMetasUpdate = skipMetasUpdate;
    }

    public AdvancedRepeatOptions getSettings() {
        return settings;
    }

    public void setSettings(AdvancedRepeatOptions settings) {
        this.settings = settings;
    }

    // Nested classes for StreamsOptions and EventsStreamOptions
    public static class StreamsOptions {
        private EventsStreamOptions events;

        public EventsStreamOptions getEvents() {
            return events;
        }

        public void setEvents(EventsStreamOptions events) {
            this.events = events;
        }
    }

    public static class EventsStreamOptions {
        /**
         * Max approximated length for streams. Default is 10,000 events.
         */
        private int maxLen = 10000;

        public int getMaxLen() {
            return maxLen;
        }

        public void setMaxLen(int maxLen) {
            this.maxLen = maxLen;
        }
    }
}
