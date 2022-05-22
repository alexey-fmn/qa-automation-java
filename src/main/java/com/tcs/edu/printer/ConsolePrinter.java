package com.tcs.edu.printer;

import com.tcs.edu.service.LogException;
import com.tcs.edu.service.ValidatedService;
import javax.security.auth.login.LoginException;

/**
 * ConsolePrinter печатает сообщение в консоль
 * <p>
 *
 * @author Alexey Fomin
 */
public class ConsolePrinter extends ValidatedService implements Printer {

    /**
     * Метод проверяет строку на валидность и печатает строку через System.out.println
     */


    @Override
    public void print(String message) {
        try {
            super.argsIsValid(message);
        } catch (IllegalArgumentException e ) {
            throw new LogException("Wrong args!", e);
        }

    }
}

