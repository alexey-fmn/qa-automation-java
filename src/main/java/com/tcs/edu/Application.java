package com.tcs.edu;

import static com.tcs.edu.decorator.SeverityLevel.MAJOR;
import static com.tcs.edu.decorator.SeverityLevel.MINOR;
import static com.tcs.edu.decorator.SeverityLevel.REGULAR;
import static com.tcs.edu.service.DistinctedMessageService.DISTINCT;
import static com.tcs.edu.service.DistinctedMessageService.DOUBLES;
import static com.tcs.edu.service.OrderedMessageService.ASC;
import static com.tcs.edu.service.OrderedMessageService.DESC;

import com.tcs.edu.domain.Message;
import com.tcs.edu.service.MessageService;

class Application {

    public static void main(String[] args) {

        Message message1 = new Message(MAJOR, "1");
        Message message2 = new Message(MAJOR, "22");
        Message message3 = new Message(MINOR, "333");
        Message message4 = new Message(REGULAR, "4444");
        Message message5 = new Message(MAJOR, "22");


        MessageService service = new MessageService();

        service.log(message1, "111");
        service.log(message2, "222");
        service.log(message3, ASC, DOUBLES, "222");
        service.log(message4, DESC, DISTINCT, "444", "4444");

        System.out.println(new Message(MINOR, "999"));
        System.out.println(message2.equals(message5));
        System.out.println(message3.equals(message5));

        System.out.println(message2.hashCode());
    }
}
