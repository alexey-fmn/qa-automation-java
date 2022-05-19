package com.tcs.edu.printer;

import com.tcs.edu.decorator.Decorator;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.domain.SeverityLevel;
import com.tcs.edu.decorator.TimestampDecorator;

/**
 * ConsolePrinter печатает сообщение в консоль
 * <p>
 *
 * @author Alexey Fomin
 */
public class ConsolePrinter implements Printer {

    /**
     * Класс склеивает строку в итогове сообщение Умеет работать с любым количеством агрументов через varargs
     */

    private static final int PAGE_SIZE = 2;
    public static int messageCount = 0;

    private final Decorator decorator = new TimestampDecorator();

    /**
     * @param message -- сообщение для печати
     * @param postfix -- декоратор для печати
     */
    public void print(String message, String postfix) {
        System.out.printf("%s %s%n", message, postfix);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    /**
     * Метод занимается отправкой на печать строки и серьезности, увеличением счетчика страниц и добавлением разделителя
     * страниц Принимает на вход сообщение и степерь серьзности
     *
     * @param severity серьезность
     * @param message сообщение
     */
    private void printMessage(SeverityLevel severity, String message) {
        if (message != null) {

            messageCount++;

            final String postfix = new SeverityDecorator().decorate(severity);
            //final String decoratedMessage = decorator.decorate(message);

            //print(decoratedMessage, postfix);
            print(message, postfix);

            if (messageCount % PAGE_SIZE == 0) {
                print("---");
            }
        }
    }


    /**
     * Печатаем остальные сообщения, которые переданы
     *
     * @param severity серьезность
     * @param messages остальные сообщения
     */

    @Override
    public void printMessages(SeverityLevel severity, String... messages) {
        if (messages != null) {
            for (String current : messages) {
                ConsolePrinter printer = new ConsolePrinter();
                printer.printMessage(severity, current);
            }
        }
    }
}
