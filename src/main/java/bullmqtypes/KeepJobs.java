package bullmqtypes;

public class KeepJobs {
    private Integer age;
    private Integer count;

    // Constructors
    public KeepJobs() {
    }

    public KeepJobs(Integer age, Integer count) {
        this.age = age;
        this.count = count;
    }

    // Getters and Setters
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
