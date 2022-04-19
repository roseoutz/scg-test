package com.bandisnc.config;

import com.bandisnc.security.filter.TokenCheckFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {

    @Autowired
    private TokenCheckFilter tokenCheckFilter;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity security) {
        return security
                .cors().disable()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeExchange(authorizeExchangeSpec ->
                    authorizeExchangeSpec.pathMatchers("/api/**")
                            .permitAll()
                            .anyExchange()
                            .authenticated())
                .addFilterAt(tokenCheckFilter, SecurityWebFiltersOrder.HTTP_BASIC)
                .build();

    }
}
