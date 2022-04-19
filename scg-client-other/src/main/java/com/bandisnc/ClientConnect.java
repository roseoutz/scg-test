package com.bandisnc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1/other")
public class ClientConnect {

    @Value("${scg.client.main}")
    private String mainClient;

    @GetMapping("/{message}")
    public Mono<String> message(@PathVariable("message") String message) {
        return WebClient.create().get().uri(mainClient + "/get/" + message)
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/get/{message}")
    public String get(@PathVariable("message") String message) {
        return message;
    }
}
