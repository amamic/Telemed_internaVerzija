package com.bootcamp.telemedapp;

public class Patient {
    private String name;
    private String surname;
    private String email;
    private String date;

    public Patient() {
    }

    public Patient(String name, String surname, String email, String date) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
