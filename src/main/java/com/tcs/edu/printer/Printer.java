package com.tcs.edu.printer;

import com.tcs.edu.domain.SeverityLevel;

public interface Printer {

    void print(String decoratedMessage);

    void printMessages(SeverityLevel level, String... messages);


}
