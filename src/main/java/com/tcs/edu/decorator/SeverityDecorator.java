package com.tcs.edu.decorator;

public class SeverityDecorator {

    /**
     * Метод-переключатель переменной. Изменяет значение переданного параметра на необходимый
     *
     * @param severity -- одно из значений
     * @return String из списка ["( )", "(!)", "(!!!)"]
     */

    public String severityDecorator(SeverityLevel severity) {
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
