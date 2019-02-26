package com.example.yo_job;

public class Job {

    private String date;
    private String title;
    private String salary;
    private String duration;
    private String location;
    private String description;
    private String employer;

    public Job (String date, String title, String salary, String duration, String location, String description, String employer) {
        this.date = date;
        this.title = title;
        this.salary = salary;
        this.duration = duration;
        this.location = location;
        this.description = description;
        this.employer = employer;
    }

    public String getDate() { return date; }

    public String getTitle() { return title; }

    public String getSalary() { return salary; }

    public String getDuration() { return duration; }

    public String getLocation() { return location; }

    public String getDescription() { return description; }

    public String getEmployer() { return employer; }
}
