package com.tcs.edu.service;

import com.tcs.edu.domain.Duplication;

public class MessageDuplication {

    public String[] messageDuplication(Duplication doubling, String... messages) {
        if (messages != null) {
            String[] refactorMessages = new String[messages.length];
            switch (doubling) {
                case DOUBLES: {
                    return messages;
                }
                case DISTINCT: {
                    refactorMessages = new String[messages.length];
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

    static boolean isMessageInArray(String message, String... array) {
        boolean isMessageInArray = false;
        if (array != null) {
            for (String messageArray : array) {
                if (messageArray != null && messageArray.equals(message)) {
                    isMessageInArray = true;
                    break;
                }
            }
        }
        return isMessageInArray;
    }
}
