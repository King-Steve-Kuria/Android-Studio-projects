package com.gakubia.assignment5;

public class Student {
    private String Firstname, Lastname, ID, Gender, Attempt, Year_of_study;

    public Student() {
    }

    public Student(String firstname, String lastname, String ID, String gender, String attempt, String year_of_study) {
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.ID = ID;
        this.Gender = gender;
        this.Attempt = attempt;
        this.Year_of_study = year_of_study;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAttempt() {
        return Attempt;
    }

    public void setAttempt(String attempt) {
        Attempt = attempt;
    }

    public String getYear_of_study() {
        return Year_of_study;
    }

    public void setYear_of_study(String year_of_study) {
        Year_of_study = year_of_study;
    }

}


