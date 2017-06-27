package com.example.szconsumerservice;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SzConsumerServiceApplication {
    @Bean
    RestOperations restOperations() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SzConsumerServiceApplication.class, args);
    }
}

@Log
@RestController
class ConsumerController {
    private final RestOperations restOperations;

    ConsumerController(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @GetMapping("/greet")
    public String getGreeting() {
        log.info("Logging GET request to /greet for " + this.getClass().toString());
        return restOperations.getForObject("http://localhost:8080/hi", String.class);
    }
}