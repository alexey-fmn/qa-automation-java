package com.tcs.edu.service;

import static com.tcs.edu.domain.Duplication.DOUBLES;

import com.tcs.edu.decorator.Decorator;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.domain.Duplication;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Sorting;
import com.tcs.edu.printer.Printer;
import com.tcs.edu.repository.HashMapMessageRepository;
import com.tcs.edu.repository.MessageRepository;
import java.util.Collection;
import java.util.UUID;

public class MessageService extends ValidatedService implements MessageRepository {


    private final Printer printService;
    private final MessageConcatenator concatenateService = new MessageConcatenator();
    private final MessageDuplication duplicateService = new MessageDuplication();
    private final MessageOrder sortService = new MessageOrder();

    private final Decorator[] decorators;
    private static final MessageRepository messageRepository = new HashMapMessageRepository();

    public MessageService(Printer printService, Decorator... decorators) {
        this.printService = printService;
        this.decorators = decorators;
    }


    public void log(Message message) {
        log(message, Sorting.ASC);
    }

    public void log(Message message, Sorting order) {
        log(message, order, DOUBLES);
    }

    public void log(Message message, Duplication doubling) {
        log(message, Sorting.ASC, doubling);
    }

    public void log(Message message, Sorting order, Duplication doubling) {
        log(message, order, doubling, new Message[]{});
    }

    public void log(Message message, Sorting messageOrder, Duplication doubling, Message... messages) {

        try {
            super.argsIsValid(messages);
            Message[] messageConcatenation = concatenateService.messageConcatenation(message, messages);
            Message[] sortedMessages = sortService.sortMessages(messageOrder, messageConcatenation);
            Message[] doublingMessages = duplicateService.messageDuplication(doubling, sortedMessages);

            for (Message doublingMessage : doublingMessages) {
                String result = doublingMessage.getBody();

                for (Decorator decorator : decorators) {
                    result = decorator.decorate(result);
                }

                result = new SeverityDecorator(message.getLevel()).decorate(result);
                printService.print(result);

            }
        } catch (IllegalArgumentException e) {
            throw new LogException("Wrong message arguments at MessageService!", e);
        }


    }


    @Override
    public UUID create(Message message) {
        System.out.println("message = " + message);
        return message.getId();
    }

    @Override
    public Message findByPrimaryKey(UUID key) {
        return messageRepository.findByPrimaryKey(key);
    }

    @Override
    public Collection<Message> findAll() {
        return messageRepository.findAll();
    }

    public UUID logMessageInMemory(Message message) {
        return messageRepository.create(message);
    }


}


