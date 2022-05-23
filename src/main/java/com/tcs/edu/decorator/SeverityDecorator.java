package com.tcs.edu.decorator;

import com.tcs.edu.service.LogException;
import com.tcs.edu.service.ValidatedService;
import java.sql.SQLOutput;

public class SeverityDecorator extends ValidatedService implements Decorator  {

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
                break;
            default:
                throw new RuntimeException("Неизвестный уровень серьезности");
        }
    }


    @Override
    public String decorate(String message) {
            return String.format("%s %s", severityString, message);
    }
}
