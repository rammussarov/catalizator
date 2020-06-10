package dev.app.catalizator.service;

import dev.app.catalizator.domain.Message;
import dev.app.catalizator.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Flux<Message> findAll() {
        return messageRepository.findAll();
    }

    public Mono<Message> addOne(Message message) {
        return messageRepository.save(message);
    }
}
