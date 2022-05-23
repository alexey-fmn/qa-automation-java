package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Sorting;

public class MessageOrder {

    public Message[] sortMessages(Sorting messageOrder, Message... messages) {
        if (messages != null) {
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
        } else {
            return null;
        }
    }
}
