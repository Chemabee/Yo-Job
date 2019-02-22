package com.example.yo_job;

import java.util.LinkedList;

public class Job {

    private LinkedList<Integer> date;
    private String title;
    private float salary;
    private float duration;
    private String location;
    private String description;

    public Job (LinkedList<Integer> date, String title, float salary, float duration, String location, String description) {
        this.date = date;
        this.title = title;
        this.salary = salary;
        this.duration = duration;
        this.location = location;
        this.description = description;
    }
}
