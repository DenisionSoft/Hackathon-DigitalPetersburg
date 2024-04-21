package spb.hack.lifeindex.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class ProxyClient {
    private static final RestTemplate restTemplate = new RestTemplate();

    public <T> T get(String url, Class<T> responseType) {
        try {
            return restTemplate.getForObject(url, responseType);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T post(String url, Object body, Class<T> responseType) {
        try {
            return restTemplate.postForObject(url, body, responseType);
        } catch (Exception e) {
            return null;
        }
    }
}
