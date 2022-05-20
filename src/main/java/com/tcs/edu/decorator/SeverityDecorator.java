package com.tcs.edu.decorator;

public class SeverityDecorator implements Decorator {

    private final String severityString;

    public SeverityDecorator(SeverityLevel level) {
        switch (level) {
            case MINOR:
                severityString = "( )";
                break;
            case REGULAR:
                severityString = "(!)";
                break;
            case MAJOR:
                severityString = "(!!!)";
            default:
                throw new RuntimeException("Неизвестный уровень серьезности");
        }
    }


    @Override
    public String decorate(String message) {
        return String.format("%s %s", severityString, message);
    }
}
