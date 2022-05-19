package com.tcs.edu.service;

import com.tcs.edu.domain.Sorting;

public class MessageOrder {

    static String[] sortMessages(Sorting messageOrder, String... messages) {
        if (messages != null) {
            String[] sortedMessages = new String[messages.length];
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
