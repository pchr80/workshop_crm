package pl.coderslab.model;

public class Rep1Mod {
    private String name;
    private double work_hours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWork_hours() {
        return work_hours;
    }

    public void setWork_hours(double work_hours) {
        this.work_hours = work_hours;
    }

    public Rep1Mod(String name, double work_hours) {
        this.name = name;
        this.work_hours = work_hours;
    }
}
