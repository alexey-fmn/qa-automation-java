package com.tcs.edu.decorator;

import static com.tcs.edu.printer.ConsolePrinter.messageCount;

import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.printer.Printer;
import java.time.Instant;

public class CountingPagingDecorator {

    int PAGE_SIZE = 2;
    static int MESSAGE_COUNTER = 0;

    public static String[] decorate(String[] messagesWithSeverity) {

        String[] countingDecoratedMessages = new String[messagesWithSeverity.length];

        for (int i = messagesWithSeverity.length - 1, j = 0; i >= 0; i--, j++) {

            countingDecoratedMessages[j] = messagesWithSeverity[i];
        }

//        if (MESSAGE_COUNTER % 2 == 0) {
//            MESSAGE_COUNTER++;
//            return messagesWithSeverity;
//        } else {
//            return new String[]{("---------")};
//        }

        //return messagesWithSeverity;
        return countingDecoratedMessages;
    }
}
