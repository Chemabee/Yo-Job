package com.example.yo_job;

public class User {

    private String name;
    private String surname;
    private String date_of_birth;
    private String email;

    public User(String name, String surname, String date_of_birth, String email) {
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmail() {
        return email;
    }
}
