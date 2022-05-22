package com.tcs.edu;

import static com.tcs.edu.decorator.SeverityLevel.MAJOR;
import static com.tcs.edu.decorator.SeverityLevel.MINOR;
import static com.tcs.edu.decorator.SeverityLevel.REGULAR;
import static com.tcs.edu.domain.Duplication.DISTINCT;
import static com.tcs.edu.domain.Duplication.DOUBLES;
import static com.tcs.edu.domain.Sorting.ASC;

import com.tcs.edu.decorator.CountingPagingDecorator;
import com.tcs.edu.decorator.TimestampDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.service.MessageService;

class Application {

    static MessageService service = new MessageService(
        new ConsolePrinter(),
        new CountingPagingDecorator(),
        new TimestampDecorator()
    );

    public static void main(String[] args) {

        Message message1 = new Message(MINOR, "message 1");

        Message message2 = new Message(REGULAR, "message 2");
        Message message3 = new Message(MAJOR, "message 3");
        Message message4 = new Message(MAJOR, "4");
        Message message5 = new Message(REGULAR, "message 2");
        Message message6 = new Message(MINOR, "999");

        service.log(message1, "added message 1");
        service.log(message2, "added message 4");
        service.log(message3, ASC, DOUBLES, "message 1");
        service.log(message4, ASC, DISTINCT, "3", "2", "1");

        System.out.println(message6);
        System.out.println(message2.equals(message5));
        System.out.println(message3.equals(message5));

        System.out.println(message2.hashCode());
    }
}
