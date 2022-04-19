package com.bandisnc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/main")
public class ClientOtherConnect {

    @Value("${scg.client.other}")
    private String otherClient;

    @GetMapping("/{message}")
    public Mono<String> message(@PathVariable("message") String message) {
        return WebClient.create().get().uri(otherClient + "/get/" + message)
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/get/{message}")
    public String get(@PathVariable("message") String message) {
        return message;
    }
}
