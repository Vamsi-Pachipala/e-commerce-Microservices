package com.example.gateway_server.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec
                        .pathMatchers(HttpMethod.GET).permitAll()
                        .pathMatchers(HttpMethod.POST).permitAll())
//                        .pathMatchers("/vcommerce/product-service/**").authenticated()
//                        .pathMatchers("/vcommerce/order-service/**").authenticated()
//                        .pathMatchers("/vcommerce/user-service/**").authenticated())
//                        .oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec.jwt(Customizer.withDefaults()))
                .csrf(ServerHttpSecurity.CsrfSpec::disable);

        return serverHttpSecurity.build();
    }
}
 /*   In the provided SecurityConfig class, the securityWebFilterChain method is a bean configuration method that defines the security filter chain for your Spring WebFlux application. Here's a detailed explanation of how it works and who calls the method:

        Explanation of the Security Configuration
        Class and Method Annotations:

@EnableWebFluxSecurity: This annotation enables Spring Security's WebFlux support and provides integration with Spring WebFlux.
@Configuration: This annotation indicates that the class is a source of bean definitions for the application context.
        Bean Method:

        The method securityWebFilterChain is annotated with @Bean, which makes it a bean definition method. Spring will automatically call this method during the application context initialization to create and register a SecurityWebFilterChain bean.
        Method Parameter:

        The parameter ServerHttpSecurity serverHttpSecurity is automatically provided by Spring. Spring Security's auto-configuration provides an instance of ServerHttpSecurity that is used to customize the security filter chain.
        Detailed Steps of Invocation
        Auto-Configuration:

        When your Spring Boot application starts, the auto-configuration mechanism of Spring Boot kicks in. Spring Security's auto-configuration class is responsible for setting up the necessary beans and components for security.
        Bean Creation:

        During the creation of the application context, Spring looks for methods annotated with @Bean. It finds the securityWebFilterChain method in your SecurityConfig class.
        Dependency Injection:

        Spring sees that the securityWebFilterChain method requires a ServerHttpSecurity parameter. Since ServerHttpSecurity is a part of Spring Security's infrastructure, Spring Security provides an instance of it.
        Method Invocation:

        Spring calls the securityWebFilterChain method, passing the ServerHttpSecurity instance as an argument. The method configures the security settings and returns a SecurityWebFilterChain object.
        Bean Registration:

        The returned SecurityWebFilterChain object is registered as a bean in the application context. This bean defines the security filter chain that will be applied to incoming HTTP requests.
        Security Configuration Logic
        authorizeExchange:

        authorizeExchangeSpec.pathMatchers(HttpMethod.GET).permitAll(): Allows all GET requests.
        authorizeExchangeSpec.pathMatchers(HttpMethod.POST).permitAll(): Allows all POST requests.
        The commented-out lines show how you could restrict access to certain paths and require authentication.
        CSRF Protection:

        serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable): Disables CSRF protection. This might be necessary for certain types of applications, but be cautious with this setting as it can make your application vulnerable to CSRF attacks.
        Summary
        The securityWebFilterChain method is a bean definition method that Spring calls during application context initialization.
        Spring Security provides the ServerHttpSecurity instance automatically.
        The method configures the security filter chain and registers it as a bean in the application context.
        By following this process, Spring Security integrates seamlessly with your WebFlux application, applying the security rules defined in the SecurityWebFilterChain bean.*/