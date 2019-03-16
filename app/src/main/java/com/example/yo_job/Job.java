package com.example.yo_job;

import com.google.firebase.database.PropertyName;

import java.io.Serializable;

public class Job implements Serializable {

    @PropertyName("date")
    private String date;
    @PropertyName("title")
    private String title;
    @PropertyName("salary")
    private String salary;
    @PropertyName("duration")
    private String duration;
    @PropertyName("location")
    private String location;
    @PropertyName("description")
    private String description;
    @PropertyName("employer")
    private String employer;

    public Job(){
        date = null;
        title = null;
        salary = null;
        duration = null;
        location = null;
        description = null;
        employer = null;
    }

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

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
}
