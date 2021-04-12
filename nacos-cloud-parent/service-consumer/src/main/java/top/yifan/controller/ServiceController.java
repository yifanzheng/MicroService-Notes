package top.yifan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yifan.service.ConsumerService;

/**
 * @author star
 * @date 2021/4/10
 */
@RequestMapping("/api")
@RestController
public class ServiceController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/nacos/consumers")
    public ResponseEntity<String> getValue() {
        String name = consumerService.getName();
        return ResponseEntity.ok(name);
    }
}
