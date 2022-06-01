package com.tcs.edu.service;

import com.tcs.edu.domain.Duplication;
import com.tcs.edu.domain.Message;

public class MessageDuplication extends ValidatedService {

    public Message[] messageDuplication(Duplication doubling, Message... messages) {

        try {
            super.argsIsValid(messages);
            Message[] refactorMessages = new Message[messages.length];
            switch (doubling) {
                case DOUBLES: {
                    return messages;
                }
                case DISTINCT: {
                    refactorMessages = new Message[messages.length];
                    for (int i = 0; i <= messages.length - 1; i++) {
                        if (!isMessageInArray(messages[i], refactorMessages)) {
                            refactorMessages[i] = messages[i];
                        }
                    }
                }
                break;
            }
            return refactorMessages;
        } catch (IllegalArgumentException e) {
            throw new LogException("Wrong message arguments at messageDuplication!", e);
        }

    }

    public boolean isMessageInArray(Message message, Message... messages) {
        boolean isMessageInArray = false;
        try {
            super.argsIsValid(message);
            for (Message messageArray : messages) {
                if (messageArray != null && messageArray.getBody().equals(message.getBody())) {
                    isMessageInArray = true;
                    break;
                }
            }
            return isMessageInArray;
        } catch (IllegalArgumentException e) {
            throw new LogException("Wrong message arguments at MessageDuplication!", e);
        }
    }
}
