package com.tcs.edu.service;


import com.tcs.edu.domain.Message;
import java.util.stream.Stream;

public class MessageConcatenator {

    public Message[] messageConcatenation(Message message, String... messages) {
        try {
            return Stream.concat(Stream.of(message), Stream.of(messages)).toArray(Message[]::new);
        } catch (IllegalArgumentException e) {
            throw new LogException("Wrong args!", e);
        }
        //return Stream.concat(Stream.of(message), Stream.of(messages)).toArray(Message[]::new);
    }
}
