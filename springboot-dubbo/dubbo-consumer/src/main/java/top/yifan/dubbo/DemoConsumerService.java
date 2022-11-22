package top.yifan.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * DemoConsumerService
 *
 * @author sz7v
 */
@Service
public class DemoConsumerService {

    @Reference
    private DemoService demoService;

    public String getHello(String name) {
        return demoService.sayHello(name);
    }
}
