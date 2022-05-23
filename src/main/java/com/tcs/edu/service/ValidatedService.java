package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

public class ValidatedService {

    protected boolean argsIsValid(Message message) {
        if (message.getLevel() == null || message.getBody() == null) {
            return false;
        }
        return true;
    }

    protected boolean argsIsValid(Message[] messages) {
        if (messages == null) {
            return false;
        }
        return true;
    }
}
