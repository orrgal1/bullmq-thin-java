package utils;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class HttpClient {
    private final CloseableHttpClient client = HttpClients.createDefault();
    private final String url = "http://localhost"+System.getenv("BROKER_PORT");

    public <T, U> T post(U args, Class<T> responseType) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(args)));
        post.setHeader("Content-Type", "application/json");

        CloseableHttpResponse response = this.client.execute(post);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getEntity().getContent(), responseType);
    }
}
