package com.tcs.edu.service;

/**
 * DOUBLES -- вывод с дублированием DISTINCT -- вывод без дублирования DEFAUTL -- вывод с дублированием
 */

public enum DistinctedMessageService {
    DOUBLES, DISTINCT, DEFAULT;

    /**
     * Обрабатываем сообщения в зависимости от характера дублирования
     *
     * @param messages сообщения
     * @return сообщения после обработки
     */

    public String[] setDoublingType(String... messages) {
        if (messages != null) {
            String[] refactorMessages = new String[messages.length];
            switch (this) {
                case DOUBLES:
                case DEFAULT: {
                    refactorMessages = messages;
                }
                break;
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

    /**
     * Ищем сообщение в массиве
     *
     * @param message сообщение, которое ищем в массиве
     * @param array массив для поиска
     * @return true/false
     */
    public boolean isMessageInArray(String message, String... array) {
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
