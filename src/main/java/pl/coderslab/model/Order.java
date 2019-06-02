package pl.coderslab.model;

import java.sql.Date;

public class Order {
    private int id;
    private int car_id;
    private int employee_id;
    private Date receive_date;
    private Date planned_start_date;
    private Date start_date;
    private Date end_date;
    private String problem_desc;
    private String repair_desc;
    private String status_code;
    private double repair_price;
    private double parts_price;
    private double man_hour;
    private double work_hours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Date getReceive_date() {
        return receive_date;
    }

    public void setReceive_date(Date receive_date) {
        this.receive_date = receive_date;
    }

    public Date getPlanned_start_date() {
        return planned_start_date;
    }

    public void setPlanned_start_date(Date planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getProblem_desc() {
        return problem_desc;
    }

    public void setProblem_desc(String problem_desc) {
        this.problem_desc = problem_desc;
    }

    public String getRepair_desc() {
        return repair_desc;
    }

    public void setRepair_desc(String repair_desc) {
        this.repair_desc = repair_desc;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public double getRepair_price() {
        return repair_price;
    }

    public void setRepair_price(double repair_price) {
        this.repair_price = repair_price;
    }

    public double getParts_price() {
        return parts_price;
    }

    public void setParts_price(double parts_price) {
        this.parts_price = parts_price;
    }

    public double getMan_hour() {
        return man_hour;
    }

    public void setMan_hour(double man_hour) {
        this.man_hour = man_hour;
    }

    public double getWork_hours() {
        return work_hours;
    }

    public void setWork_hours(double work_hours) {
        this.work_hours = work_hours;
    }

    public Order(int id, int car_id, int employee_id, Date receive_date, Date planned_start_date, Date start_date, Date end_date, String problem_desc, String repair_desc, String status_code, double repair_price, double parts_price, double man_hour, double work_hours) {
        this.id = id;
        this.car_id = car_id;
        this.employee_id = employee_id;
        this.receive_date = receive_date;
        this.planned_start_date = planned_start_date;
        this.start_date = start_date;
        this.end_date = end_date;
        this.problem_desc = problem_desc;
        this.repair_desc = repair_desc;
        this.status_code = status_code;
        this.repair_price = repair_price;
        this.parts_price = parts_price;
        this.man_hour = man_hour;
        this.work_hours = work_hours;
    }

    public Order(int id, int car_id, int employee_id, Date start_date, String repair_desc) {
        this.id = id;
        this.car_id = car_id;
        this.employee_id = employee_id;
        this.start_date = start_date;
        this.repair_desc = repair_desc;
    }

    public Order() {
    }
}
