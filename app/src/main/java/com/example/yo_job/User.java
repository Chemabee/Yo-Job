package com.example.yo_job;

import android.provider.ContactsContract;

import java.util.Date;

public class User {

    private String name;
    private String surname;
    private String date_of_birth;
    private String email;
    private String member_since;

    public User(String name, String surname, String date_of_birth, String email, String member_since) {
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.member_since = member_since;
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

    public String getMember_since() {
        return member_since;
    }
}
