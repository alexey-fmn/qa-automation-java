package com.tcs.edu.service;public class MessageDuplication{private static java.lang.String[] MessageDuplication(com.tcs.edu.domain.Doubling doubling, java.lang.String... messages) {
        if (messages != null) {
            java.lang.String[] refactorMessages = new java.lang.String[messages.length];
            switch (doubling) {
                case DOUBLES : {
                    refactorMessages =  messages;
                }
                break;
                case DISTINCT: {
                    refactorMessages = new java.lang.String[messages.length];
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
    }private static boolean isMessageInArray(java.lang.String message, java.lang.String... array) {
        boolean isMessageInArray = false;
        if (array != null) {
            for (java.lang.String messageArray : array) {
                if (messageArray != null && messageArray.equals(message)) {
                    isMessageInArray = true;
                    break;
                }
            }
        }
        return isMessageInArray;
    }}
