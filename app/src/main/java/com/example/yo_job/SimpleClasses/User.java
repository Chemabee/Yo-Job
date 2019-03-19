package com.example.yo_job.SimpleClasses;

import com.google.firebase.database.PropertyName;

import java.io.Serializable;

public class User implements Serializable {

    @PropertyName("name")
    private String name;
    @PropertyName("surname")
    private String surname;
    @PropertyName("date_of_birth")
    private String date_of_birth;
    @PropertyName("email")
    private String email;
    //TODO Meter siguientes variables en construcor y base de datos
    private float rating; //Carpeta en base de datos a parte con todos los ratings de cada usuario


    public User(){

    }
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
