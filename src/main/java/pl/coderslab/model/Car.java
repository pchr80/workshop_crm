package pl.coderslab.model;

import java.util.Date;

public class Car {
    private int id;
    private int customer_id;
    private String brand;
    private String model;
    private int prod_year;
    private String reg_nr;
    private Date review_date;

    public Car(int id, int customer_id, String brand, String model, int prod_year, String reg_nr, Date review_date) {
        this.id = id;
        this.customer_id = customer_id;
        this.brand = brand;
        this.model = model;
        this.prod_year = prod_year;
        this.reg_nr = reg_nr;
        this.review_date = review_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProd_year() {
        return prod_year;
    }

    public void setProd_year(int prod_year) {
        this.prod_year = prod_year;
    }

    public String getReg_nr() {
        return reg_nr;
    }

    public void setReg_nr(String reg_nr) {
        this.reg_nr = reg_nr;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }
}
