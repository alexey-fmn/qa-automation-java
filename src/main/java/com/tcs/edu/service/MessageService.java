package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.printer.Printer;
import java.util.stream.Stream;

public class MessageService {

    final Printer printer = new ConsolePrinter();

    /**
     * Метод для текста только с уровнем значимости и текстом сообщекния. По умолчанию добавляется прямой порядок
     * сортировки
     *
     * @param message строка и уровнель значимости, передается единым сообщением
     * @param messages остальной текст
     */
    public void log(Message message, String... messages) {
        log(message, OrderedMessageService.ASC, messages);
    }

    /**
     * Метод для сообщений с порядком сортировки. По умоляанию добавялется ворядок сортировки сообщений
     *
     * @param message строка и уровнель значимости, передается единым сообщением
     * @param order порядок сортировки сообщений
     * @param messages остальной текст
     */
    public void log(Message message, OrderedMessageService order, String... messages) {
        log(message, order, DistinctedMessageService.DOUBLES, messages);
    }

    /**
     * Метод для сообщений со всем и параметрами
     *
     * @param message строка и уровнель значимости, передается единым сообщением
     * @param order порядок сортировки сообщений
     * @param doubling режим печати сообщений. С дублированием и без
     * @param messages остальной текст
     */

    public void log(Message message, OrderedMessageService order, DistinctedMessageService doubling,
        String... messages) {
        String[] MessageConcatenation = getMessageConcatenation(message, messages);
        String[] refactoredMessages = doubling.setDoublingType(MessageConcatenation);
        String[] sortedMessages = order.sortMessages(refactoredMessages);
        printer.printMessages(message.getLevel(), sortedMessages);
    }

    /**
     * Класс, объединяющий все сообщения в один массив
     *
     * @param message сообщения
     * @param messages сообщения
     * @return массив сообщений
     */
    private String[] getMessageConcatenation(Message message, String[] messages) {
        return Stream.concat(Stream.of(message.getBody()), Stream.of(messages)).toArray(String[]::new);
    }

}
