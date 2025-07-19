package org.apigateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalHeaderFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerWebExchange modifiedExchange = exchange.mutate()
                .request(request -> request.headers(headers -> headers.add("X-GATEWAY-KEY", "explore-secure")))
                .build();
        return chain.filter(modifiedExchange);
    }
}

