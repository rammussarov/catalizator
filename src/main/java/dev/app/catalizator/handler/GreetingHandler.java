package dev.app.catalizator.handler;

import dev.app.catalizator.domain.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        final Long start = request.queryParam("start").map(Long::valueOf).orElse(0L);
        final Long count = request.queryParam("count").map(Long::valueOf).orElse(3L);

        final Flux<Message> messages = Flux
                .just(
                        "Message one",
                        "Message two",
                        "Message three",
                        "Message four"
                )
                .skip(start)
                .take(count)
                .map(Message::new);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(messages, Message.class);
    }

    public Mono<ServerResponse> user(ServerRequest serverRequest) {
        final String user = serverRequest.queryParam("user").orElse("User");

        return ServerResponse
                .ok()
                .render("index", Map.of("user", user));
    }
}