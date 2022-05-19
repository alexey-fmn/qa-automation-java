package com.tcs.edu.printer;

import java.util.ArrayList;

public interface Printer {

    //void print(String decoratedMessage);

    //void printMessages(String... messages);


    void print(ArrayList<String> messagesWithSeverity);
}
