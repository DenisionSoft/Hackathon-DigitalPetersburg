package spb.hack.lifeindex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeocoderClient {
    private final ProxyClient proxyClient;

}
