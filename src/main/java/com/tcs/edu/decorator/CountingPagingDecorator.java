package com.tcs.edu.decorator;

import java.util.ArrayList;

public class CountingPagingDecorator implements Decorator {

    int PAGE_SIZE = 2;
    int MESSAGE_COUNTER = 0;

    public ArrayList<String> decorate(String[] messagesWithSeverity) {

        ArrayList<String> countingDecoratedMessages = new ArrayList<>();

        for (int i = messagesWithSeverity.length - 1, j = 0; i >= 0; i--, j++) {
            MESSAGE_COUNTER++;
            countingDecoratedMessages.add(MESSAGE_COUNTER + " " + messagesWithSeverity[i]);

            if (MESSAGE_COUNTER % PAGE_SIZE == 0) {
                countingDecoratedMessages.add("---");
            }
        }
        return countingDecoratedMessages;
    }
}
