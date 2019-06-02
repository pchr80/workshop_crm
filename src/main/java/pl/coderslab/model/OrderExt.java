package pl.coderslab.model;

import java.sql.Date;

public class OrderExt extends Order {
    private String status_desc;

    public String getStatus_desc() {
        return status_desc;
    }

    public void setStatus_desc(String status_desc) {
        this.status_desc = status_desc;
    }

    public OrderExt(int id, int car_id, int employee_id, Date receive_date, Date planned_start_date, Date start_date, Date end_date, String problem_desc, String repair_desc, String status_code, double repair_price, double parts_price, double man_hour, double work_hours, String status_desc) {
        super(id, car_id, employee_id, receive_date, planned_start_date, start_date, end_date, problem_desc, repair_desc, status_code, repair_price, parts_price, man_hour, work_hours);
        this.status_desc = status_desc;
    }
}
