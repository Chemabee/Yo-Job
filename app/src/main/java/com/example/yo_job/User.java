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
}
