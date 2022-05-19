package com.tcs.edu.service;public class MessageConcatenator{	public MessageConcatenator()	{	}/**
     * Класс, объединяющий все сообщения в один массив
     *
     * @param message сообщения
     * @param messages сообщения
     * @return массив сообщений
     */
    private java.lang.String[] getMessageConcatenation(com.tcs.edu.domain.Message message, java.lang.String[] messages) {
        return java.util.stream.Stream.concat(java.util.stream.Stream.of(message.getBody()), java.util.stream.Stream.of(messages)).toArray(java.lang.String[]::new);
    }}
