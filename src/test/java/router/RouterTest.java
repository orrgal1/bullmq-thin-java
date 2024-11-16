package router;

import com.fasterxml.jackson.core.JsonProcessingException;
import operations.callback.CallbackServer;
import operations.createjob.Job;
import operations.createjob.JobBody;
import operations.createqueue.Queue;
import operations.createqueue.QueueBody;
import operations.createrouter.Router;
import operations.createrouter.RouterBody;
import operations.createworker.Worker;
import operations.createworker.WorkerBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy;
import org.testcontainers.junit.jupiter.Testcontainers;
import types.JobsOptions;
import types.QueueOptions;
import types.RouterOptions;
import types.WorkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
public class RouterTest {

    private static Network sharedNetwork = Network.newNetwork();

    @BeforeAll
    public static void setUp() {
        GenericContainer<?> redisContainer = new GenericContainer<>("redis:7.0.0")
                .waitingFor(new LogMessageWaitStrategy().withRegEx(".*Ready to accept connections.*"))
                .withExposedPorts(6379)
                .withNetworkAliases("redis-service")
                .withNetwork(sharedNetwork);
        redisContainer.start();

        GenericContainer<?> brokerContainer = new GenericContainer<>("ghcr.io/orrgal1/bullmq-broker:0.22.3")
                .withExposedPorts(5050)
                .withNetworkAliases("broker-service")
                .withEnv("REDIS_HOST", "redis-service")
                .withEnv("REDIS_PORT", "6379")
                .withEnv("BROKER_PORT", "5050")
                .withEnv("DEBUG", "*")
                .waitingFor(new LogMessageWaitStrategy().withRegEx(".*Broker server started on port.*"))
                .withNetwork(sharedNetwork);
        brokerContainer.start();

        Integer brokerPort = brokerContainer.getFirstMappedPort();
        System.setProperty("BULLMQ_BROKER_PORT", brokerPort.toString());
    }

    @Test
    void useARouter() throws IOException, InterruptedException {
        String testKey = java.util.UUID.randomUUID().toString();
        Queue.create(new QueueBody("source-" + testKey, new QueueOptions()));
        Queue.create(new QueueBody("target1-" + testKey, new QueueOptions()));
        Queue.create(new QueueBody("target2-" + testKey, new QueueOptions()));
        Router.create(new RouterBody("router-" + testKey, List.of("source-" + testKey), List.of(new RouterBody.Target("target1-" + testKey, new QueueOptions()), new RouterBody.Target("target2-" + testKey, new QueueOptions())), new RouterOptions()));
        Worker.create(new WorkerBody("target1-" + testKey, new WorkerOptions(), "http://host.docker.internal:4567/add"));
        Worker.create(new WorkerBody("target2-" + testKey, new WorkerOptions(), "http://host.docker.internal:4567/add"));
        List<Integer> results = new CopyOnWriteArrayList<>();

        CallbackServer cbServer = new CallbackServer(4567);
        cbServer.addEndpoint("/add", (req, res) -> {
            try {
                Map<String, Integer> body = new com.fasterxml.jackson.databind.ObjectMapper().readValue(req.body(), new com.fasterxml.jackson.core.type.TypeReference<Map<String, Integer>>() {
                });
                results.add(body.get("a") + body.get("b"));
                res.status(200);
                System.out.println(">>>>>>>>> Got result <<<<<<<<<");
                return "OK";
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        cbServer.awaitReady();

        Job.create(new JobBody<>("source-" + testKey, new JobsOptions(), Map.of("a", 1, "b", 2)));

        while (results.size() < 2) {
            Thread.sleep(1000);
            System.out.println(">>>>>>>>> Got results: " + results.size() + "<<<<<<<<<");
        }
        assertEquals(3, (int) results.get(0), "The result of 1 + 2 should be 3.");
        assertEquals(3, (int) results.get(1), "The result of 1 + 2 should be 3.");
    }
}
