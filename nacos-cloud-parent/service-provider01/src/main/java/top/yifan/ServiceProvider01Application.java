package top.yifan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider01Application.class, args);
    }
}