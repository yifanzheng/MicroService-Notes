package top.yifan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yifan.dubbo.DemoConsumerService;

/**
 * DemoResource
 *
 * @author sz7v
 */
@RestController
@RequestMapping("/api")
public class DemoResource {

    @Autowired
    private DemoConsumerService demoConsumerService;

    @GetMapping("/demo/hello")
    public ResponseEntity<String> getHello() {
        String dubbo = demoConsumerService.getHello("dubbo");
        for (int i = 0; i < 15; i++) {
            try {
                demoConsumerService.getHello("dubbo");
                System.out.println("Success");
            }  catch (RuntimeException ex) {
                if (ex.getMessage().contains("SentinelBlockException: FlowException")) {
                    System.out.println("Blocked");
                } else {
                    ex.printStackTrace();
                }
            }
        }
        return ResponseEntity.ok(dubbo);
    }
}
