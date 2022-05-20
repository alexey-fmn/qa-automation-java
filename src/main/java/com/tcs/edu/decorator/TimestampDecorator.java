package com.tcs.edu.decorator;


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
     * Метод принимает на вход строку и возвращает строку, декорированную значением текуего времени
     *
     * @param message -- строка
     * @return -- строка + сообщение
     */
    @Override
    public String decorate(String message) {
        return String.format("%s %s", Instant.now(), message);
    }

}

