package dev.app.catalizator.router;

import dev.app.catalizator.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {

        return RouterFunctions
                .route(
                        RequestPredicates
                                .GET("/hello")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        greetingHandler::hello
                )
                .andRoute(RequestPredicates.GET("/"), greetingHandler::user);
    }
}