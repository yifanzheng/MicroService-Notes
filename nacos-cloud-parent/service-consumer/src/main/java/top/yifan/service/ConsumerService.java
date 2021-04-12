package top.yifan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author star
 * @date 2021/4/10
 */
@Service
public class ConsumerService {

    @Value("${nacos.provider}")
    private String endpoint;

    @Autowired
    private RestTemplate restTemplate;

    public String getName() {
        String url = endpoint + "/api/nacos/providers";
        return restTemplate.getForObject(url, String.class);
    }
}
