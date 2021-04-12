package top.yifan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author star
 * @date 2021/4/10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceConsumer01Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumer01Application.class, args);
    }
}
