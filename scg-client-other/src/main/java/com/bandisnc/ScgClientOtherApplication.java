package com.bandisnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@EnableEurekaClient
@SpringBootApplication
public class ScgClientOtherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScgClientOtherApplication.class, args);
    }

}
