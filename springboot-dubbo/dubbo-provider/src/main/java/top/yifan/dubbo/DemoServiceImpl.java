package top.yifan.dubbo;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * DemoServiceImpl
 *
 * @author sz7v
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
