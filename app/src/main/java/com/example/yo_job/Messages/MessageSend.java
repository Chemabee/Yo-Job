package com.example.yo_job.Messages;

import com.example.yo_job.SimpleClasses.Message;

import java.util.Map;

public class MessageSend extends Message {
    private Map time;

    public MessageSend() {
    }

    public MessageSend(Map time) {
        this.time = time;
    }

    public MessageSend(String message, String name, Map time) {
        super(message, name);
        this.time = time;
    }

    public Map getTime() {
        return time;
    }

    public void setTime(Map time) {
        this.time = time;
    }
}
