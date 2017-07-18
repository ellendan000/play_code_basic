package net.shadow.withspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@ComponentScan(excludeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = FeignClient.class)
//})
public class Application {
    public static void main(String[] args) {
//        System.setProperty("spring.devtools.restart.enabled", "false");
//        System.setProperty("spring.devtools.livereload.enabled", "false");
        SpringApplication.run(Application.class, args);
    }
}
