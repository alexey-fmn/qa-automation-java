package com.tcs.edu;

import com.tcs.edu.decorator.CountingPagingDecorator;
import com.tcs.edu.decorator.SeverityLevel;
import com.tcs.edu.decorator.TimestampDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.service.MessageService;
import java.util.Collection;
import java.util.UUID;

class Application {

    static MessageService service = new MessageService(new ConsolePrinter(), new CountingPagingDecorator(),
        new TimestampDecorator());

    public static void main(String[] args) {

        //Message mess1 = new Message(MAJOR, "111");
        //Message mess2 = new Message(REGULAR, "222");
//        Message mess3 = new Message(MAJOR, "333");
//        Message mess4 = new Message(MAJOR, "444");
//        Message mess5 = new Message(REGULAR, "message 2");
//
//        service.log(mess1);
//        service.log(mess2, ASC);
//        service.log(mess3, DISTINCT);
//        service.log(mess4, ASC, DISTINCT);
//        service.log(mess5, ASC, DISTINCT);
//
//        System.out.println("=======");
//
//        System.out.println(mess5);
//        System.out.println(mess2.equals(mess5));
//        System.out.println(mess3.equals(mess5));
//
//        System.out.println(mess2.hashCode());

        Message mess0 = new Message("message 0");
        Message mess99 = new Message(SeverityLevel.MINOR, "message 99");

        final UUID generatedKey = service.logMessageInMemory(mess0);
        System.out.println("Message with key " + generatedKey + " is " + service.findByPrimaryKey(generatedKey));

        service.logMessageInMemory(mess99);
        final Collection<Message> allMessages = service.findAll();

        for (Message current : allMessages) {
            System.out.println(current);
        }
    }
}
