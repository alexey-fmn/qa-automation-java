package com.tcs.edu.printer;

import com.tcs.edu.decorator.Decorator;
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

    //private final Decorator decorator = new TimestampDecorator();

    @Override
    public void print(String message) {

        System.out.println(message);
    }

    /**
     * Метод занимается отправкой на печать строки и серьезности, увеличением счетчика страниц и добавлением разделителя
     * страниц Принимает на вход сообщение и степерь серьзности
     *
     * @param message сообщение
     */
    private void printMessage(String message) {
        if (message != null) {


            print(message);
            messageCount++;

            if (messageCount % PAGE_SIZE == 0) {
                print("---");
            }

        }
    }


    /**
     * Печатаем остальные сообщения, которые переданы
     * @param messages остальные сообщения
     */

    @Override
    public void printMessages(String... messages) {
        if (messages != null) {
            for (String current : messages) {
                ConsolePrinter printer = new ConsolePrinter();
                printer.printMessage(current);
            }
        }
    }
}
