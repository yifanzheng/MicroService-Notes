package top.yifan;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.time.Instant;
import java.util.TimeZone;

/**
 * PortalApplication
 *
 */
@EnableDubbo
@SpringBootApplication
public class DubboConsumerApplication {

    private static final Logger log = LoggerFactory.getLogger(DubboConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DubboConsumerApplication.class);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }

        log.info("\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\t{}://localhost:{}\n\t"
                        + "External: \t{}://{}:{}\n\t"
                        + "Profile(s): \t{}"
                        + "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                protocol,
                hostAddress,
                env.getProperty("server.port"),
                env.getActiveProfiles());
    }

    @PostConstruct
    void started() {
        // 将应用程序置身于US时区之中，以统一不同时区的时间
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
        log.info("Change time zone to US, current time: {}", Instant.now());
    }

}
