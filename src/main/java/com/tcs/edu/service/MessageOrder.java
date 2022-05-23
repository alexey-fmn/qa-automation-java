package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Sorting;

public class MessageOrder extends ValidatedService {

    public Message[] sortMessages(Sorting messageOrder, Message... messages) {
        if (super.argsIsValid(messages)) {
            Message[] sortedMessages = new Message[messages.length];
            switch (messageOrder) {
                case ASC: {
                    return messages;
                }
                case DESC: {
                    for (int i = messages.length - 1, j = 0; i >= 0; i--, j++) {
                        sortedMessages[j] = messages[i];
                    }
                }
                break;
            }
            return sortedMessages;
        }
        return null;
    }
}
