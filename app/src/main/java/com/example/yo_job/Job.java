package com.example.yo_job;

public class Job {

    private String date;
    private String title;
    private String salary;
    private String duration;
    private String location;
    private String description;

    public Job (String date, String title, String salary, String duration, String location, String description) {
        this.date = date;
        this.title = title;
        this.salary = salary;
        this.duration = duration;
        this.location = location;
        this.description = description;
    }
}
