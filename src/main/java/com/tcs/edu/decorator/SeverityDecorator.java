package com.tcs.edu.decorator;

import com.tcs.edu.domain.SeverityLevel;

public class SeverityDecorator {

    /**
     * Метод-переключатель переменной. Изменяет значение переданного параметра на необходимый
     *
     * @param severity -- одно из значений
     * @return String из списка ["( )", "(!)", "(!!!)"]
     */

    public String decorate(SeverityLevel severity) {
        String severityString = null;
        switch (severity) {
            case MINOR:
                severityString = "( )";
                break;
            case REGULAR:
                severityString = "(!)";
                break;
            case MAJOR:
                severityString = "(!!!)";
                break;
        }
        return severityString;
    }


}
