package router;

import operations.callback.CallbackServer;
import operations.createqueue.CreateQueueBody;
import operations.createqueue.CreateQueueRequest;
import operations.createrouter.CreateRouterBody;
import operations.createrouter.CreateRouterRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import types.QueueOptions;
import types.RouterOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
public class RouterTest {

    private static Network network;

    @Container
    private static GenericContainer<?> redisContainer = new GenericContainer<>("redis:7.0.0")
            .waitingFor(new LogMessageWaitStrategy().withRegEx(".*Ready to accept connections.*"))
            .withExposedPorts(6379).withNetworkAliases("redis-service")
            .withNetwork(Network.SHARED);

    @Container
    private static GenericContainer<?> brokerContainer = new GenericContainer<>("ghcr.io/orrgal1/bullmq-broker:latest")
            .withExposedPorts(5050)
            .withNetworkAliases("bullmq-broker-service")
            .withEnv("REDIS_HOST", "localhost")
            .withEnv("REDIS_PORT", "6379")
            .withEnv("BROKER_PORT", "5050")
            .withEnv("DEBUG", "*")
            .waitingFor(new LogMessageWaitStrategy().withRegEx(".*Broker server started on port.*"))
            .withNetwork(Network.SHARED);

    @BeforeAll
    public static void setUp() {
        // Start the network that both containers will use
        network = Network.newNetwork();
        redisContainer.withNetwork(network);
        brokerContainer.withNetwork(network);

        redisContainer.start();
        brokerContainer.start();
        Integer brokerPort = brokerContainer.getFirstMappedPort();
        System.setProperty("BULLMQ_BROKER_PORT", brokerPort.toString());
    }

    @AfterAll
    public static void tearDown() {
        // Stop both containers after all tests are done
        redisContainer.stop();
        brokerContainer.stop();
        network.close();
    }

    @Test
    void useARouter() throws IOException {
        String testKey = java.util.UUID.randomUUID().toString();
        new CreateQueueRequest().request(new CreateQueueBody("source-" + testKey, new QueueOptions()));
        new CreateQueueRequest().request(new CreateQueueBody("target1-" + testKey, new QueueOptions()));
        new CreateQueueRequest().request(new CreateQueueBody("target2-" + testKey, new QueueOptions()));
        new CreateRouterRequest().request(new CreateRouterBody("router-" + testKey, List.of("source-" + testKey), List.of(new CreateRouterBody.Target("target1-" + testKey, new QueueOptions()), new CreateRouterBody.Target("target2-" + testKey, new QueueOptions())), new RouterOptions()));

        ArrayList<Integer> results = new ArrayList<>();

        CallbackServer cbServer = new CallbackServer();
        cbServer.addEndpoint("/add", (req, res) -> {
            results.add(Integer.parseInt(req.queryParams("a")) + Integer.parseInt(req.queryParams("b")));
            return "OK";
        });
        cbServer.awaitReady();


        assertTrue(redisContainer.isRunning(), "Redis container should be running.");
    }
}
