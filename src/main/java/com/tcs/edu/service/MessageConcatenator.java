package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import java.util.stream.Stream;

public class MessageConcatenator {

    public String[] messageConcatenation(Message message, String... messages) {
        return Stream.concat(Stream.of(message.getBody()), Stream.of(messages)).toArray(String[]::new);

    }
}
