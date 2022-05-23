package com.tcs.edu.printer;

import com.tcs.edu.service.LogException;
import com.tcs.edu.service.ValidatedService;

/**
 * ConsolePrinter печатает сообщение в консоль
 * <p>
 *
 * @author Alexey Fomin
 */
public class ConsolePrinter implements Printer {

    /**
     * Метод проверяет строку на валидность и печатает строку через System.out.println
     */


    @Override
    public void print(String message) {
            System.out.println(message);
    }
}

