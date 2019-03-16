package com.example.yo_job;

public class MessageReceive extends Message {

    private Long time;

    public MessageReceive() {
    }

    public MessageReceive(Long time) {
        this.time = time;
    }

    public MessageReceive(String message, String name, Long time) {
        super(message, name);
        this.time = time;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
