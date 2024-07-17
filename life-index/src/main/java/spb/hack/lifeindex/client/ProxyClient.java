package spb.hack.lifeindex.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProxyClient {
    private static final RestTemplate restTemplate = new RestTemplate();

    @Value("${spbtoken}")
    private String SPB_TOKEN;

    public <T> T get(String url, Class<T> responseType) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + SPB_TOKEN);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
            return response.getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T post(String url, Object body, Class<T> responseType) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + SPB_TOKEN);
            HttpEntity<Object> entity = new HttpEntity<>(body, headers);
            return restTemplate.postForObject(url, entity, responseType);
        } catch (Exception e) {
            return null;
        }
    }
}
