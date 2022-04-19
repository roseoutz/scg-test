package com.bandisnc.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TokenCheckFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return Mono.just(exchange.getRequest().getHeaders())
                .filter(httpHeaders -> httpHeaders.containsKey("Authorization"))
                .doOnNext(this::checkToken)
                .then();
    }

    private void checkToken(HttpHeaders httpHeaders) {
        httpHeaders
                .getOrEmpty("Authorization")
                .stream()
                .filter(value -> value.startsWith("Bearer"))
                .forEach(bearer -> {
                    String token = bearer.split(":")[1];
                    log.info(token);
                });
    }
}
