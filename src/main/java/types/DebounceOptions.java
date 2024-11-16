package types;

class DebounceOptions {
    /**
     * ttl in milliseconds
     */
    private Integer ttl;

    /**
     * Identifier
     */
    private String id;

    // Getters and Setters
    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
