class ParentOptions {
    private String id;

    /**
     * It includes the prefix, the namespace separator :, and queue name.
     * @see https://www.gnu.org/software/gawk/manual/html_node/Qualified-Names.html
     */
    private String queue;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }
}
