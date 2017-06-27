package com.example.szproviderservice;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SzProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SzProviderServiceApplication.class, args);
    }
}

@Log
@RestController
class ProviderController {
    @GetMapping("/hi")
    public String sayHello() {
        log.info("Logging GET request to /hi");
        return "Hello there!";
    }
}