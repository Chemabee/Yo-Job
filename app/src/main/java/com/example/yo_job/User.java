package com.example.yo_job;

public class User {

    private String name;
    private String surname;
    private String date_of_birth;
    private String email;
    //TODO Meter siguientes variables en construcor y base de datos
    private float rating; //Carpeta en base de datos a parte con todos los ratings de cada usuario

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
