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
     * Метод печатает строку через System.out.println
     */


    public void print(ArrayList<String> messages) {
        if (messages != null) {
            for (String message : messages) {
                System.out.println(message);

            }
        }
    }
}

