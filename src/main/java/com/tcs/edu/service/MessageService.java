package com.tcs.edu.service;

import static com.tcs.edu.domain.Doubling.DOUBLES;

import com.tcs.edu.decorator.CountingPagingDecorator;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.TimestampDecorator;
import com.tcs.edu.domain.Doubling;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Sorting;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.printer.Printer;
import java.util.ArrayList;

public class MessageService {

    final Printer printer = new ConsolePrinter();
    private final MessageConcatenator messageConcatenator = new MessageConcatenator();

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

    public void log(Message message, Sorting messageOrder, Doubling doubling, String... messages) {
        String[] messageConcatenation = messageConcatenator.messageConcatenation(message, messages);
        String[] sortedMessages = MessageOrder.sortMessages(messageOrder, messageConcatenation);
        String[] doublingMessages = MessageDuplication.messageDuplication(doubling, sortedMessages);
        String[] messagesWithTimestamp = TimestampDecorator.decorate(doublingMessages);
        String[] messagesWithSeverity = SeverityDecorator.decorate(message.getLevel(), messagesWithTimestamp);
        ArrayList<String> countingPagingMessages = CountingPagingDecorator.decorate(messagesWithSeverity);

        printer.print(countingPagingMessages);
        //printer.printMessages(countingPagingMessages);
    }

//        String[] messagesWithTimestamp = TimestampDecorator.decorate(messageConcatenation);
//        String[] messagesWithSeverity = SeverityDecorator.decorate(message.getLevel(), messagesWithTimestamp);
//        String[] duplicatedMessages = MessageDuplication.messageDuplication(doubling, messagesWithSeverity);
//        String[] sortedMessages = MessageOrder.sortMessages(messageOrder, duplicatedMessages);
//        printer.printMessages(sortedMessages);

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
}
