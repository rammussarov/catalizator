package dev.app.catalizator.controller;

import dev.app.catalizator.domain.Message;
import dev.app.catalizator.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor
public class MainController {
    private final MessageService messageService;

    @GetMapping
    public Flux<Message> findAll() {
        return messageService.findAll();
    }

    @PostMapping
    public Mono<Message> save(@RequestBody Message message) {
        return messageService.addOne(message);
    }
}
