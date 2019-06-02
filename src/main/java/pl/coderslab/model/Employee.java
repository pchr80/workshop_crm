package pl.coderslab.model;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String phone_nr;
    private String note;
    private double work_cost;

    public Employee(int id, String name, String surname, String phone_nr, String note, double work_cost) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone_nr = phone_nr;
        this.note = note;
        this.work_cost = work_cost;
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

    public String getPhone_nr() {
        return phone_nr;
    }

    public void setPhone_nr(String phone_nr) {
        this.phone_nr = phone_nr;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getWork_cost() {
        return work_cost;
    }

    public void setWork_cost(double work_cost) {
        this.work_cost = work_cost;
    }
}
