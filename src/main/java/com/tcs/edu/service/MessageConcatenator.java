package com.tcs.edu.service;


import com.tcs.edu.domain.Message;
import java.util.stream.Stream;

public class MessageConcatenator extends ValidatedService {

    public Message[] messageConcatenation(Message message, Message... messages) {
        try {
            super.argsIsValid(message);
            return Stream.concat(Stream.of(message), Stream.of(messages)).toArray(Message[]::new);
        } catch (IllegalArgumentException e) {
            throw new LogException("Wrong message arguments!", e);
        }
    }
}
