package com.tcs.edu;

import static com.tcs.edu.decorator.SeverityLevel.MAJOR;
import static com.tcs.edu.decorator.SeverityLevel.MINOR;
import static com.tcs.edu.decorator.SeverityLevel.REGULAR;
import static com.tcs.edu.domain.Duplication.DISTINCT;
import static com.tcs.edu.domain.Duplication.DOUBLES;
import static com.tcs.edu.domain.Sorting.ASC;

import com.tcs.edu.domain.Message;
import com.tcs.edu.service.MessageService;

class Application {

    public static void main(String[] args) {

        Message message1 = new Message(MINOR, "message 1");
        Message message2 = new Message(REGULAR, "message 2");
        Message message3 = new Message(MAJOR, "message 3");
        Message message4 = new Message(MAJOR, "4");

        MessageService service = new MessageService();

        service.log(message1, "added message 1");
        service.log(message2, "added message 4");
        service.log(message3, ASC, DOUBLES, "message 1");
        service.log(message4, ASC, DISTINCT, "3", "2", "1");
    }
}
