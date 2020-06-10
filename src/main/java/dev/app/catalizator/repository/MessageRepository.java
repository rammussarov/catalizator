package dev.app.catalizator.repository;

import dev.app.catalizator.domain.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
