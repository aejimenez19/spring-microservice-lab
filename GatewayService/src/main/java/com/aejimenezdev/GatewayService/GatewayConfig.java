package com.aejimenezdev.GatewayService;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route( r -> r
                        .path("/serviceB/**")
                        .uri("lb://ServiceB"))
                .route(r -> r
                        .path("/serviceA/**")
                        .uri("lb://ServiceA"))
                .build();
    }
}
