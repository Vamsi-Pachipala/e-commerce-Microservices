package com.example.gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
	@Bean
	public RouteLocator eCommerceRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/vcommerce/order-service/**")
						.filters( f -> f.rewritePath("vcommerce/order-service(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://order-service"))
				.route(p-> p.path("/vcommerce/product-service/**")
						.filters( f -> f.rewritePath("vcommerce/product-service(?<segment>.*)","/${segment}")
								.circuitBreaker(config -> config.setName("gatewayservercircuitbreaker")
								.setFallbackUri("forward:/fallback/product"))
						.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://product-service")).build();
	}

}
