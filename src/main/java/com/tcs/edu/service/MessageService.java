package com.tcs.edu.service;

import static com.tcs.edu.domain.Duplication.DOUBLES;

import com.tcs.edu.decorator.CountingPagingDecorator;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.TimestampDecorator;
import com.tcs.edu.domain.Duplication;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Sorting;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.printer.Printer;
import java.util.ArrayList;

public class MessageService {

    private final Printer printService = new ConsolePrinter();
    private final MessageConcatenator concatenateService = new MessageConcatenator();
    private final MessageOrder sortService = new MessageOrder();
    private final MessageDuplication duplicateService = new MessageDuplication();
    private final TimestampDecorator timestampService = new TimestampDecorator();
    private final SeverityDecorator severityService = new SeverityDecorator();
    private final CountingPagingDecorator counterPageService = new CountingPagingDecorator();

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

        String[] messageConcatenation = concatenateService.messageConcatenation(message, messages);
        String[] sortedMessages = sortService.sortMessages(messageOrder, messageConcatenation);
        String[] doublingMessages = duplicateService.messageDuplication(doubling, sortedMessages);
        String[] messagesWithTimestamp = timestampService.decorate(doublingMessages);
        String[] messagesWithSeverity = severityService.decorate(message.getLevel(), messagesWithTimestamp);
        ArrayList<String> countingPagingMessages = counterPageService.decorate(messagesWithSeverity);

        printService.print(countingPagingMessages);
    }
}

// Сначала порядок, потом дубли, потом декорирования, потом вывод в консоль

//    MessageService - конструируемый сервис. В конструктор передаем Printer ( будет печатать готовые сообщения), а также vararg Decorator... decorators.
//    Декораторы по очереди правят сообщение, а в конце принтер его выводит.
//
//    Возможные декораторы:
//
//    SeverityDecorator - тут все просто
//    TimestampDecorator - тут тоже
//    CountingPagingDecorator - тут похитрее.
//    Этот декоратор должен взять на себя ответственность за нумерацию и биение по страницам.
//    Предлагаю в качестве аргумента конструктора CountingPagingDecorator передавать int pageSize.
//    С помощью паттерна "телескопический конструктор" задать дефолтное значение pageSize = 2.
//    Счетчик выведенных сообщений должен перестать быть статическим, а начать относиться к конкретному декоратору
