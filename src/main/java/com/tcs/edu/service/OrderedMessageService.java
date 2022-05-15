package com.tcs.edu.service;

/**
 * ASC -- сортировка по возрастанию DESC -- сортировка по убыванию
 */

public enum OrderedMessageService {
    ASC, DESC;

    /**
     * Сортировка сообщений
     *
     * @param messages сообщения
     * @return сообщения в нужном порядке
     */

    public String[] sortMessages(String... messages) {
        if (messages != null) {
            String[] sortedMessages = new String[messages.length];
            switch (this) {
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
