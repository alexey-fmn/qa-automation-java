package com.tcs.edu.service;

import static com.tcs.edu.domain.Duplication.DOUBLES;

import com.tcs.edu.decorator.Decorator;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.domain.Duplication;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Sorting;
import com.tcs.edu.printer.Printer;

public class MessageService {


    private final Printer printService;
    private final MessageConcatenator concatenateService = new MessageConcatenator();
    private final MessageDuplication duplicateService = new MessageDuplication();
    private final MessageOrder sortService = new MessageOrder();

    private final Decorator[] decorators;

    public MessageService(Printer printService, Decorator... decorators) {
        this.printService = printService;
        this.decorators = decorators;
    }


    /**
     * Метод для текста только с уровнем значимости и текстом сообщекния. По умолчанию добавляется прямой порядок
     * сортировки
     *
     * @param message строка и уровнель значимости, передается единым сообщением
     * @param messages остальной текст
     */
    public void log(Message message, String... messages) {
        log(message, Sorting.ASC, messages);
    }

    /**
     * Метод для сообщений с порядком сортировки. По умоляанию добавялется ворядок сортировки сообщений
     *
     * @param message строка и уровнель значимости, передается единым сообщением
     * @param order порядок сортировки сообщений
     * @param messages остальной текст
     */
    public void log(Message message, Sorting order, String... messages) {
        log(message, order, DOUBLES, messages);
    }

    /**
     * Метод для сообщений со всем и параметрами
     *
     * @param message строка и уровнель значимости, передается единым сообщением
     * @param messageOrder порядок сортировки сообщений
     * @param doubling режим печати сообщений. С дублированием и без
     * @param messages остальной текст
     */

    public void log(Message message, Sorting messageOrder, Duplication doubling, String... messages) {

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
    }
}
