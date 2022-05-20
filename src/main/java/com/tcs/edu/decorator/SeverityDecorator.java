package com.tcs.edu.decorator;

public class SeverityDecorator implements Decorator {

    /**
     * Метод, который переключает значение переданного уровня level на читаемое знаачение и склевивает это значение с
     * сообщением.
     *
     * @param level серьезность
     * @param messages массив сообщений для декорации
     * @return массив строк
     */

    public String[] decorate(SeverityLevel level, String[] messages) {
        String[] severityMessages = new String[messages.length];

        for (int i = messages.length - 1, j = 0; i >= 0; i--, j++) {
            String severityString = null;
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
            }

            String decoratedMessage = messages[i] + " " + severityString;
            severityMessages[j] = decoratedMessage;
        }
        return severityMessages;
    }
}
