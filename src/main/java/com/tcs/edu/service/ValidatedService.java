package com.tcs.edu.service;

public class ValidatedService {

    protected boolean argsIsValid(String message) {
        if (message == null) {
            return false;
        }
        if (message.isEmpty()) {
            return false;
        }
        return true;
    }

}
