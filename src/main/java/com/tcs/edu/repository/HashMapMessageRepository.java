package com.tcs.edu.repository;

import com.tcs.edu.decorator.SeverityLevel;
import com.tcs.edu.domain.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class HashMapMessageRepository implements MessageRepository {

    private final Map<UUID, Message> messages = new HashMap<>();

    @Override
    public UUID create(Message message) {
        UUID uuid = UUID.randomUUID();
        messages.put(uuid, message);
        message.setId(uuid);
        return uuid;
    }

    @Override
    public Message findByPrimaryKey(UUID key) {
        return messages.get(key);
    }

    @Override
    public Collection<Message> findAll() {
        return messages.values();
    }

    @Override
    public Collection<Message> findBySeverityIter(SeverityLevel by) {
        Collection<Message> filteredMessages = new ArrayList<>();
        for (Message current : messages.values()) {
            if (current.getLevel() == by) {
                filteredMessages.add(current);
            }
        }
        return filteredMessages;
    }

    @Override
    public Collection<Message> findBySeverityDecl(SeverityLevel by) {
        return messages
            .values()
            .stream()
            .filter(message -> message.getLevel() == by)
            .collect(Collectors.toList());
    }

}
