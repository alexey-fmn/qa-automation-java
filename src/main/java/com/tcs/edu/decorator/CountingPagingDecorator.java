package com.tcs.edu.decorator;

import java.util.ArrayList;

public class CountingPagingDecorator implements Decorator {

    static int MESSAGE_COUNTER = 0;


    public ArrayList<String> decorate(String[] messagesWithSeverity) {
        return CountingPagingDecorator.decorate(messagesWithSeverity, 2);
    }

    public static ArrayList<String> decorate(String[] messagesWithSeverity, int pageSize) {

        ArrayList<String> countingDecoratedMessages = new ArrayList<>();

        for (int i = messagesWithSeverity.length - 1, j = 0; i >= 0; i--, j++) {
            MESSAGE_COUNTER++;
            countingDecoratedMessages.add(MESSAGE_COUNTER + " " + messagesWithSeverity[i]);

            if (MESSAGE_COUNTER % pageSize == 0) {
                countingDecoratedMessages.add("---");
            }
        }
        return countingDecoratedMessages;
    }
}
