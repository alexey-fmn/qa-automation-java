package com.tcs.edu.service;

import com.tcs.edu.domain.Duplication;
import com.tcs.edu.domain.Message;

public class MessageDuplication {

    public Message[] messageDuplication(Duplication doubling, Message... messages) {
        if (messages != null) {
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
        }
        return null;
    }

    static boolean isMessageInArray(Message message, Message... array) {
        boolean isMessageInArray = false;
        if (array != null) {
            for (Message messageArray : array) {
                if (messageArray != null && messageArray.getBody().equals(message.getBody())) {
                    isMessageInArray = true;
                    break;
                }
            }
        }
        return isMessageInArray;
    }
}
