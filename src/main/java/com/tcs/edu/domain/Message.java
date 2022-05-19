package com.tcs.edu.domain;

public class Message {

    private final SeverityLevel level;
    private final String body;

    public Message(SeverityLevel level, String body) {
        this.level = level;
        this.body = body;
    }

    public SeverityLevel getLevel() {
        return level;
    }

    public String getBody() {
        return body;
    }

}
