package spb.hack.lifeindex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeocoderClient extends ApiClient {

    private final ProxyClient proxyClient;


}
