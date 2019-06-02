package pl.coderslab.model;

import java.util.Date;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private Date birth_date;

    public Customer(int id, String name, String surname, Date birth_date) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
}
