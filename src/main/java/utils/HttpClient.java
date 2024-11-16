package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class HttpClient {
    private static final CloseableHttpClient client = HttpClients.createDefault();

    public static <T, U> T post(String path, U body, Class<T> responseType) throws IOException {
        String url = "http://localhost:" + (System.getenv("BULLMQ_BROKER_PORT") != null ? System.getenv("BULLMQ_BROKER_PORT") : System.getProperty("BULLMQ_BROKER_PORT"));
        HttpPost post = new HttpPost(url + path);
        post.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(body)));
        post.setHeader("Content-Type", "application/json");

        CloseableHttpResponse response = client.execute(post);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getEntity().getContent(), responseType);
    }
}
