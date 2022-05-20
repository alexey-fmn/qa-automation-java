package com.tcs.edu.decorator;

public class CountingPagingDecorator implements Decorator {

    private int messageCounter = 0;
    private final int pageSize;

    public CountingPagingDecorator() {
        this(2);
    }

    public CountingPagingDecorator(int pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public String decorate(String message) {
        messageCounter++;
        String result = String.format("%s %s", messageCounter, message);
        if (messageCounter % pageSize == 0) {
            return result + "\n---";
        }
        return result;
    }
}
