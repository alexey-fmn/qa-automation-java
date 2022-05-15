package com.tcs.edu.printer;

public abstract class ValidatedService {

    public boolean isArgsValid(String message) {
        if (message == null) {
            return false;
        }
        if (message.isEmpty()) {
            return false;
        }
        return true;
    }
}
