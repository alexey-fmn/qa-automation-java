package com.tcs.edu.decorator;

import static com.tcs.edu.printer.ConsolePrinter.messageCount;

import java.time.Instant;

/**
 * TimestampMessageDecorator работает со строками
 * <p>
 * Этот класс доабвляет счетчик сообщений и значение текущего времени к сообщению
 *
 * @author Alexey Fomin
 */
public class TimestampDecorator implements Decorator {

    /**
     * Метод доабвляет счетчик и текущее время
     * <p>
     * This class add now time before any message and messageCount counter before text
     *
     * @param messages -- текст для печати
     * @return Строка со счетчиком, текущем временем с переданной строкой message
     */
    public static String[] decorate(String... messages) {

        String[] timestampedMessages = new String[messages.length];

        for (int i = messages.length - 1, j = 0; i >= 0; i--, j++) {
            String timestampedMessage = String.format("%d %s %s", messageCount, Instant.now(), messages[i]);
            timestampedMessages[j] = timestampedMessage;
        }
        return timestampedMessages;
    }

}

