package com.tcs.edu.decorator;

import java.util.ArrayList;

public class CountingPagingDecorator {

    static int PAGE_SIZE = 2;
    static int MESSAGE_COUNTER = 0;

    public static ArrayList<String> decorate(String[] messagesWithSeverity) {

        //String[] countingDecoratedMessages = new String[messagesWithSeverity.length + (messagesWithSeverity.length / 2)];
        ArrayList<String> countingDecoratedMessages = new ArrayList<>();

        for (int i = messagesWithSeverity.length - 1, j = 0; i >= 0; i--, j++) {
            MESSAGE_COUNTER++;

            countingDecoratedMessages.add(MESSAGE_COUNTER + " " + messagesWithSeverity[i]);
            if (MESSAGE_COUNTER % PAGE_SIZE == 0) {
                countingDecoratedMessages.add("---");
            }

//            countingDecoratedMessages[j] = MESSAGE_COUNTER + " " + messagesWithSeverity[i];
//
//            if (MESSAGE_COUNTER % PAGE_SIZE == 0) {
//                countingDecoratedMessages[j + 1] = "---";
//            }
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
