package com.tcs.edu.decorator;

import static com.tcs.edu.printer.ConsolePrinter.messageCount;

import com.tcs.edu.domain.SeverityLevel;
import java.time.Instant;

/**
 * TimestampMessageDecorator работает со строками
 * <p>
 * Этот класс доабвляет счетчик сообщений и значение текущего времени к сообщению
 *
 * @author Alexey Fomin
 */
public class TimestampMessageDecorator implements Decorator {

    /**
     * Метод доабвляет счетчик и текущее время
     * <p>
     * This class add now time before any message and messageCount counter before text
     *
     * @param message -- текст для печати
     * @return Строка со счетчиком, текущем временем с переданной строкой message
     */
    public String decorate(String message) {
        return String.format("%d %s %s", messageCount, Instant.now(), message);
    }

}
