package operations.createrouter;

import types.QueueOptions;
import types.RouterOptions;

import java.util.List;

public class CreateRouterBody {
    private String name;
    private List<String> sources;
    private List<Target> targets;
    private RouterOptions opts;

    // Constructor
    public CreateRouterBody(String name, List<String> sources, List<Target> targets, RouterOptions opts) {
        this.name = name;
        this.sources = sources;
        this.targets = targets;
        this.opts = opts;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public RouterOptions getOpts() {
        return opts;
    }

    public void setOpts(RouterOptions opts) {
        this.opts = opts;
    }

    // Inner class for Target
    public static class Target {
        private String name;
        private QueueOptions opts;

        // Constructor
        public Target(String name, QueueOptions opts) {
            this.name = name;
            this.opts = opts;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public QueueOptions getOpts() {
            return opts;
        }

        public void setOpts(QueueOptions opts) {
            this.opts = opts;
        }
    }
}
