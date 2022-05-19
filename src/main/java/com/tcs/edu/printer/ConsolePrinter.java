package com.tcs.edu.printer;

import java.util.ArrayList;

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


    public void print(ArrayList<String> messages) {
        if (messages != null) {
            for (String message : messages) {
                System.out.println(message);

            }
        }
    }
}

