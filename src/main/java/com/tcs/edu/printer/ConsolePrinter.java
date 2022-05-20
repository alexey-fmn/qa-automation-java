package com.tcs.edu.printer;

import com.tcs.edu.service.ValidatedService;
import java.util.ArrayList;

/**
 * ConsolePrinter печатает сообщение в консоль
 * <p>
 *
 * @author Alexey Fomin
 */
public class ConsolePrinter extends ValidatedService implements Printer {

    /**
     * Метод печатает строку через System.out.println
     */


    public void print(ArrayList<String> messages) {
        if (messages != null && super.argsIsValid(messages)) {
            for (String message : messages) {
                System.out.println(message);

            }
        }
    }
}

