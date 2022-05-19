package com.tcs.edu.service;public class MessageOrder{private static java.lang.String[] sortMessages(com.tcs.edu.service.OrderedMessageService messageOrder, java.lang.String... messages) {
        if (messages != null) {
            java.lang.String[] sortedMessages = new java.lang.String[messages.length];
            switch (messageOrder) {
                case ASC: {
                    for (int i = 0; i <= messages.length - 1; i++) {
                        sortedMessages[i] = messages[i];
                    }
                    break;
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
    }}
