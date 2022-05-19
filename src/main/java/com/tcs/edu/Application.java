package com.tcs.edu;

import static com.tcs.edu.decorator.SeverityLevel.MAJOR;
import static com.tcs.edu.decorator.SeverityLevel.MINOR;
import static com.tcs.edu.domain.Doubling.DISTINCT;
import static com.tcs.edu.domain.Doubling.DOUBLES;
import static com.tcs.edu.domain.Sorting.ASC;
import static com.tcs.edu.domain.Sorting.DESC;

import com.tcs.edu.domain.Message;
import com.tcs.edu.service.MessageService;

class Application {

    public static void main(String[] args) {

        Message message1 = new Message(MAJOR, "message 1");
        Message message2 = new Message(MAJOR, "message 2");
        Message message3 = new Message(MINOR, "message 3");
        Message message4 = new Message(MAJOR, "message 4");

        MessageService service = new MessageService();

        service.log(message1, "added message 1");
        service.log(message2, "added message 2");
        service.log(message3, ASC, DOUBLES, "added message 3");
        service.log(message4, DESC, DISTINCT, "added message 4", "added message 4");
    }
}
