package net.shadow.with_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        System.setProperty("spring.devtools.restart.enabled", "false");
//        System.setProperty("spring.devtools.livereload.enabled", "false");
        SpringApplication.run(Application.class, args);
    }
}
