package top.yifan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/nacos/providers")
    public ResponseEntity<String> getServerPort() {
        String result = "provider: " + serverPort;
        return ResponseEntity.ok(result);
    }
}