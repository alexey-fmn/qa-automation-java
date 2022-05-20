package com.tcs.edu.service;

import java.util.ArrayList;

public class ValidatedService {

    protected boolean argsIsValid(ArrayList<String> messages) {
        for (String message : messages) {
            if (message == null) {
                return false;
            }
            if (message.isEmpty()) {
                return false;
            }
            return true;
        }
        return false;
    }
}
