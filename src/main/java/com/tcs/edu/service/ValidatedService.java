package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

public class ValidatedService {

    protected void argsIsValid(Message message) {
        if (message.getLevel() == null || message.getBody() == null) {
            throw new IllegalArgumentException("Message argument is null!");
        }
    }

    protected void argsIsValid(Message[] messages) {
        if (messages == null) {
            throw new IllegalArgumentException("Messages argument is null!");
        }
    }
}
