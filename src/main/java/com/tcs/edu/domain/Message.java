package com.tcs.edu.domain;

import com.tcs.edu.decorator.SeverityLevel;
import java.util.Objects;
import java.util.UUID;

public class Message {

    private SeverityLevel level = SeverityLevel.REGULAR;
    private final String body;
    private UUID id;

    public Message(String body) {
        this.body = body;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return level == message.level && Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, body);
    }

    @Override
    public String toString() {
        return "{" +
            "level=" + level +
            ", body='" + body + '\'' +
            '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
