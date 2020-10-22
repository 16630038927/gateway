package com.example.gatewaycenten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient

public class GatewayCentenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayCentenApplication.class, args);
    }

    @Configuration
    class config{
        @Bean
        public KeyResolver uriKeyResolver(){
            return new KeyResolver() {
                @Override
                public Mono<String> resolve(ServerWebExchange exchange) {
                    return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
                }
            };
        }
    }


}
